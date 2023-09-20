package cycleSpring.cycleAuth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleBasketRepo extends JpaRepository<CycleBasketEntity, Long> {

    CycleBasketEntity findByCycleId(Long cycleId);
}
