package com.andrei.myapp.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TripEnumConverter implements AttributeConverter<TripEnum,String> {

    @Override
    public String convertToDatabaseColumn(TripEnum tripEnum) {
        if (tripEnum == null) {
            return null;
        }
        return tripEnum.getCode();
    }


    @Override
    public TripEnum convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(TripEnum.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}