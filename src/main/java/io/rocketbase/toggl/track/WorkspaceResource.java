package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.WorkspaceDto;

import java.util.List;

public interface WorkspaceResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces
     */
    List<WorkspaceDto> list();

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{id}
     */
    WorkspaceDto get(Long id);
}
