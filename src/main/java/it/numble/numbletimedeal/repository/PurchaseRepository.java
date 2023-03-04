package it.numble.numbletimedeal.repository;

import it.numble.numbletimedeal.model.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
}
