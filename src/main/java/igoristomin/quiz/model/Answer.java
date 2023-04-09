package igoristomin.quiz.model;

import com.opencsv.bean.CsvDate;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 30, message = "* Enter from 5 to 30 characters")
    @Pattern(regexp = "^([A-Z]{1}[a-z]{1,}\\s[A-Z]{1}[a-z]{1,})$",
            message = "* Must start with capital letters, contain only English letters and 1 space")
    @NotEmpty(message = "* Fill in the field")
    @NotNull
    private String fullName;

    @Pattern(regexp = "^([A-Za-z0-9_-]+\\.)*[A-Za-z0-9_-]+@[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*\\.[A-Za-z]{2,6}$",
            message = "* Check that the input is correct")
    @NotEmpty(message = "* Fill in the field")
    @NotNull
    private String email;

    @Pattern(regexp = "^\\+\\d{7,13}$", message = "* Must start with \"+\" and contain from 7 to 13 digits")
    @NotEmpty(message = "* Fill in the field")
    @NotNull
    private String phoneNum;

    @CsvDate(value = "yyyyMMdd")
    @Past(message = "* Enter the date in the past tense")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "* Fill in the field")
    private Date dateBirth;

    private boolean married;

    @Range(min = 0, max = 99, message = "* Enter a value from 0 to 99")
    @NotNull(message = "* Fill in the field")
    private Byte childsAmount;

    @Range(min = 0, max = 999999999, message = "* Enter a value from 0 and 999999999")
    @NotNull(message = "* Fill in the field")
    private Integer salary;

    @Range(min = 32, max = 40, message = "* Enter a value from 32 and 40")
    @NotNull(message = "* Fill in the field")
    private Double bodyTemp = 36.6;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @NotNull(message = "* Fill in the field")
    private LocalTime wakeUpTime;

    // Set the current date and time of the quiz
    @CsvDate()
    @NotNull
    private Calendar dateTimePassage = Calendar.getInstance();

    // Convert to lowercase and set email
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

}
