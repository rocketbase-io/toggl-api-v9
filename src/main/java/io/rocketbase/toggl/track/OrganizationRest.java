package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.OrganizationDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;

public class OrganizationRest extends BaseResourceRest implements OrganizationResource {
    
    public OrganizationRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor) {
        super(togglConfig, interceptor);
    }

    @Override
    public OrganizationDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/organizations/{id}").build(id), new ParameterizedTypeReference<OrganizationDto>() {
        }).getBody();
    }
}
