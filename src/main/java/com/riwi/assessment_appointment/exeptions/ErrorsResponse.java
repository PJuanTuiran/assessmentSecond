package com.riwi.assessment_appointment.exeptions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class ErrorsResponse extends ErrorSimple {
    private List<String> Errors;

}
