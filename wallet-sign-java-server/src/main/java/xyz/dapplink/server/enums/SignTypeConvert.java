package xyz.dapplink.server.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SignTypeConvert implements AttributeConverter<SignType, String> {
    @Override
    public String convertToDatabaseColumn(SignType signType) {
        if (signType == null) {
            return "";
        }
        return signType.getName();
    }

    @Override
    public SignType convertToEntityAttribute(String s) {
        return SignType.valueOf(s);
    }
}
