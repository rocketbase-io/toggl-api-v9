package io.rocketbase.toggl.report.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class DetailFilter {
    /**
     * Whether the time entry is set as billable, optional, premium feature.
     */
    private Boolean billable;
    /**
     * Client IDs, optional, filtering attribute. To filter records with no clients, use [null].
     */
    @JsonProperty("client_ids")
    private List<Long> clientIds;
    /**
     * Description, optional, filtering attribute.
     */
    private String description;
    /**
     * End date, example time.DateOnly. Should be greater than Start date.<br>
     * Maximum allowed date range is 366 days
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("end_date")
    private LocalDate endDate;
    /**
     * Start date, example time.DateOnly. Should be less than End date.<br>
     * Maximum allowed date range is 366 days
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("start_date")
    private LocalDate startDate;

    /**
     * EnrichResponse, optional, default false. It will force the detailed report to return as much information as possible, as it does for the export.
     */
    @Builder.Default
    @JsonProperty("enrich_response")
    private Boolean enrichResponse = false;

    @JsonProperty("first_id")
    private Integer firstId;

    @JsonProperty("first_row_number")
    private Integer firstRowNumber;

    @JsonProperty("first_timestamp")
    private Integer firstTimestamp;
    /**
     * Group IDs, optional, filtering attribute.
     */
    @JsonProperty("group_ids")
    private List<Long> groupIds;
    /**
     * Whether time entries should be grouped, optional, default false.<br>
     * when active the list of time_entries could be greater than 1 ;)
     */
    @Builder.Default
    private Boolean grouped = false;
    /**
     * Whether amounts should be hidden, optional, default false.
     */
    @JsonProperty("hide_amounts")
    private Boolean hideAmounts;
    /**
     * Order by field, optional, default "date". Can be "date", "user", "duration", "description" or "last_update".
     */
    @Builder.Default
    @JsonProperty("order_by")
    private OrderByProperty orderBy = OrderByProperty.DATE;
    /**
     * Order direction, optional. Can be ASC or DESC.
     */
    @Builder.Default
    @JsonProperty("order_dir")
    private OrderDirection orderDir = OrderDirection.ASC;
    /**
     * PageSize defines the number of items per page, optional, default 50.
     */
    @Builder.Default
    @JsonProperty("page_size")
    private Integer pageSize = 50;

    /**
     * Project IDs, optional, filtering attribute. To filter records with no projects, use [null].
     */
    @JsonProperty("project_ids")
    private List<Long> projectIds;
    /**
     * Whether time should be rounded, optional, default from user preferences.
     */
    private Boolean rounding;
    /**
     * Rounding minutes value, optional, default from user preferences. Should be 0, 1, 5, 6, 10, 12, 15, 30, 60 or 240.
     */
    @JsonProperty("rounding_minutes")
    private RoundingMinutes roundingMinutes;
    /**
     * Tag IDs, optional, filtering attribute. To filter records with no tags, use [null].
     */
    @JsonProperty("tag_ids")
    private List<Long> tagIds;
    /**
     * Task IDs, optional, filtering attribute. To filter records with no tasks, use [null].
     */
    @JsonProperty("task_ids")
    private List<Long> taskIds;
    /**
     * TimeEntryIDs filters by time entries. This was added to support retro-compatibility with reports v2.
     */
    @JsonProperty("time_entry_ids")
    private List<Long> timeEntryIds;
    /**
     * User IDs, optional, filtering attribute.
     */
    @JsonProperty("user_ids")
    private List<Long> userIds;


}
