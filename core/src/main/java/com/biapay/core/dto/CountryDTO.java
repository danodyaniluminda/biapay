package com.biapay.core.dto;

import lombok.Data;

@Data
public class CountryDTO {
    private Long countryId;
    private String shortName;
    private String longName;
    private String flag;

    public CountryDTO(Long countryId, String shortName, String longName) {
        this.countryId = countryId;
        this.shortName = shortName;
        this.longName = longName;
        this.flag = getFlagEmoji(shortName);
    }

    private String getFlagEmoji(String countryCode) {
        if (countryCode == null || countryCode.length() != 2) {
            return "";
        }
        // Convert to uppercase for consistency
        countryCode = countryCode.toUpperCase();
        return new String(Character.toChars(0x1F1E6 + (countryCode.charAt(0) - 'A'))) +
                new String(Character.toChars(0x1F1E6 + (countryCode.charAt(1) - 'A')));
    }
}
