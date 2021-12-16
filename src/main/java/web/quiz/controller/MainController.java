package web.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.quiz.model.Answer;
import web.quiz.service.CombineService;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private CombineService combineService;

//    ------------------------------
//    /
//    ------------------------------
    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

//    ------------------------------
//    /quiz
//    ------------------------------
    @GetMapping("/quiz")
    public String showQuiz(Answer answer) {
        return "quiz";
    }

    @PostMapping("/quiz")
    public String postQuiz(@Valid Answer answer, BindingResult result, Model model) {
        return combineService.combinePostQuiz(answer, result, model);
    }

//    ------------------------------
//    /passed
//    ------------------------------
    @GetMapping("/passed")
    public String showPassed() {
        return "passed";
    }

//    ------------------------------
//    /admin
//    ------------------------------
    @GetMapping("/admin")
    public String showAdmin(Model model) {
        return combineService.combineShowAdmin(model);
    }

//    ------------------------------
//    /admin/export-csv
//    ------------------------------
    @GetMapping("/admin/export-csv")
    public void exportCsv(HttpServletResponse response) throws Exception {
        combineService.combineExportCsv(response);
    }

}
