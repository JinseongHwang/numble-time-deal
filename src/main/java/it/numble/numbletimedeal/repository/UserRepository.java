package it.numble.numbletimedeal.repository;

import it.numble.numbletimedeal.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
