package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.TimeEntryDto;

import java.time.LocalDate;
import java.util.List;

public interface TimeEntryResource {

    /**
     * no paging seems to load max 50 records
     * [GET] https://api.track.toggl.com/api/v9/me/time_entries?start_date=YYYY-MM-DD&end_date=YYYY-MM-DD
     */
    List<TimeEntryDto> list(LocalDate startDate, LocalDate endDate);

    /**
     * [GET] https://api.track.toggl.com/api/v9/me/time_entries/{id}
     */
    TimeEntryDto get(Long id);

    /**
     * [GET] https://api.track.toggl.com/api/v9/me/time_entries/current
     */
    TimeEntryDto current();

    /**
     * [POST] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/time_entries
     */
    TimeEntryDto create(Long workspaceId, TimeEntryDto timeEntryDto);

    /**
     * [PUT] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/time_entries/{id}
     */
    TimeEntryDto update(Long workspaceId, Long id, TimeEntryDto timeEntryDto);


    /**
     * [PATCH] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/time_entries/{id}/stop
     */
    void stop(Long workspaceId, Long id);


    /**
     * [DELETE] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/time_entries/{id}
     */
    void delete(Long workspaceId, Long id);
}
