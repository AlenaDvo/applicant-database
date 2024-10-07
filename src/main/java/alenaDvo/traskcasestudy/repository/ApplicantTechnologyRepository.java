package alenaDvo.traskcasestudy.repository;

import alenaDvo.traskcasestudy.entity.ApplicantTechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantTechnologyRepository extends JpaRepository<ApplicantTechnologyEntity, Long> {
}