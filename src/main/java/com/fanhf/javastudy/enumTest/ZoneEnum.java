package com.fanhf.javastudy.enumTest;

import org.apache.commons.lang3.StringUtils;

public enum ZoneEnum {

    ACT("ACT", "Australia/Darwin"),
    AET("AET", "Australia/Sydney"),
    AGT("AGT", "America/Argentina/Buenos_Aires"),
    ART("ART", "Africa/Cairo"),
    AST("AST", "America/Anchorage"),
    BET("BET", "America/Sao_Paulo"),
    BST("BST", "Asia/Dhaka"),
    CAT("CAT", "Africa/Harare"),
    CNT("CNT", "America/St_Johns"),
    CST("CST", "America/Chicago"),
    CTT("CTT", "Asia/Shanghai"),
    EAT("EAT", "Africa/Addis_Ababa"),
    ECT("ECT", "Europe/Paris"),
    IET("IET", "America/Indiana/Indianapolis"),
    IST("IST", "Asia/Kolkata"),
    JST("JST", "Asia/Tokyo"),
    MIT("MIT", "Pacific/Apia"),
    NET("NET", "Asia/Yerevan"),
    NST("NST", "Pacific/Auckland"),
    PLT("PLT", "Asia/Karachi"),
    PNT("PNT", "America/Phoenix"),
    PRT("PRT", "America/Puerto_Rico"),
    PST("PST", "America/Los_Angeles"),
    SST("SST", "Pacific/Guadalcanal"),
    VST("VST", "Asia/Ho_Chi_Minh"),
    EST("EST", "-05:00"),
    MST("MST", "-07:00"),
    HST("HST", "-10:00"),
    ;
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    ZoneEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getAgeNameByCode(String code) {
        if (code == null || StringUtils.isEmpty(code.toString())) {
            return null;
        }
        for (ZoneEnum ageEnum : ZoneEnum.values()) {
            if (code.equals(ageEnum.getCode())) {
                return ageEnum.getName();
            }
        }
        return null;
    }

    public static String getAgeNameCode(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (ZoneEnum ageEnum : ZoneEnum.values()) {
            if (name.equals(ageEnum.getName())) {
                return ageEnum.getCode();
            }
        }
        return null;
    }
}
