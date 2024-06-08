package io.rocketbase.toggl;

import io.rocketbase.toggl.track.*;

public interface TrackApi {

    MeResource me();

    OrganizationResource organization();

    WorkspaceResource workspace();

    ClientResource client(long workspaceId);

    ProjectResource project(long workspaceId);

    TaskResource task(long workspaceId, Long projectId);

    TagResource tags(long workspaceId);

    TimeEntryResource timeEntry();

}
