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
public class User {

  @JsonProperty
  private String name;

  @JsonProperty
  private Integer id;

  @JsonProperty
  private String email;

  @JsonProperty("is_active")
  private Boolean isActive;

  @JsonProperty("role_id")
  private Integer roleId;

  @JsonProperty
  private String role;
}
