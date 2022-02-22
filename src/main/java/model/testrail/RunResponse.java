package model.testrail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunResponse {

  @JsonProperty
  private final Integer id;

  @JsonProperty("suite_id")
  private final Integer suiteId;

  @JsonProperty
  private final String name;

  @JsonProperty("assignedto_id")
  private final Integer assignedtoId;

  @JsonProperty("refs")
  private final String refs;

  @JsonProperty("include_all")
  private final Boolean includeAll;

  @JsonProperty("case_id")
  private final List<String> caseIds;
}
