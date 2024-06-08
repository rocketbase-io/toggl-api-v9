package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.TaskDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

public class TaskRest extends BaseResourceRest implements TaskResource {

    protected final Long workspaceId;
    protected final Long projectId;

    public TaskRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor,
                    Long workspaceId, Long projectId) {
        super(togglConfig, interceptor);
        this.workspaceId = workspaceId;
        this.projectId = projectId;
    }

    @Override
    public List<TaskDto> list() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks").build(workspaceId, projectId),
                new ParameterizedTypeReference<List<TaskDto>>() {
                }).getBody();
    }

    @Override
    public TaskDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks/{id}").build(workspaceId, projectId, id),
                new ParameterizedTypeReference<TaskDto>() {
                }).getBody();
    }

    @Override
    public TaskDto create(TaskDto taskDto) {
        return performWithBody(HttpMethod.POST, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks").build(workspaceId, projectId),
                taskDto,
                new ParameterizedTypeReference<TaskDto>() {
                }).getBody();
    }

    @Override
    public TaskDto update(Long id, TaskDto taskDto) {
        return performWithBody(HttpMethod.PUT, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks/{id}").build(workspaceId, projectId, id),
                taskDto,
                new ParameterizedTypeReference<TaskDto>() {
                }).getBody();
    }

    @Override
    public void delete(Long id) {
        performVoid(HttpMethod.DELETE, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{projectId}/tasks/{id}").build(workspaceId, projectId, id));
    }
}
