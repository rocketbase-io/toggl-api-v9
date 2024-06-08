package io.rocketbase.toggl;

import io.rocketbase.toggl.report.DetailResource;

public interface ReportApi {

    DetailResource detail(long workspaceId);

}
