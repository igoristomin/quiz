package web.quiz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.quiz.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {}
