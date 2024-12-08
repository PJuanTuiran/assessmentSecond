package com.riwi.assessment_appointment.controllers.generics;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface ReadAll<T> {
    ResponseEntity<List<T>>  readAll();
}
