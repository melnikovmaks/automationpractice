package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum TestRailStatus {
  PASSED(1),
  BLOCKED(2),
  UNTESTED(3),
  RETEST(4),
  FAILED(5),
  SKIPPED(6);

  private final int id;
}
