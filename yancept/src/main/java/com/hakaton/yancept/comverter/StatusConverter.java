package com.hakaton.yancept.comverter;

import com.hakaton.yancept.entity.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, Short> {

    @Override
    public Short convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    @Override
    public Status convertToEntityAttribute(Short code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Status.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
