package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class ProjectDto {

    private long id;

    @JsonProperty("workspace_id")
    private Long workspaceId;
    private Long wid;

    @JsonProperty("client_id")
    private Long clientId;
    private Long cid;

    private String name;

    @JsonProperty("is_private")
    private boolean isPrivate;

    private boolean active;

    private OffsetDateTime at;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("server_deleted_at")
    private OffsetDateTime serverDeletedAt;

    private String color;
    private boolean billable;
    private boolean template;

    @JsonProperty("auto_estimates")
    private boolean autoEstimates;

    @JsonProperty("estimated_hours")
    private Integer estimatedHours;

    @JsonProperty("estimated_seconds")
    private Integer estimatedSeconds;

    private BigDecimal rate;

    @JsonProperty("rate_last_updated")
    private OffsetDateTime rateLastUpdated;

    private String currency;
    private boolean recurring;

    @JsonProperty("template_id")
    private Long templateId;

    @JsonProperty("recurring_parameters")
    private Object recurringParameters;

    @JsonProperty("fixed_fee")
    private BigDecimal fixedFee;

    @JsonProperty("actual_hours")
    private Integer actualHours;

    @JsonProperty("actual_seconds")
    private Integer actualSeconds;

    @JsonProperty("can_track_time")
    private boolean canTrackTime;

    @JsonProperty("start_date")
    private LocalDate startDate;

    private String status;

    private String permissions;

    @JsonProperty("is_shared")
    private boolean isShared;

}