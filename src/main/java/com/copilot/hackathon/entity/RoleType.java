package com.copilot.hackathon.entity;

public enum RoleType {
    PROPOSAL_COORDINATOR("ROLE_COORDINATOR"),
    PROPOSAL_CONTRIBUTOR("ROLE_CONTRIBUTOR");

    private String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
