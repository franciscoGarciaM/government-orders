package mx.gob.metepec.government_orders.repository;

import mx.gob.metepec.government_orders.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InputRepository extends JpaRepository<Input, UUID> {

    Optional<Input> findByUuid(UUID uuid);

}
