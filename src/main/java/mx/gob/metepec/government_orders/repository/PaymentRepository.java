package mx.gob.metepec.government_orders.repository;

import mx.gob.metepec.government_orders.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentMethod, UUID> {

    Optional<PaymentMethod> findByUuid(UUID uuid);

}
