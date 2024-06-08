package io.rocketbase.toggl.track;

import io.rocketbase.toggl.track.dto.TagDto;

import java.util.List;

public interface TagResource {

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/tags
     */
    List<TagDto> list();

    /**
     * [GET] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/tags/{id}
     */
    TagDto get(Long id);

    /**
     * [POST] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/tags
     */
    TagDto create(TagDto tagDto);

    /**
     * [PUT] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/tags/{id}
     */
    TagDto update(Long id, TagDto tagDto);


    /**
     * [DELETE] https://api.track.toggl.com/api/v9/workspaces/{workspaceId}/tags/{id}
     */
    void delete(Long id);
}
