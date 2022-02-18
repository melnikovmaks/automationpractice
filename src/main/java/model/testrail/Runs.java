package model.testrail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class Runs {

  @JsonProperty("suite_id")
  private final Integer suiteId;

  @JsonProperty
  private final String name;

  @JsonProperty
  private final String description;

  @JsonProperty("milestone_id")
  private final Integer milestoneId;

  @JsonProperty("assignedto_id")
  private final Integer assignedtoId;

  @JsonProperty("include_all")
  private final Boolean includeAll;
}
