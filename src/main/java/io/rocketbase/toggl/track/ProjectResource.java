package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.ProjectDto;

import java.util.List;

public interface ProjectResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects
     */
    List<ProjectDto> list();

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{id}
     */
    ProjectDto get(Long id);

    /**
     * [POST] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects
     */
    ProjectDto create(ProjectDto projectDto);

    /**
     * [PUT] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{id}
     */
    ProjectDto update(Long id, ProjectDto projectDto);


    /**
     * [DELETE] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{id}
     */
    void delete(Long id);
}
