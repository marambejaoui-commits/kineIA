package com.kineia.backend.service;

import com.kineia.backend.dto.response.PatientDTO;
import com.kineia.backend.entity.Patient;
import com.kineia.backend.mapper.PatientMapper;
import com.kineia.backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public List<PatientDTO> getPatientsByKine(Long kineId) {
        return patientRepository.findByKineId(kineId)
                .stream()
                .map(patientMapper::toDto)
                .collect(Collectors.toList());
    }

    public PatientDTO savePatient(Patient patient) {
        return patientMapper.toDto(patientRepository.save(patient));
    }

    public List<PatientDTO> getAllPatients() {
        // 1. Récupérer les entités depuis le Repository
        List<Patient> patients = patientRepository.findAll();

        // 2. Transformer la liste d'entités en liste de DTOs via le mapper
        return patientMapper.toDtoList(patients);
    }
}