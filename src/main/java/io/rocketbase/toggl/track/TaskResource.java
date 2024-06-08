package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.TaskDto;

import java.util.List;

public interface TaskResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks
     */
    List<TaskDto> list();

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks/{id}
     */
    TaskDto get(Long id);

    /**
     * [POST] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks
     */
    TaskDto create(TaskDto taskDto);

    /**
     * [PUT] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks/{id}
     */
    TaskDto update(Long id, TaskDto taskDto);


    /**
     * [DELETE] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks/{id}
     */
    void delete(Long id);
}
