package mx.gob.metepec.government_orders.repository;

import mx.gob.metepec.government_orders.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {

    Optional<Supplier> findByUuid(UUID uuid);

}
