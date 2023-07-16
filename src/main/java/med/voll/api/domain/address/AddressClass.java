package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
public class AddressClass {
    private String street;
    private String district;
    private String postalCode;
    private String city;
    private String state;
    private String number;
    private String complement;

    public AddressClass(Address data) {
        this.street = data.street();
        this.district = data.district();
        this.postalCode = data.postalCode();
        this.city = data.city();
        this.state = data.state();
        this.number = data.number();
        this.complement = data.complement();
    }

    public void updateAddressInfo(Address data) {
        if (data.city() != null) {
            this.city = data.city();
        }

        if (data.complement() != null) {
            this.complement = data.complement();
        }

        if (data.district() != null) {
            this.district = data.district();
        }

        if (data.number() != null) {
            this.number = data.number();
        }

        if (data.state() != null) {
            this.state = data.state();
        }

        if (data.street() != null) {
            this.street = data.street();
        }

        if (data.postalCode() != null) {
            this.postalCode = data.postalCode();
        }
    }
}
