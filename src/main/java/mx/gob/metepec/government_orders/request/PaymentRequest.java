package mx.gob.metepec.government_orders.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class PaymentRequest {

    private String description;
    private Boolean active;
    private UUID uuid;

}
