package io.rocketbase.toggl.report.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderDirection {

    ASC("ASC"),
    DESC("DESC");

    private final String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
