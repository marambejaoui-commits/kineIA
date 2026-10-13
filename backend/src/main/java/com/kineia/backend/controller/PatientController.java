package com.kineia.backend.controller;

import com.kineia.backend.dto.response.PatientDTO;
import com.kineia.backend.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/kine/{kineId}")
    public ResponseEntity<List<PatientDTO>> getMyPatients(@PathVariable Long kineId) {
        return ResponseEntity.ok(patientService.getPatientsByKine(kineId));
    }
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        // Assure-toi que cette méthode existe dans ton service
        return ResponseEntity.ok(patientService.getAllPatients());
    }
}