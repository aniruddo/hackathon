package com.copilot.hackathon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "contributor_id")
    private User contributor;

    private String responseDescription;

    private String reponseReference;

    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;


}