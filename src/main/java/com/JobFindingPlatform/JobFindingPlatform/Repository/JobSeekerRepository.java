package com.JobFindingPlatform.JobFindingPlatform.Repository;

import com.JobFindingPlatform.JobFindingPlatform.Entity.Jobseeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobSeekerRepository extends JpaRepository<Jobseeker, Long> {
    Optional<Jobseeker> findByEmail(String email);
    Optional<Jobseeker>findById(Long id);
}
