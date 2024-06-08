package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.TagDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

public class TagRest extends BaseResourceRest implements TagResource {

    protected final Long workspaceId;

    public TagRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor, Long workspaceId) {
        super(togglConfig, interceptor);
        this.workspaceId = workspaceId;
    }

    @Override
    public List<TagDto> list() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/tags").build(workspaceId),
                new ParameterizedTypeReference<List<TagDto>>() {
                }).getBody();
    }

    @Override
    public TagDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/tags/{id}").build(workspaceId, id),
                new ParameterizedTypeReference<TagDto>() {
                }).getBody();
    }

    @Override
    public TagDto create(TagDto tagDto) {
        return performWithBody(HttpMethod.POST, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/tags").build(workspaceId),
                tagDto,
                new ParameterizedTypeReference<TagDto>() {
                }).getBody();
    }

    @Override
    public TagDto update(Long id, TagDto tagDto) {
        return performWithBody(HttpMethod.PUT, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/tags/{id}").build(workspaceId, id),
                tagDto,
                new ParameterizedTypeReference<TagDto>() {
                }).getBody();
    }

    @Override
    public void delete(Long id) {
        performVoid(HttpMethod.DELETE, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/tags/{id}").build(workspaceId, id));
    }
}
