package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
public class ClientDto {

    private Long id;
    private Long wid;
    private boolean archived;
    private String name;

    private OffsetDateTime at;

    private String notes;

    @JsonProperty("creator_id")
    private Long creatorId;

    private String permissions;

}