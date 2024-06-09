package io.rocketbase.toggl;

import io.rocketbase.toggl.report.DetailResource;
import io.rocketbase.toggl.report.DetailRest;
import org.springframework.http.client.ClientHttpRequestInterceptor;

public class ReportApiRest extends BaseResourceRest implements ReportApi {
    
    public ReportApiRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor) {
        super(togglConfig, interceptor);
    }

    @Override
    public DetailResource detail(long workspaceId) {
        return new DetailRest(togglConfig, interceptor, workspaceId);
    }
}
