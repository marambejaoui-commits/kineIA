package com.kineia.backend.repository;

import com.kineia.backend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Trouver tous les patients d'un Kiné spécifique
    List<Patient> findByKineId(Long kineId);
}
