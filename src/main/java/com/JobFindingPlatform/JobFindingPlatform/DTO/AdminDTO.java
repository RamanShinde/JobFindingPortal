package com.JobFindingPlatform.JobFindingPlatform.DTO;

import com.JobFindingPlatform.JobFindingPlatform.Enum.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDTO {
    private Long adminID;
    private Long userId;
    private Action action;
    private LocalDateTime timeStamp;
}