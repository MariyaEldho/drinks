package store.drink.drink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.drink.drink.Modal.bottle;

public interface BottleRepository extends JpaRepository<bottle, String> {
}
