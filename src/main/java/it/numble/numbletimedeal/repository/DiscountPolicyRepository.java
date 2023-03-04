package it.numble.numbletimedeal.repository;

import it.numble.numbletimedeal.model.entity.DiscountPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountPolicyRepository extends JpaRepository<DiscountPolicyEntity, Long> {
}
