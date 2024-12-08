package com.riwi.assessment_appointment.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface Update<ID, T, S> {
    ResponseEntity<?> update(ID id, S t);
}
