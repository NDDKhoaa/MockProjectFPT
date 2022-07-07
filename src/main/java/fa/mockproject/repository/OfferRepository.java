package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{

}
