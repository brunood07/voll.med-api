package med.voll.api.domain.doctor;

public record ListingDoctorDTO(Long id, String name, String email, String crm, Specialty specialty) {
    public ListingDoctorDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
