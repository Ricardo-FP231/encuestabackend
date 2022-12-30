package edu.educem.encuestabackend.models.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private Date timestamp;
    private String message;
    private int status;
}
