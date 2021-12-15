package web.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import web.quiz.model.Answer;
import web.quiz.repository.AnswerRepository;

@Service
public class CombineService {

    @Autowired
    private AnswerRepository answerRepository;

//    ------------------------------
//    /quiz
//    ------------------------------
    public String combinePostQuiz(Answer answer, BindingResult result, Model model) {
        if (result.hasErrors()) return "quiz";
        answerRepository.save(answer);
        return "redirect:/passed";
    }

//    ------------------------------
//    /admin
//    ------------------------------
    public String combineShowAdmin(Model model) {
        model.addAttribute("answers", answerRepository.findAll());
        return "admin";
    }

}
