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
public class CasePage {

  @JsonProperty
  private final Integer offset;

  @JsonProperty
  private final Integer limit;

  @JsonProperty
  private final Integer size;

  @JsonProperty("_links")
  private final PageLinks links;

  @JsonProperty
  private final List<Case> cases;
}