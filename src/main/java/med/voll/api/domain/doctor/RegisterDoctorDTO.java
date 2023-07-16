package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.domain.address.Address;

public record RegisterDoctorDTO(
        @NotBlank
        String name,

        @NotNull
        @Email
        String email,

        @NotBlank
        String phoneNumber,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Specialty specialty,

        @NotNull
        @Valid
        Address address
    ) {
}
