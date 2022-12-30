package edu.educem.encuestabackend.models.requests;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import edu.educem.encuestabackend.annotations.ValueOfEnum;
import edu.educem.encuestabackend.enums.QuestionType;
import lombok.Data;

@Data
public class QuestionCreationRequestModel {
    @NotEmpty
    private String content;

    @NotNull
    @Range(min = 1, max = 30)
    private int questionOrder;

    @NotEmpty
    @ValueOfEnum(enumClass = QuestionType.class)
    private String type;

    @Valid
    @NotEmpty
    @Size(min = 1,max = 10)
    private List<AnswerCreationRequestModel> answers;
}
