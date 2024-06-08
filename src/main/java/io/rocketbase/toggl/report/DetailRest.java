package io.rocketbase.toggl.report;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.report.dto.DetailFilter;
import io.rocketbase.toggl.report.dto.DetailedTimeEntry;
import io.rocketbase.toggl.report.dto.ResponsePage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DetailRest extends BaseResourceRest implements DetailResource {

    protected final Long workspaceId;

    public DetailRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor, Long workspaceId) {
        super(togglConfig, interceptor);
        this.workspaceId = workspaceId;
    }

    @Override
    public ResponsePage<DetailedTimeEntry> search(DetailFilter filter) {
        ResponseEntity<List<DetailedTimeEntry>> response = performWithBody(HttpMethod.POST,
                uriBuilder -> uriBuilder.path("/reports/api/v3/workspace/{workspace_id}/search/time_entries").build(workspaceId),
                filter,
                new ParameterizedTypeReference<List<DetailedTimeEntry>>() {
                });
        return ResponsePage.<DetailedTimeEntry>builder()
                .content(response.getBody())
                .nextId(getHeaderValue(response, "X-Next-Id", Long.class))
                .nextRowNumber(getHeaderValue(response, "X-Next-Row-Number", Long.class))
                .nextTimestamp(getHeaderValue(response, "X-Next-Timestamp", Long.class))
                .pageSize(getHeaderValue(response, "X-Page-Size", Integer.class))
                .rangeStart(getHeaderValue(response, "X-Range-Start", LocalDate.class))
                .rangeEnd(getHeaderValue(response, "X-Range-End", LocalDate.class))
                .serviceLevel(getHeaderValue(response, "X-Service-Level", String.class))
                .build();
    }

    protected <T> T getHeaderValue(ResponseEntity response, String headerName, Class<T> type) {
        try {
            if (response != null && response.getHeaders() != null && response.getHeaders().containsKey(headerName)) {
                String value = response.getHeaders().getFirst(headerName);
                if (type.equals(String.class)) {
                    return (T) value;
                } else if (type.equals(Long.class)) {
                    return (T) Long.valueOf(value);
                } else if (type.equals(Integer.class)) {
                    return (T) Integer.valueOf(value);
                } else if (type.equals(LocalDate.class)) {
                    return (T) LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
