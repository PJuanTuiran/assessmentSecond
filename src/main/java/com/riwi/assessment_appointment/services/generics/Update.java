package com.riwi.assessment_appointment.services.generics;

public interface Update <ID,T, S> {
    T update(ID id,S t);
}
