package model.testrail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Result {

  @JsonProperty("status_id")
  private final Integer statusId;

  @JsonProperty
  private final String comment;

  @JsonProperty
  private final String defects;

  @JsonProperty("assignedto_id")
  private final Integer assignedToId;
}
