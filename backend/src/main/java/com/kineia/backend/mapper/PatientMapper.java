package com.kineia.backend.mapper;

import com.kineia.backend.dto.response.PatientDTO;
import com.kineia.backend.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "kine.id", target = "kineId")
    @Mapping(target = "role", constant = "PATIENT")
    PatientDTO toDto(Patient patient);

    Patient toEntity(PatientDTO dto);

    List<PatientDTO> toDtoList(List<Patient> patients);
}