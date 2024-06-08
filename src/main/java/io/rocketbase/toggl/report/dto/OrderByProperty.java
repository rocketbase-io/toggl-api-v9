package io.rocketbase.toggl.report.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderByProperty {

    DATE("date"),
    USER("user"),
    DURATION("duration"),
    DESCRIPTION("description"),
    LAST_UPDATE("last_update");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
