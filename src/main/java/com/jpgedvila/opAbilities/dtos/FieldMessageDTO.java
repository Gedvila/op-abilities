package com.jpgedvila.opAbilities.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"fieldName", "message"})
public class FieldMessageDTO {

    private String fieldName;
    private String message;

    public FieldMessageDTO(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
