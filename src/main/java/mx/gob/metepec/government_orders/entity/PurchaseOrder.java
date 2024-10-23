package mx.gob.metepec.government_orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_order_id_gen")
    @SequenceGenerator(name = "purchase_order_id_gen", sequenceName = "purchase_order_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status", length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "iva", nullable = false, precision = 10, scale = 2)
    private BigDecimal iva;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "id_employe", nullable = false)
    private Integer idEmploye;

    @Column(name = "id_request", nullable = false)
    private Integer idRequest;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ColumnDefault("true")
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @OneToMany(mappedBy = "purchaseOrder")
    private Set<Input> inputs = new LinkedHashSet<>();

}