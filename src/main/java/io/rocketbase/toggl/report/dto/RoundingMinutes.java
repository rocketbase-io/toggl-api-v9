package io.rocketbase.toggl.report.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RoundingMinutes {

    ZERO(0),
    ONE(1),
    FIVE(5),
    SIX(6),
    TEN(10),
    TWELVE(12),
    FIFTEEN(15),
    THIRTY(30),
    SIXTY(60),
    TWO_HUNDRED_FORTY(240);

    private final Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }
}
