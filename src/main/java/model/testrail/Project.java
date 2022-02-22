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
public class Project {

  @JsonProperty
  private final Integer id;

  @JsonProperty
  private final String name;

  @JsonProperty
  private final String announcement;

  @JsonProperty("show_announcement")
  private final Boolean showAnnouncement;

  @JsonProperty("is_completed")
  private final Boolean isCompleted;

  @JsonProperty("completed_on")
  private final Integer completedOn;

  @JsonProperty("suite_mode")
  private final Integer suiteMode;

  @JsonProperty
  private final String url;
}
