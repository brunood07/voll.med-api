package med.voll.api.domain.patient;

import med.voll.api.domain.address.AddressClass;

public record PatientDetailsDTO(Long id, String name, String email, String document, String phoneNumber, AddressClass address) {
    public PatientDetailsDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getDocument(), patient.getPhoneNumber(), patient.getAddress());
    }
}
