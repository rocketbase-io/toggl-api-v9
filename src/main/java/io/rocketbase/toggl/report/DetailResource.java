package io.rocketbase.toggl.report;

import io.rocketbase.toggl.report.dto.DetailFilter;
import io.rocketbase.toggl.report.dto.DetailedTimeEntry;
import io.rocketbase.toggl.report.dto.ResponsePage;

public interface DetailResource {

    /**
     * [POST] https://api.track.toggl.com/reports/api/v3/workspace/{workspace_id}/search/time_entries
     */
    ResponsePage<DetailedTimeEntry> search(DetailFilter filter);
}
