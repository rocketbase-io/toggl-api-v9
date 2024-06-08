package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class TagDto {

    private Long id;

    @JsonProperty("workspace_id")
    private Long workspaceId;

    private String name;
    
    private OffsetDateTime at;

    @JsonProperty("creator_id")
    private Long creatorId;

    private String permissions;
}
