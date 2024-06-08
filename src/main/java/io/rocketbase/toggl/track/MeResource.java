package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.MeDto;
import io.rocketbase.toggl.track.dto.OrganizationDto;

import java.util.List;

public interface MeResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/me
     */
    MeDto get();

    /**
     * [GET] https://api.track.toggl.com/api/v9/me/organizations
     */
    List<OrganizationDto> organizations();
}
