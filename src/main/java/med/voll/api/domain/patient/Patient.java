package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.AddressClass;

@Table(name = "patients")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private String phoneNumber;

    private String document;

    @Embedded
    private AddressClass address;

    private Boolean active;

    public Patient(PatientRegisterDTO data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.document = data.document();
        this.address = new AddressClass(data.address());
    }

    public void updateInfo(UpdatePatientDTO data) {
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
