package mx.gob.metepec.government_orders.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SupplierRequest {

    private String rfc;
    private String companyName;
    private UUID uuid;
    private Boolean active;

}
