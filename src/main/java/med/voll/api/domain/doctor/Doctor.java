package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.address.AddressClass;

@Table(name = "doctors")
@Entity (name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String crm;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private AddressClass address;

    public Doctor(RegisterDoctorDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new AddressClass(data.address());
        this.active = true;
    }

    public void updateDoctorInfo(UpdateDoctorDTO data) {
        if (data.name() != null) {
            this.name = data.name();
        }

        if (data.phoneNumber() != null) {
            this.phoneNumber = data.phoneNumber();
        }

        if (data.address() != null) {
            this.address.updateAddressInfo(data.address());

        }
    }

    public void delete() {
        this.active = false;
    }
}
