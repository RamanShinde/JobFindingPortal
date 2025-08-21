package com.JobFindingPlatform.JobFindingPlatform.Entity;
import com.JobFindingPlatform.JobFindingPlatform.Enum.Action;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "admin_id")
    private Long adminId;
    @Column(name = "user_id")
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Action action;
    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;
}
