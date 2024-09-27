package com.copilot.hackathon.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Proposal extends BaseModel {
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private User coordinator;

}