package edu.educem.encuestabackend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.educem.encuestabackend.entities.PollEntity;
import edu.educem.encuestabackend.interfaces.PollResult;

@Repository
public interface PollRepository extends CrudRepository<PollEntity,Long> {
    PollEntity findByPollId(String id);
    PollEntity findById(long id);    
    Page<PollEntity> findAllByUserId(long userId, Pageable pageable);
    PollEntity findByPollIdAndUserId(String pollId, long userId);

    @Query(value="select q.question_order as questionOrder, prd.question_id as questionId, q.content as question , prd.answer_id as answerId,a.content as answer, count(prd.answer_id) as result from poll_replies pr left join poll_reply_details prd on pr.id =prd.poll_reply_id left join answers a on a.id = prd.answer_id left join questions q on q.id=prd.question_id where pr.poll_id = :pollId GROUP by prd.question_id, prd.answer_id ORDER BY q.question_order asc", nativeQuery = true)
    List<PollResult> getPollResults(@Param("pollId") long id);
}
