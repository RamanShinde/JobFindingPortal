package com.JobFindingPlatform.JobFindingPlatform.Repository;

import com.JobFindingPlatform.JobFindingPlatform.Entity.Application;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {


    Optional<Application>findByJobSeekerEmailAndJobId(String jobSeekerEmail, Long jobId);
    List<Application> findByjobSeekerEmail(String jobSeekerEmail);
    List<Application> findByRecruiterEmail(String recruiterEmail);
    List<Application> findByJobTitle(String jobTitle);
    List<Application> findByJobId(Long jobId);
    List<Application> findByjobType(JobType jobType);
}
