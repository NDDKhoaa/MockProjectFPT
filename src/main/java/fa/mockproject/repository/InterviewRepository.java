package fa.mockproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.mockproject.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long>{

}
