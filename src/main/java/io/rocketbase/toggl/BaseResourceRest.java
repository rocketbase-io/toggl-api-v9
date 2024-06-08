package io.rocketbase.toggl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.function.Function;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseResourceRest {

    protected final TogglConfig togglConfig;
    protected final ClientHttpRequestInterceptor interceptor;

    RestClient.RequestBodySpec buildBase(HttpMethod method, Function<UriBuilder, URI> uriFunction) {
        return RestClient.builder()
                .defaultHeaders(httpHeaders -> httpHeaders.add(HttpHeaders.ACCEPT, MimeTypeUtils.APPLICATION_JSON_VALUE))
                .requestInterceptor(interceptor)
                .baseUrl(togglConfig.baseUrl())
                .build()
                .method(method)
                .uri(uriFunction);
    }

    protected <T> ResponseEntity<T> perform(HttpMethod method, Function<UriBuilder, URI> uriFunction, ParameterizedTypeReference<T> bodyType) {
        RestClient.ResponseSpec retrieve = buildBase(method, uriFunction)
                .retrieve();

        return retrieve
                .toEntity(bodyType);
    }

    protected <T> ResponseEntity<T> performWithBody(HttpMethod method, Function<UriBuilder, URI> uriFunction, Object body, ParameterizedTypeReference<T> responseType) {
        RestClient.ResponseSpec retrieve = buildBase(method, uriFunction)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve();

        return retrieve
                .toEntity(responseType);
    }

    protected <T> void performVoid(HttpMethod method, Function<UriBuilder, URI> uriFunction) {
        buildBase(method, uriFunction)
                .retrieve()
                .toBodilessEntity();
    }


}
