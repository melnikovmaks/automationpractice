package service.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import enums.TestRailStatus;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import model.config.TestConfig;
import model.testrail.Case;
import model.testrail.CasePage;
import model.testrail.Project;
import model.testrail.ProjectPage;
import model.testrail.Result;
import model.testrail.RunResponse;
import model.testrail.Runs;
import model.testrail.Suite;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NotFoundException;
import service.TestRailManagerClient;
import utils.TestConfigSettings;

@Slf4j
public class TestRailRailClient implements TestRailManagerClient {

  private static final String GET_PROJECTS_URI = "/api/v2/get_projects";
  private static final String GET_SUITES_URI = "/api/v2/get_suites/";
  private static final String GET_CASES_URI = "/api/v2/get_cases/";
  private static final String ADD_RUN_URI = "/api/v2/add_run/";
  private static final String ADD_RESULT_FOR_CASE_URI = "/api/v2/add_result_for_case/";

  private static final int LIMIT_DEFECT_STRING = 250;

  private static final String applicationName = "Automationpractice";
  private final BasicAuthApiClient apiClient;
  private final Integer projectId;
  private final Integer suiteId;

  @Override
  public void addResult(
      final TestRailStatus testRailStatus,
      final String defects,
      final String comment,
      final String caseTitle,
      final Integer runId
  ) throws Exception {
    final Result result = Result.builder()
        .statusId(testRailStatus.getId())
        .comment(comment)
        .defects(StringUtils.defaultIfEmpty(
            StringUtils.abbreviate(defects, 0, LIMIT_DEFECT_STRING), ""))
        .build();

    if (StringUtils.isNotBlank(defects)) {
      log.warn("TestRail result. Case: [{}], Defect: [{}]", caseTitle, defects);
    }

    this.apiClient.sendPost(
        ADD_RESULT_FOR_CASE_URI + runId + "/" + this.getCaseIdByTitle(
            this.projectId, this.suiteId, caseTitle),
        result,
        Result.class
    );
  }

  @Override
  public Integer createRun(
      final String automationTestName,
      final String automationTestDescription
  ) throws Exception {
    if (this.suiteId == null) {
      throw new IllegalArgumentException("Please add suiteName to TestRailService builder");
    }
    final Runs runs = Runs.builder()
        .suiteId(this.suiteId)
        .name(applicationName)
        .description(automationTestDescription)
        .includeAll(true)
        .build();

    return this.apiClient.sendPost(
        ADD_RUN_URI + this.projectId,
        runs,
        RunResponse.class
    ).getId();
  }

  private Integer getCaseIdByTitle(
      final Integer projectId,
      final Integer suiteId,
      final String title
  ) throws Exception {
    return getCaseIdByTitle(
        GET_CASES_URI +
            projectId + "&suite_id=" +
            suiteId + "&filter=" +
            URLEncoder.encode(title, StandardCharsets.UTF_8), title);
  }

  private Integer getCaseIdByTitle(
      final String url,
      final String title
  ) throws Exception {
    final CasePage casePage = this.apiClient.sendGet(url, CasePage.class);
    final Integer id = casePage.getCases()
        .stream()
        .filter(c -> title.equals(c.getTitle()))
        .findFirst()
        .map(Case::getId)
        .orElse(null);
    if (casePage.getLinks().getNext() != null && id == null) {
      return getCaseIdByTitle(casePage.getLinks().getNext(), title);
    }
    if (id == null) {
      throw new NotFoundException("No such case found.");
    }
    return id;
  }

  private Integer getProjectIdByName(final String name) throws Exception {
    return getProjectIdByName(GET_PROJECTS_URI, name);
  }

  private Integer getProjectIdByName(
      final String url,
      final String name
  ) throws Exception {
    final ProjectPage projectPage = this.apiClient.sendGet(url, ProjectPage.class);
    final Integer id = projectPage
        .getProjects()
        .stream()
        .filter(item -> StringUtils.containsIgnoreCase(item.getName(), name))
        .findFirst()
        .map(Project::getId)
        .orElse(null);
    if (projectPage.getLinks().getNext() != null && id == null) {
      return getProjectIdByName(projectPage.getLinks().getNext(), name);
    }
    if (id == null) {
      throw new NotFoundException("No such project found.");
    }
    return id;
  }

  private Integer getSuiteIdByName(
      final Integer projectId,
      final String suiteName
  ) throws Exception {
    if (projectId == null) {
      throw new NotFoundException("There are no projectId. Please set application name before suiteName");
    }
    return Stream.of(this.apiClient.sendGet(
            GET_SUITES_URI + projectId,
            Suite[].class
        ))
        .filter(item -> StringUtils.containsIgnoreCase(item.getName(), suiteName))
        .findFirst()
        .map(Suite::getId)
        .orElseThrow(() -> new NotFoundException("No such suite found."));
  }

  @Builder
  private TestRailRailClient(
      final String applicationName,
      final String suiteName
  ) {
    final TestConfig config = TestConfigSettings.getInstance().getTestConfig();
    this.apiClient = BasicAuthApiClient.builder()
        .url(config.getTestRailUrl())
        .user(config.getTestRailUsername())
        .password(config.getTestRailApiKey())
        .build();

    try {
      this.projectId = getProjectIdByName(applicationName);
      this.suiteId = getSuiteIdByName(this.projectId, suiteName);
    } catch (final Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
