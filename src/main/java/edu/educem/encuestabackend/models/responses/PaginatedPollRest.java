package edu.educem.encuestabackend.models.responses;

import java.util.List;

import lombok.Data;
@Data
public class PaginatedPollRest {
    private List<PollRest> polls;
    private int totalPages;
    private Long totalRecord;
    private long currentPageRecords;
    private int currentPage;
}
