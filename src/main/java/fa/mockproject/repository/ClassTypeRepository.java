package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.ClassType;

@Repository
public interface ClassTypeRepository extends JpaRepository<ClassType, String> {

}
