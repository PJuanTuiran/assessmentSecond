package com.riwi.assessment_appointment.mappers;

import com.riwi.assessment_appointment.models.DTOs.request.RegistreRequest;
import com.riwi.assessment_appointment.models.DTOs.response.RegistreResponse;
import com.riwi.assessment_appointment.models.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface UserMapper {
    RegistreResponse userEntityToRegisterResponseDTO(UserEntity userEntity);

    UserEntity registerRequestDTOToUserEntity(RegistreRequest registerRequestDTO);
}
