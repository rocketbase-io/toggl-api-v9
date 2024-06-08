package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class WorkspaceDto {
    private Long id;

    @JsonProperty("organization_id")
    private Long organizationId;

    private String name;
    private Long profile;
    private boolean premium;

    @JsonProperty("business_ws")
    private boolean businessWs;

    private boolean admin;
    private String role;

    @JsonProperty("suspended_at")
    private OffsetDateTime suspendedAt;

    @JsonProperty("server_deleted_at")
    private OffsetDateTime serverDeletedAt;

    @JsonProperty("default_hourly_rate")
    private BigDecimal defaultHourlyRate;

    @JsonProperty("rate_last_updated")
    private OffsetDateTime rateLastUpdated;

    @JsonProperty("default_currency")
    private String defaultCurrency;

    @JsonProperty("only_admins_may_create_projects")
    private boolean onlyAdminsMayCreateProjects;

    @JsonProperty("only_admins_may_create_tags")
    private boolean onlyAdminsMayCreateTags;

    @JsonProperty("only_admins_see_billable_rates")
    private boolean onlyAdminsSeeBillableRates;

    @JsonProperty("only_admins_see_team_dashboard")
    private boolean onlyAdminsSeeTeamDashboard;

    @JsonProperty("projects_billable_by_default")
    private boolean projectsBillableByDefault;

    @JsonProperty("projects_private_by_default")
    private boolean projectsPrivateByDefault;

    @JsonProperty("last_modified")
    private OffsetDateTime lastModified;

    @JsonProperty("reports_collapse")
    private boolean reportsCollapse;

    private Integer rounding;

    @JsonProperty("rounding_minutes")
    private Integer roundingMinutes;

    @JsonProperty("api_token")
    private String apiToken;

    private OffsetDateTime at;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("ical_url")
    private String icalUrl;

    @JsonProperty("ical_enabled")
    private boolean icalEnabled;

    @JsonProperty("hide_start_end_times")
    private boolean hideStartEndTimes;

    @JsonProperty("working_hours_in_minutes")
    private Integer workingHoursInMinutes;

    private String permissions;

    @JsonProperty("active_project_count")
    private Integer activeProjectCount;

}