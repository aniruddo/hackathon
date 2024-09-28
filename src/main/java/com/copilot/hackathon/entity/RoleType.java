package com.copilot.hackathon.entity;

public enum RoleType {
    PROPOSAL_COORDINATOR("PROPOSAL_COORDINATOR"),
    PROPOSAL_CONTRIBUTOR("PROPOSAL_CONTRIBUTOR");

    private String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
