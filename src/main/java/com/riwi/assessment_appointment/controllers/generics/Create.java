package com.riwi.assessment_appointment.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface Create<T,  S> {
   ResponseEntity<?>  create(S t);
}
