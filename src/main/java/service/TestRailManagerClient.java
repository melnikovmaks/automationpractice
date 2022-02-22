package service;

import enums.TestRailStatus;

public interface TestRailManagerClient {

  /** Save result of test execution to tes manager platform.
   * @param testRailStatus - status of test execution
   * @param defects - defects of test if exists
   * @param comment - comment to test
   * @param caseTitle - identifier of test
   * @param runId - id of execution
   * @throws Exception - Exception
   */
  void addResult(
      final TestRailStatus testRailStatus,
      final String defects,
      final String comment,
      final String caseTitle,
      final Integer runId
  ) throws Exception;

  /** Create and Get runId for suitTest.
   * @param automationTestName - automation test name
   * @param automationTestDescription - automation test description
   * @return runId
   * @throws Exception - Exception
   */
  Integer createRun(
      final String automationTestName,
      final String automationTestDescription
  ) throws Exception;
}
