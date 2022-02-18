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
public class Suite {

  @JsonProperty
  private final Integer id;

  @JsonProperty
  private final String name;

  @JsonProperty
  private final String description;

  @JsonProperty("project_id")
  private final Integer projectId;

  @JsonProperty("is_master")
  private final Boolean isMaster;

  @JsonProperty("is_baseline")
  private final Boolean isBaseline;

  @JsonProperty("is_completed")
  private final Boolean isCompleted;

  @JsonProperty("completed_on")
  private final String completedOn;

  @JsonProperty
  private final String url;
}