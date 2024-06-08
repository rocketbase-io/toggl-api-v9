package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.ClientDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

public class ClientRest extends BaseResourceRest implements ClientResource {
    protected final Long workspaceId;

    public ClientRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor, Long workspaceId) {
        super(togglConfig, interceptor);
        this.workspaceId = workspaceId;
    }

    @Override
    public List<ClientDto> list() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/clients").build(workspaceId),
                new ParameterizedTypeReference<List<ClientDto>>() {
                }).getBody();
    }

    @Override
    public ClientDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/clients/{id}").build(workspaceId, id),
                new ParameterizedTypeReference<ClientDto>() {
                }).getBody();
    }

    @Override
    public ClientDto create(ClientDto clientDto) {
        return performWithBody(HttpMethod.POST, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/clients").build(workspaceId),
                clientDto,
                new ParameterizedTypeReference<ClientDto>() {
                }).getBody();
    }

    @Override
    public ClientDto update(Long id, ClientDto clientDto) {
        return performWithBody(HttpMethod.PUT, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/clients/{id}").build(workspaceId, id),
                clientDto,
                new ParameterizedTypeReference<ClientDto>() {
                }).getBody();
    }

    @Override
    public void delete(Long id) {
        performVoid(HttpMethod.DELETE, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/clients/{id}").build(workspaceId, id));
    }

    @Override
    public void archive(Long id) {
        performVoid(HttpMethod.POST, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/clients/{id}/archive").build(workspaceId, id));
    }
}
