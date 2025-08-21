package com.JobFindingPlatform.JobFindingPlatform.Repository;

import com.JobFindingPlatform.JobFindingPlatform.Entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable,Long> {
     Optional<UserTable>findByUserEmail(String userEmail);
}
