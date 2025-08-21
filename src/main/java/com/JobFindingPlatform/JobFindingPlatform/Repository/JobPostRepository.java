package com.JobFindingPlatform.JobFindingPlatform.Repository;

import com.JobFindingPlatform.JobFindingPlatform.Entity.JobPost;
import com.JobFindingPlatform.JobFindingPlatform.Enum.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {
    List<JobPost> findByCompanyName(String companyName);
    List<JobPost> findByPostedBy(String postedBy);
    List<JobPost> findByJobTitle(String jobTitle);
    List<JobPost> findByJobType(JobType jobType);
    List<JobPost> findByRemote(String remote);
}
