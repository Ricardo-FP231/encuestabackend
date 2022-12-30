package edu.educem.encuestabackend.services;
import java.util.List;

import org.springframework.data.domain.Page;
import edu.educem.encuestabackend.entities.PollEntity;
import edu.educem.encuestabackend.interfaces.PollResult;
import edu.educem.encuestabackend.models.requests.PollCreationRequestModel;

public interface PollService {
    public String createPoll(PollCreationRequestModel model, String email);
    public PollEntity getPoll(String pollID);
    public Page<PollEntity> getPolls(int page, int limit, String email);
    public void togglePollOpened(String pollId, String email);
    public void deletePoll(String pollId, String email);
    public List<PollResult> getResults(String pollId, String email);
}
