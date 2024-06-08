package io.rocketbase.toggl.track.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class UserDto {

    private Long id;
    private Long uid;
    private Long wid;
    private boolean admin;
    private boolean active;
    private String email;
    private String timezone;
    private boolean inactive;

    private OffsetDateTime at;

    private String name;
    private List<Long> groupIds;
    private BigDecimal rate;

    @JsonProperty("rate_last_updated")
    private OffsetDateTime rateLastUpdated;

    @JsonProperty("labour_cost")
    private BigDecimal labourCost;

    @JsonProperty("invite_url")
    private String inviteUrl;

    @JsonProperty("invitation_code")
    private String invitationCode;

    @JsonProperty("avatar_file_name")
    private String avatarFileName;

    @JsonProperty("working_hours_in_minutes")
    private Integer workingHoursInMinutes;

    private String role;

}