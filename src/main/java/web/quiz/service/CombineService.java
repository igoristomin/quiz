package web.quiz.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import web.quiz.model.Answer;
import web.quiz.repository.AnswerRepository;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

//    ------------------------------
//    /admin/export-csv
//    ------------------------------
    public void combineExportCsv(HttpServletResponse response) throws Exception {
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
