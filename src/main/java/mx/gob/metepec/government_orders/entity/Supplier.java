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
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_gen")
    @SequenceGenerator(name = "supplier_id_gen", sequenceName = "supplier_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rfc", nullable = false, length = Integer.MAX_VALUE)
    private String rfc;

    @Column(name = "company_name", length = Integer.MAX_VALUE)
    private String companyName;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @OneToMany(mappedBy = "supplier")
    private Set<PurchaseOrder> purchaseOrders = new LinkedHashSet<>();

}