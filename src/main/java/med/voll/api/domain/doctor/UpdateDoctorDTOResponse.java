package med.voll.api.domain.doctor;

import med.voll.api.domain.address.AddressClass;

public record UpdateDoctorDTOResponse(Long id, String name, String email, String crm, String phoneNumber, Specialty specialty, AddressClass address) {
    public UpdateDoctorDTOResponse(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(),  doctor.getPhoneNumber(), doctor.getSpecialty(), doctor.getAddress());
    }

}
