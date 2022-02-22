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
public class ResultResponse {

  @JsonProperty("id")
  private final Integer id;

  @JsonProperty("test_id")
  private final Integer testId;

  @JsonProperty("status_id")
  private final Integer statusId;

  @JsonProperty("assignedto_id")
  private final Integer assignedtoId;

  @JsonProperty("comment")
  private final String comment;

  @JsonProperty("defects")
  private final String defects;

  @JsonProperty("attachment_ids")
  private final List<String> attachmentIds;
}
