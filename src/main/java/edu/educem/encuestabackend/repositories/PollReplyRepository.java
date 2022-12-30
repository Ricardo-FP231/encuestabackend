package edu.educem.encuestabackend.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.educem.encuestabackend.entities.PollReplyEntity;

public interface PollReplyRepository  extends CrudRepository<PollReplyEntity, Long>{
    
}
