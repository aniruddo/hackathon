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
public class Task extends BaseModel {
    private String description;
    private String skillSet;
    private String domainKnowledge;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeline;

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    // Getters and setters
}