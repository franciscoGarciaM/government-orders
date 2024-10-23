package mx.gob.metepec.government_orders.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class InputRequest {

    private String description;
    private Integer unitPrice;
    private Integer purchaseOrderId;
    private UUID uuid;

}
