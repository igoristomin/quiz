package web.quiz.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.quiz.model.Answer;
import web.quiz.repository.AnswerRepository;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AnswerRepository answerRepository;

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
        if (result.hasErrors()) return "quiz";
        answerRepository.save(answer);
        return "redirect:/passed";
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
        model.addAttribute("answers", answerRepository.findAll());
        return "admin";
    }

//    ------------------------------
//    /admin/export-csv
//    ------------------------------
    @GetMapping("/admin/export-csv")
    public void exportCsv(HttpServletResponse response) throws Exception {
        // Set the file name
        final String fileName = "answers.csv";

        // Set content type and header
        response.setContentType("text/csv; charset=UTF-8");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + fileName);

        // Create CSV writer
        StatefulBeanToCsv<Answer> writer = new StatefulBeanToCsvBuilder<Answer>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(';')
                .withOrderedResults(true)
                .build();

        // Export records to a file
        writer.write((List<Answer>) answerRepository.findAll());
    }

}
