package com.menglang.student.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum FamilyType {
    MOTHER("Mother"),
    FATHER("Father"),
    UNCLE("Uncle"),
    AUNT("Aunt"),
    GRAND_MOTHER("GrandMother"),
    GRAND_FATHER("GrandFather");

    private final String label;

    FamilyType(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static FamilyType fromLabel(String label) {
        return Arrays.stream(FamilyType.values())
                .filter(type -> type.label.equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown FamilyType: " + label));
    }
}

