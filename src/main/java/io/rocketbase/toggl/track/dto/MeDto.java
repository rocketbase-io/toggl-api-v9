package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class MeDto {

    private Long id;

    @JsonProperty("api_token")
    private String apiToken;

    private String email;
    private String fullname;
    private String timezone;

    @JsonProperty("toggl_accounts_id")
    private String togglAccountsId;

    @JsonProperty("default_workspace_id")
    private Long defaultWorkspaceId;

    @JsonProperty("beginning_of_week")
    private Integer beginningOfWeek;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty("openid_email")
    private String openidEmail;

    @JsonProperty("openid_enabled")
    private boolean openidEnabled;

    @JsonProperty("country_id")
    private Integer countryId;

    @JsonProperty("has_password")
    private boolean hasPassword;

    private OffsetDateTime at;

    @JsonProperty("intercom_hash")
    private String intercomHash;

    @JsonProperty("authorization_updated_at")
    private OffsetDateTime authorizationUpdatedAt;
}
