package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.WorkspaceDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

public class WorkspaceRest extends BaseResourceRest implements WorkspaceResource {

    public WorkspaceRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor) {
        super(togglConfig, interceptor);
    }

    @Override
    public List<WorkspaceDto> list() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces").build(),
                new ParameterizedTypeReference<List<WorkspaceDto>>() {
                }).getBody();
    }

    @Override
    public WorkspaceDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{id}").build(id),
                new ParameterizedTypeReference<WorkspaceDto>() {
                }).getBody();
    }
}
