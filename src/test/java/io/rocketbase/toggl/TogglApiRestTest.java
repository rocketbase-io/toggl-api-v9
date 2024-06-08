package io.rocketbase.toggl;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.rocketbase.toggl.report.dto.DetailFilter;
import io.rocketbase.toggl.report.dto.DetailedTimeEntry;
import io.rocketbase.toggl.report.dto.ResponsePage;
import io.rocketbase.toggl.track.dto.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
class TogglApiRestTest {

    protected TogglConfig config;
    protected Long workSpaceId;
    protected TogglApi togglApi;

    public TogglApiRestTest() {
        String apiToken = "api_token";
        try {
            apiToken = System.getenv("API_TOKEN");
            config = new TogglConfig(apiToken);
            workSpaceId = Long.parseLong(System.getenv("WORKSPACE_ID"));
        } catch (Exception e) {
            System.err.println("System Env not set use defaults");
        }

        togglApi = new TogglApiRest(config);
    }

    @Test
    void trackMeGet() {
        MeDto response = togglApi.track()
                .me()
                .get();
        assertThat(response).isNotNull();
    }

    @Test
    void trackMeOrganizations() {
        List<OrganizationDto> response = togglApi.track()
                .me()
                .organizations();
        assertThat(response).isNotNull();
    }

    @Test
    void trackOrganizationGet() {
        OrganizationDto response = togglApi.track()
                .organization()
                .get(2116429L);
        assertThat(response).isNotNull();
    }

    @Test
    void trackClientList() {
        List<ClientDto> response = togglApi.track()
                .client(workSpaceId)
                .list();
        assertThat(response).isNotNull();
    }

    @Test
    void trackClientGet() {
        ClientDto response = togglApi.track()
                .client(workSpaceId)
                .get(19069538L);
        assertThat(response).isNotNull();
    }

    @Test
    void trackProjectList() {
        List<ProjectDto> response = togglApi.track()
                .project(workSpaceId)
                .list();
        assertThat(response).isNotNull();
    }

    @Test
    void trackTaskList() {
        List<TaskDto> response = togglApi.track()
                .task(workSpaceId, 21623097L)
                .list();
        assertThat(response).isNotNull();
    }

    @Test
    void trackWorkspaceGet() {
        WorkspaceDto response = togglApi.track()
                .workspace()
                .get(workSpaceId);
        assertThat(response).isNotNull();
    }

    @Test
    void trackTagsList() {
        List<TagDto> response = togglApi.track()
                .tags(workSpaceId)
                .list();
        assertThat(response).isNotNull();
    }

    @Test
    void trackTimeEntryList() {
        List<TimeEntryDto> response = togglApi.track()
                .timeEntry()
                .list(LocalDate.now().minusDays(10), LocalDate.now());
        assertThat(response).isNotNull();
    }

    @Test
    void report() throws JsonProcessingException {
        DetailFilter filter = DetailFilter.builder()
                .startDate(LocalDate.now().minusDays(10))
                .endDate(LocalDate.now())
                .build();

        ResponsePage<DetailedTimeEntry> response = togglApi.report()
                .detail(workSpaceId)
                .search(filter);
        assertThat(response).isNotNull();
    }
}