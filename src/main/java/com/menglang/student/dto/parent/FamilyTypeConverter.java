package com.menglang.student.dto.parent;

import com.menglang.student.model.enums.FamilyType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FamilyTypeConverter implements AttributeConverter<FamilyType, String> {

    @Override
    public String convertToDatabaseColumn(FamilyType attribute) {
        return attribute != null ? attribute.getLabel() : null;
    }

    @Override
    public FamilyType convertToEntityAttribute(String dbData) {
        return dbData != null ? FamilyType.fromLabel(dbData) : null;
    }
}
