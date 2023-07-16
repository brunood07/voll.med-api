package med.voll.api.domain.doctor;

import jakarta.validation.constraints.*;
import med.voll.api.domain.address.Address;

public record UpdateDoctorDTO(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        Address address) {
}
