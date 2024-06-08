package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.MeDto;
import io.rocketbase.toggl.track.dto.OrganizationDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

public class MeRest extends BaseResourceRest implements MeResource {
    
    public MeRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor) {
        super(togglConfig, interceptor);
    }

    @Override
    public MeDto get() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/me").build(),
                new ParameterizedTypeReference<MeDto>() {
                }).getBody();
    }

    @Override
    public List<OrganizationDto> organizations() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/me/organizations").build(),
                new ParameterizedTypeReference<List<OrganizationDto>>() {
                }).getBody();
    }
}
