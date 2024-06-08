package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.ProjectDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

public class ProjectRest extends BaseResourceRest implements ProjectResource {

    protected final Long workspaceId;

    public ProjectRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor, Long workspaceId) {
        super(togglConfig, interceptor);
        this.workspaceId = workspaceId;
    }

    @Override
    public List<ProjectDto> list() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects").build(workspaceId),
                new ParameterizedTypeReference<List<ProjectDto>>() {
                }).getBody();
    }

    @Override
    public ProjectDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{id}").build(workspaceId, id),
                new ParameterizedTypeReference<ProjectDto>() {
                }).getBody();
    }

    @Override
    public ProjectDto create(ProjectDto projectDto) {
        return performWithBody(HttpMethod.POST, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects").build(workspaceId),
                projectDto,
                new ParameterizedTypeReference<ProjectDto>() {
                }).getBody();
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        return performWithBody(HttpMethod.PUT, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{id}").build(workspaceId, id),
                projectDto,
                new ParameterizedTypeReference<ProjectDto>() {
                }).getBody();
    }

    @Override
    public void delete(Long id) {
        performVoid(HttpMethod.DELETE, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/projects/{id}").build(workspaceId, id));
    }
}
