package io.rocketbase.toggl.report.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class ResponsePage<T> implements Iterable<T> {

    private Long nextId;
    private Long nextRowNumber;
    private Long nextTimestamp;
    private Integer pageSize;
    private LocalDate rangeStart;
    private LocalDate rangeEnd;
    private String serviceLevel;

    private List<T> content;

    @Override
    public Iterator<T> iterator() {
        return content.iterator();
    }
}
