package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class OrganizationDto {

    private Long id;
    private String name;

    @JsonProperty("pricing_plan_id")
    private Long pricingPlanId;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    
    private OffsetDateTime at;

    @JsonProperty("server_deleted_at")
    private OffsetDateTime serverDeletedAt;

    @JsonProperty("is_multi_workspace_enabled")
    private boolean isMultiWorkspaceEnabled;

    @JsonProperty("suspended_at")
    private OffsetDateTime suspendedAt;

    @JsonProperty("user_count")
    private Integer userCount;

    @JsonProperty("is_unified")
    private boolean isUnified;

    @JsonProperty("max_workspaces")
    private int maxWorkspaces;

    private String permissions;
    private boolean admin;
    private boolean owner;

    @JsonProperty("pricing_plan_name")
    private String pricingPlanName;

    @JsonProperty("pricing_plan_enterprise")
    private boolean pricingPlanEnterprise;

}
