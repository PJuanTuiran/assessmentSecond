package com.riwi.assessment_appointment.handleErrors;

import com.riwi.assessment_appointment.exeptions.ErrorSimple;
import com.riwi.assessment_appointment.exeptions.ErrorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class BadRequest {

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ErrorSimple badRequest(MethodArgumentNotValidException ex) {
        List<String> errores = new ArrayList<>();
        ex.getAllErrors().forEach(error -> errores.add(error.getDefaultMessage()));

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Errores de validación")
                .Errors(errores).build();

    }
}
