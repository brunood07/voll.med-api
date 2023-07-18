package med.voll.api.domain.patient;

public record ListingPatientsDTO(Long id, String name, String email, String document) {
    public ListingPatientsDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getDocument());
    }
}
