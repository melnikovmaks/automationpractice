package base.testrail;

import java.util.Date;
import java.util.Optional;

import enums.TestRailStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import service.TestRailManagerClient;
import service.impl.TestRailRailClient;

import static base.BaseTest.CONFIG;

@Slf4j
public class TestRailExtension implements AfterTestExecutionCallback, BeforeAllCallback {

  private static final String APPLICATION_NAME = "BROKER";
  private static final String SUITE_NAME = "automationPractice";
  private static final String AUTOMATION_TEST_NAME = "BROKER functional automated tests run " + new Date();
  private static final String AUTOMATION_TEST_DESCRIPTION = "Automation run";

  private static volatile Integer runId;
  private static volatile TestRailManagerClient testManagerService;

  @Override
  public void beforeAll(ExtensionContext extensionContext) {
    try {
      if (testManagerService == null) {
        testManagerService = TestRailRailClient.builder()
            .applicationName(APPLICATION_NAME)
            .suiteName(SUITE_NAME)
            .build();
        System.out.println(testManagerService);
        if (CONFIG.isRemoteType()) {
          runId = testManagerService.createRun(AUTOMATION_TEST_NAME, AUTOMATION_TEST_DESCRIPTION);
        }
      }
    } catch (Exception error) {
      log.warn("TestRail testManagerService is not initialized", error);
    }
  }

  @Override
  public void afterTestExecution(final ExtensionContext context) {
    if (testManagerService == null) {
      log.error("Assertion exception testManagerService=[{}], runId=[{}]", testManagerService, runId);
      throw new IllegalStateException("testManagerService is not initialise");
    }
    if (runId != null) {
      try {
        final Optional<Throwable> exception = context.getExecutionException();
        final TestRailStatus testRailStatus = exception.isPresent() ? TestRailStatus.FAILED : TestRailStatus.PASSED;
        final String exceptionMessage = exception.isPresent() ? exception.get().getMessage() : StringUtils.EMPTY;
        final String displayName =
            context.getElement()
                .map(element -> element.getAnnotation(DisplayName.class).value())
                .orElseThrow(() -> new IllegalArgumentException("There is no DisplayName annotation"));

        testManagerService.addResult(testRailStatus, exceptionMessage, displayName, displayName, runId);
      } catch (final Exception error) {
        log.warn("TestRail Service not available", error);
      }
    }
  }
}
