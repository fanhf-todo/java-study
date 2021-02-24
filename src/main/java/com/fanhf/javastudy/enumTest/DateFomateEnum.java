package com.fanhf.javastudy.enumTest;

import org.apache.commons.lang3.StringUtils;

/**
 * @author fanhf
 * @Description 日期格式枚举类
 * @date 2021-01-13 10:00
 */
public enum DateFomateEnum {
    DATE_FORMAT_RFC_1123_3_YEAR(11230, "EEE, dd.MM.yyyy, HH:mm:ss"),
    DATE_FORMAT_RFC_1123_MONTH_YEAR(11231, "EEE, dd MMM yyyy HH:mm:ss"),
    DATE_FORMAT_RFC_1123_MONTH_YEAR_NO_SECOND(11232, "EEE, dd MMM yy HH:mm"),
    DATE_FORMAT_RFC_1123_VARIANT(11233, "EEE, MMM dd yyyy HH:mm:ss"),

    DATE_FORMAT_RFC_1123_3_TIMEZONE(11234, "EEE, dd.MM.yyyy HH:mm:ss z"),
    DATE_FORMAT_RFC_1123_TIMEZONE(11235, "EEE, dd MMM yyyy HH:mm:ss z"),
    DATE_FORMAT_RFC_1123_NO_SECOND_TIMEZONE(11236, "EEE, dd MMM yyyy HH:mm z"),
    DATE_FORMAT_RFC_1123_VARIANT_TIMEZONE(11237, "EEE, MMM dd yyyy HH:mm:ss z"),

    DATE_FORMAT_RFC_1123_NO_WEEKDAY_TIMEZONE_4_YEAR(11238, "dd MMM yyyy HH:mm:ss z"),
    DATE_FORMAT_RFC_1123_NO_WEEKDAY_TIMEZONE_NO_SECOND(11239, "dd MMM yy HH:mm z"),
    DATE_FORMAT_RFC_1123_NO_WEEKDAY_SECOND_4_YEAR_HOUR(11240, "dd MMM yyyy HH z"),

    DATE_FORMAT_RFC_822_2_YEAR_ZONE_OFFSET(82202, "EEE, dd MMM yy HH:mm:ss Z"),
    DATE_FORMAT_RFC_822_4_YEAR_ZONE_OFFSET(82204, "EEE, dd MMM yyyy HH:mm:ss Z"),
    DATE_FORMAT_RFC_822_3_4_YEAR_ZONE_OFFSET(82203, "EEE, dd.MM.yyyy HH:mm:ss Z"),
    DATE_FORMAT_RFC_822_4_VARIANT_ZONE_OFFSET(82240, "EEE, MMM dd yyyy HH:mm:ss Z"),

    DATE_FORMAT_SIMPLE_2(31110, "MMM dd ,yyyy"),

    DATE_FORMAT_ISO_8601_MODE_0(86009, "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ"),
    DATE_FORMAT_ISO_8601_MODE_1(86011, "yyyy-MM-dd'T'HH:mm:ss Z"),
    DATE_FORMAT_ISO_8601_MODE_2(86012, "yyyy-MM-dd'T'HH:mm:ss'Z'"),
    DATE_FORMAT_ISO_8601_MODE_3(86013, "yyyy-MM-dd'T'HH:mm:sszzzz"),
    DATE_FORMAT_ISO_8601_MODE_4(86014, "yyyy-MM-dd'T'HH:mm:ss z"),
    DATE_FORMAT_ISO_8601_MODE_5(86015, "yyyy-MM-dd'T'HH:mm:ss.SSSz"),
    DATE_FORMAT_ISO_8601_MODE_6(86016, "yyyy-MM-dd'T'HH:mm:ss.SSS Z"),
    DATE_FORMAT_ISO_8601_MODE_7(86017, "yyyy-MM-dd'T'HH:mm:ss"),
    DATE_FORMAT_ISO_8601_MODE_8(86018, "yyyy-MM-dd'T'HH:mm Z"),
    DATE_FORMAT_ISO_8601_MODE_9(86009, "yyyy-MM-dd'T'HH:mm'Z'"),


    DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS(11110, "yyyy-MM-dd HH:mm:ss"),
    DATE_FORMAT_SLASH_YYYY_MM_DD_HH_MM_SS(11111, "yyyy/MM/dd HH:mm:ss"),
    DATE_FORMAT_SIMPLE_YYYYMMDD_HHMMSS(11112, "yyyyMMdd HH:mm:ss"),
    DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM(21110, "yyyy-MM-dd HH:mm"),
    DATE_FORMAT_SLASH_YYYY_MM_DD_HH_MM(21111, "yyyy/MM/dd HH:mm"),
    DATE_FORMAT_SIMPLE_YYYYMM_DD_HH_MM(21112, "yyyyMMdd HH:mm"),
    DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH(31110, "yyyy-MM-dd HH"),
    DATE_FORMAT_SLASH_YYYY_MM_DD_HH(31111, "yyyy/MM/dd HH"),
    DATE_FORMAT_SIMPLE_YYYYMMDD_HH(31112, "yyyyMMdd HH"),
    DATE_FORMAT_SIMPLE_YYYY_MM_DD(41110, "yyyy-MM-dd"),
    DATE_FORMAT_SLASH_YYYY_MM_DD(41111, "yyyy/MM/dd"),
    DATE_FORMAT_SIMPLE_YYYYMMDD(41112, "yyyyMMdd"),
    DATE_FORMAT_SIMPLE_YYYY_MM(51110, "yyyy-MM"),
    DATE_FORMAT_SLASH_YYYY_MM(51111, "yyyy/MM"),
    DATE_FORMAT_SIMPLE_YYYYMM(51112, "yyyyMM"),
    ;

    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    DateFomateEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getAgeNameByCode(Integer code) {
        if (code == null || StringUtils.isEmpty(code.toString())) {
            return null;
        }
        for (DateFomateEnum ageEnum : DateFomateEnum.values()) {
            if (code.equals(ageEnum.getCode())) {
                return ageEnum.getName();
            }
        }
        return null;
    }

    public static Integer getAgeNameCode(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }

        for (DateFomateEnum ageEnum : DateFomateEnum.values()) {
            if (name.equals(ageEnum.getName())) {
                return ageEnum.getCode();
            }
        }
        return null;
    }
}
