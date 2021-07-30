package com.andrei.myapp.model.enums;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<RolEnum, String> {

    @Override
    public String convertToDatabaseColumn(RolEnum rolEnum) {
        if (rolEnum == null) {
            return null;
        }
        return rolEnum.getCode();
    }


    @Override
    public RolEnum convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(RolEnum.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

