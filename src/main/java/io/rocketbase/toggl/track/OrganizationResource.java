package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.OrganizationDto;

public interface OrganizationResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/organizations/{id}
     */
    OrganizationDto get(Long id);
}
