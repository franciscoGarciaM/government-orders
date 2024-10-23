package mx.gob.metepec.government_orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_method_id_gen")
    @SequenceGenerator(name = "payment_method_id_gen", sequenceName = "payment_method_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @OneToMany(mappedBy = "paymentMethod")
    private Set<PurchaseOrder> purchaseOrders = new LinkedHashSet<>();

}