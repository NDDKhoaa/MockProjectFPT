package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.mockproject.entity.ClassAdminProfile;

@Repository
public interface ClassAdminProfileRepository extends JpaRepository<ClassAdminProfile, Long> {

}
