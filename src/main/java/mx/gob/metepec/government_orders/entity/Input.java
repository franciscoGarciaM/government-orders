package mx.gob.metepec.government_orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "input")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "input_id_gen")
    @SequenceGenerator(name = "input_id_gen", sequenceName = "inputs_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchase_order_id", nullable = false)
    private PurchaseOrder purchaseOrder;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

}