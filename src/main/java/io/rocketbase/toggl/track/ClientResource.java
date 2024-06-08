package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.ClientDto;

import java.util.List;

public interface ClientResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/clients
     */
    List<ClientDto> list();

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/clients/{id}
     */
    ClientDto get(Long id);

    /**
     * [POST] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/clients
     */
    ClientDto create(ClientDto clientDto);

    /**
     * [PUT] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/clients/{id}
     */
    ClientDto update(Long id, ClientDto clientDto);


    /**
     * [DELETE] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/clients/{id}
     */
    void delete(Long id);

    /**
     * [POST] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/clients/{id}/archive
     */
    void archive(Long id);
}
