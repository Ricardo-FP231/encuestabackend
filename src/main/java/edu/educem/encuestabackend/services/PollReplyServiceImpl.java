package edu.educem.encuestabackend.services;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.educem.encuestabackend.entities.PollEntity;
import edu.educem.encuestabackend.entities.PollReplyDetailEntity;
import edu.educem.encuestabackend.entities.PollReplyEntity;
import edu.educem.encuestabackend.models.requests.PollReplyRequestModel;
import edu.educem.encuestabackend.repositories.PollReplyRepository;
import edu.educem.encuestabackend.repositories.PollRepository;

@Service
public class PollReplyServiceImpl implements PollReplyService {

    PollReplyRepository pollReplyRepository;
    PollRepository pollRepository;

    public PollReplyServiceImpl(PollReplyRepository pollReplyRepository, PollRepository pollRepository) {
        this.pollReplyRepository = pollReplyRepository;
        this.pollRepository = pollRepository;
    }

    @Override
    public void createPollReplay(PollReplyRequestModel model) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        PollReplyEntity pollReply = mapper.map(model, PollReplyEntity.class);
        PollEntity poll = pollRepository.findById(model.getPoll());
        pollReply.setPoll(poll);

        Set<Long> uniqueReplies = new HashSet<>();

        for (PollReplyDetailEntity pollReplyDetailEntity : pollReply.getPollReplies()) {
            pollReplyDetailEntity.setPollReply(pollReply);
            uniqueReplies.add(pollReplyDetailEntity.getQuestionId());
        }

        if (uniqueReplies.size() != poll.getQuestions().size()) {
            throw new RuntimeException("You must answer all the questions");
        }

        pollReplyRepository.save(pollReply);
    }

}
