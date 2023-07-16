package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Address(
        @NotBlank
        String street,

        @NotBlank
        String district,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String postalCode,

        @NotBlank
        String city,

        @NotBlank
        String state,

        String number,
        String complement) {
}
