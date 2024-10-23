package mx.gob.metepec.government_orders.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class PaymentResponse {

    private String description;
    private Boolean active;
    private UUID uuid;

}
