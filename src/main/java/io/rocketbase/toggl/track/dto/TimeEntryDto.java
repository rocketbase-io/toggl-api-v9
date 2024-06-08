package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class TimeEntryDto {

    private Long id;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("project_id")
    private Long projectId;

    @JsonProperty("task_id")
    private Long taskId;

    private boolean billable;

    private OffsetDateTime start;

    private OffsetDateTime stop;

    private Long duration;

    private String description;

    private List<String> tags;
    @JsonProperty("tag_ids")
    private List<Long> tagIds;

    private boolean duronly;

    private OffsetDateTime at;

    @JsonProperty("server_deleted_at")
    private OffsetDateTime serverDeletedAt;

    @JsonProperty("user_id")
    private long userId;

    private String permissions;

}