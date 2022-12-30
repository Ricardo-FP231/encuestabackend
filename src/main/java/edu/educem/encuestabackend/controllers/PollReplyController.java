package edu.educem.encuestabackend.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.educem.encuestabackend.models.requests.PollReplyRequestModel;
import edu.educem.encuestabackend.services.PollReplyService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/polls/reply")
public class PollReplyController {

    @Autowired
    PollReplyService pollReplyService;
    
    @PostMapping(value="")
    public void replyPoll(@RequestBody @Valid PollReplyRequestModel model) {
        pollReplyService.createPollReplay(model);
    }
    
}
