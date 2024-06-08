package io.rocketbase.toggl.track;

import io.rocketbase.toggl.BaseResourceRest;
import io.rocketbase.toggl.TogglConfig;
import io.rocketbase.toggl.track.dto.TimeEntryDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public class TimeEntryRest extends BaseResourceRest implements TimeEntryResource {

    public TimeEntryRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor) {
        super(togglConfig, interceptor);
    }

    @Override
    public List<TimeEntryDto> list(LocalDate startDate, LocalDate endDate) {
        Function<UriBuilder, URI> uriFunction = uriBuilder -> {
            UriBuilder builder = uriBuilder.path("/api/v9/me/time_entries");
            if (startDate != null) {
                builder.queryParam("start_date", startDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
            if (endDate != null) {
                builder.queryParam("end_date", endDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
            return builder.build();
        };
        return perform(HttpMethod.GET, uriFunction, new ParameterizedTypeReference<List<TimeEntryDto>>() {
        }).getBody();
    }

    @Override
    public TimeEntryDto get(Long id) {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/me/time_entries/{id}").build(id),
                new ParameterizedTypeReference<TimeEntryDto>() {
                }).getBody();
    }

    @Override
    public TimeEntryDto current() {
        return perform(HttpMethod.GET, uriBuilder -> uriBuilder.path("/api/v9/me/time_entries/current").build(),
                new ParameterizedTypeReference<TimeEntryDto>() {
                }).getBody();
    }

    @Override
    public TimeEntryDto create(Long workspaceId, TimeEntryDto timeEntryDto) {
        return performWithBody(HttpMethod.POST, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/time_entries").build(workspaceId),
                timeEntryDto,
                new ParameterizedTypeReference<TimeEntryDto>() {
                }).getBody();
    }

    @Override
    public TimeEntryDto update(Long workspaceId, Long id, TimeEntryDto timeEntryDto) {
        return performWithBody(HttpMethod.PUT, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/time_entries/{id}").build(workspaceId, id),
                timeEntryDto,
                new ParameterizedTypeReference<TimeEntryDto>() {
                }).getBody();
    }

    @Override
    public void stop(Long workspaceId, Long id) {
        performVoid(HttpMethod.PATCH, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/time_entries/{id}/stop").build(workspaceId, id));

    }

    @Override
    public void delete(Long workspaceId, Long id) {
        performVoid(HttpMethod.DELETE, uriBuilder -> uriBuilder.path("/api/v9/workspaces/{workspaceId}/time_entries/{id}").build(workspaceId, id));
    }
}
