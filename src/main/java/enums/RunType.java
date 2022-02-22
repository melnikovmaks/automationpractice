package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum RunType {
  LOCAL("local"),
  REMOTE("remote");

  private final String value;
}
