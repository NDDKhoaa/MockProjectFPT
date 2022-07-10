package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>  {

}
