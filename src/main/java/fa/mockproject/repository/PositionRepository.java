package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, String> {

}
