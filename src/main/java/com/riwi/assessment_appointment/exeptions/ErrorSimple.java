package com.riwi.assessment_appointment.exeptions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ErrorSimple {
    private int code;

    private String status;
    private String message;
}
