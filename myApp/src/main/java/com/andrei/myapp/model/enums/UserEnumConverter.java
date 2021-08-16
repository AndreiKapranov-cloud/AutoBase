package com.andrei.myapp.model.enums;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class UserEnumConverter implements AttributeConverter<UserEnum, String> {

    @Override
    public String convertToDatabaseColumn(UserEnum status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }


    @Override
    public UserEnum convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(UserEnum.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

