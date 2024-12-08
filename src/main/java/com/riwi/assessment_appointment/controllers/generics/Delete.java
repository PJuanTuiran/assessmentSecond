package com.riwi.assessment_appointment.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface Delete<T> {
    ResponseEntity<?> delete(T id);
}
