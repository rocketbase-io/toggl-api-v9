package io.rocketbase.toggl.report.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Nullable are only filled in case filter has enabled enrichResponse
 */
@Data
@NoArgsConstructor
@SuperBuilder
public class DetailedTimeEntry {


    @JsonProperty("user_id")
    private Long userId;

    private String username;

    @Nullable
    private String email;

    @JsonProperty("project_id")
    private Long projectId;

    @Nullable
    @JsonProperty("project_name")
    private String projectName;

    @Nullable
    @JsonProperty("project_color")
    private String projectColor;

    @Nullable
    @JsonProperty("project_hex")
    private String projectHex;

    @Nullable
    @JsonProperty("client_name")
    private String clientName;

    @JsonProperty("task_id")
    private Long taskId;

    @Nullable
    @JsonProperty("task_name")
    private String taskName;

    private Boolean billable;

    private String description;

    @JsonProperty("tag_ids")
    private List<Long> tagIds;

    @Nullable
    @JsonProperty("billable_amount_in_cents")
    private BigDecimal billableAmountInCents;

    @Nullable
    @JsonProperty("hourly_rate_in_cents")
    private BigDecimal hourlyRateInCents;

    private String currency;

    @JsonProperty("time_entries")
    private List<TimeEntryDetail> timeEntries;

    @JsonProperty("row_number")
    private Long rowNumber;

    @Data
    @NoArgsConstructor
    @SuperBuilder
    public static class TimeEntryDetail {

        private Long id;

        private Long seconds;

        private OffsetDateTime start;

        private OffsetDateTime stop;

        private OffsetDateTime at;
    }
}
