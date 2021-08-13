package com.andrei.myapp.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class OrderEnumConverter implements AttributeConverter<OrderEnum, String> {

    @Override
    public String convertToDatabaseColumn(OrderEnum orderEnum) {
        if (orderEnum == null) {
            return null;
        }
        return orderEnum.getCode();
    }


    @Override
    public OrderEnum convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(OrderEnum.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}


