package com.kineia.backend.dto.response;


import lombok.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PatientDTO extends UserDTO {
    private Integer idPatient;
    private Long kineId;
}