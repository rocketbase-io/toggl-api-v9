package io.rocketbase.toggl;

import org.springframework.http.client.ClientHttpRequestInterceptor;

public class TogglApiRest implements TogglApi {

    protected final TogglConfig config;
    protected final ClientHttpRequestInterceptor interceptor;

    public TogglApiRest(TogglConfig config) {
        this(config, (request, body, execution) -> {
            request.getHeaders().setBasicAuth(config.apiToken(), "api_token");
            return execution.execute(request, body);
        });
    }

    public TogglApiRest(TogglConfig config, ClientHttpRequestInterceptor interceptor) {
        this.config = config;
        this.interceptor = interceptor;
    }


    @Override
    public TrackApi track() {
        return new TrackApiRest(config, interceptor);
    }

    @Override
    public ReportApi report() {
        return new ReportApiRest(config, interceptor);
    }
}
