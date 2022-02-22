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
public class Case {

  @JsonProperty
  private final Integer id;

  @JsonProperty
  private final String title;

  @JsonProperty("section_id")
  private final Integer sectionId;

  @JsonProperty("template_id")
  private final Integer templateId;

  @JsonProperty("type_id")
  private final Integer typeId;

  @JsonProperty("priority_id")
  private final Integer priorityId;

  @JsonProperty("milestone_id")
  private final Integer milestoneId;

  @JsonProperty("created_by")
  private final Integer createdBy;

  @JsonProperty("created_on")
  private final String createdOn;

  @JsonProperty("suite_id")
  private final Integer suiteId;

  @JsonProperty("display_order")
  private final String displayOrder;

  @JsonProperty("custom_automation_type")
  private final String customAutomationType;

  @JsonProperty("custom_mission")
  private final String customMission;
}
