package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class TaskDto {
    private Long id;
    private String name;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    @JsonProperty("project_id")
    private Long projectId;

    @JsonProperty("user_id")
    private Long userId;

    private boolean recurring;
    private boolean active;

    private OffsetDateTime at;

    @JsonProperty("server_deleted_at")
    private OffsetDateTime serverDeletedAt;

    @JsonProperty("estimated_seconds")
    private Long estimatedSeconds;

    @JsonProperty("tracked_seconds")
    private Long trackedSeconds;

    private String permissions;
}
