package io.rocketbase.toggl;

import io.rocketbase.toggl.track.*;
import org.springframework.http.client.ClientHttpRequestInterceptor;

public class TrackApiRest extends BaseResourceRest implements TrackApi {

    public TrackApiRest(TogglConfig togglConfig, ClientHttpRequestInterceptor interceptor) {
        super(togglConfig, interceptor);
    }

    @Override
    public MeResource me() {
        return new MeRest(togglConfig, interceptor);
    }

    @Override
    public OrganizationResource organization() {
        return new OrganizationRest(togglConfig, interceptor);
    }

    @Override
    public WorkspaceResource workspace() {
        return new WorkspaceRest(togglConfig, interceptor);
    }

    @Override
    public ClientResource client(long workspaceId) {
        return new ClientRest(togglConfig, interceptor, workspaceId);
    }

    @Override
    public ProjectResource project(long workspaceId) {
        return new ProjectRest(togglConfig, interceptor, workspaceId);
    }

    @Override
    public TaskResource task(long workspaceId, Long projectId) {
        return new TaskRest(togglConfig, interceptor, workspaceId, projectId);
    }

    @Override
    public TagResource tags(long workspaceId) {
        return new TagRest(togglConfig, interceptor, workspaceId);
    }

    @Override
    public TimeEntryResource timeEntry() {
        return new TimeEntryRest(togglConfig, interceptor);
    }
}
