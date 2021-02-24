package com.fanhf.javastudy.utils;

import com.fanhf.javastudy.enumTest.DateFomateEnum;
import com.fanhf.javastudy.enumTest.ZoneEnum;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assume;
import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void selfDefDate() {
        System.out.println(DateUtils.selfDefDate(2021, 1, 1).getYear());
    }

    @Test
    void dateEquals() {
        System.out.println(DateUtils.dateEquals(2021, 0, 0));
    }

    @Test
    void checkBirthday() {
        System.out.println(DateUtils.checkBirthday(0, 1, 13));
    }

    @Test
    void plusDates() {
        System.out.println(DateUtils.plusDates(0, 0, 0));
        System.out.println(DateUtils.plusDates(5, 0, 0));
        System.out.println(DateUtils.plusDates(0, 10, 0));
        System.out.println(DateUtils.plusDates(0, 0, 10));
        System.out.println(DateUtils.plusDates(5, 10, 0));
        System.out.println(DateUtils.plusDates(0, 10, 10));
        System.out.println(DateUtils.plusDates(5, 0, 10));
        System.out.println(DateUtils.plusDates(5, 10, 10));
    }

    @Test
    void minusDates() {
        System.out.println(DateUtils.minusDates(0, 0, 0));
        System.out.println(DateUtils.minusDates(5, 0, 0));
        System.out.println(DateUtils.minusDates(0, 10, 0));
        System.out.println(DateUtils.minusDates(0, 0, 10));
        System.out.println(DateUtils.minusDates(5, 10, 0));
        System.out.println(DateUtils.minusDates(0, 10, 10));
        System.out.println(DateUtils.minusDates(5, 0, 10));
        System.out.println(DateUtils.minusDates(5, 10, 10));
    }

    @Test
    void afterTimes() {
        System.out.println(DateUtils.afterTimes(0, 0, 0, 0));
        System.out.println(DateUtils.afterTimes(1, 0, 0, 0));
        System.out.println(DateUtils.afterTimes(0, 1, 0, 0));
        System.out.println(DateUtils.afterTimes(0, 0, 1, 0));
        System.out.println(DateUtils.afterTimes(0, 0, 0, 1));
        System.out.println(DateUtils.afterTimes(1, 1, 0, 0));
        System.out.println(DateUtils.afterTimes(1, 0, 1, 0));
        System.out.println(DateUtils.afterTimes(1, 0, 0, 1));
        System.out.println(DateUtils.afterTimes(0, 1, 1, 0));
        System.out.println(DateUtils.afterTimes(0, 1, 0, 1));
        System.out.println(DateUtils.afterTimes(0, 0, 1, 1));
        System.out.println(DateUtils.afterTimes(1, 1, 1, 0));
        System.out.println(DateUtils.afterTimes(0, 1, 1, 1));
        System.out.println(DateUtils.afterTimes(1, 1, 0, 1));
        System.out.println(DateUtils.afterTimes(1, 1, 1, 1));
    }

    @Test
    void beforeTimes() {
        System.out.println(DateUtils.beforeTimes(0, 0, 0, 0));
        System.out.println(DateUtils.beforeTimes(1, 0, 0, 0));
        System.out.println(DateUtils.beforeTimes(0, 1, 0, 0));
        System.out.println(DateUtils.beforeTimes(0, 0, 1, 0));
        System.out.println(DateUtils.beforeTimes(0, 0, 0, 1));
        System.out.println(DateUtils.beforeTimes(1, 1, 0, 0));
        System.out.println(DateUtils.beforeTimes(1, 0, 1, 0));
        System.out.println(DateUtils.beforeTimes(1, 0, 0, 1));
        System.out.println(DateUtils.beforeTimes(0, 1, 1, 0));
        System.out.println(DateUtils.beforeTimes(0, 1, 0, 1));
        System.out.println(DateUtils.beforeTimes(0, 0, 1, 1));
        System.out.println(DateUtils.beforeTimes(1, 1, 1, 0));
        System.out.println(DateUtils.beforeTimes(0, 1, 1, 1));
        System.out.println(DateUtils.beforeTimes(1, 1, 0, 1));
        System.out.println(DateUtils.beforeTimes(1, 1, 1, 1));
    }

    @Test
    void yearPlus1() {
        System.out.println(DateUtils.yearPlus1(0));
    }

    @Test
    void yearMinus1() {
        System.out.println(DateUtils.yearMinus1(3));
    }

    @Test
    void clockMillis() {
        System.out.println(DateUtils.clockMillis());
    }

    @Test
    void clockZoneMillis() {
        System.out.println(DateUtils.clockZoneMillis());
    }

    @Test
    void currentTimeStamp() {
        System.out.println(DateUtils.currentTimeStamp());
    }

    @Test
    void getTimeBeforeDays() {
        /**
         * case 7:最近一周（前6天）
         * case 14:最近两周（前13天）
         * case 30:最近一个月（前29天）
         * case 90:最近三个月（前89天）
         */
        System.out.println(DateUtils.getTimeBeforeDays(4, DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
        System.out.println(DateUtils.getTimeBeforeDays(7, DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
        System.out.println(DateUtils.getTimeBeforeDays(14, DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
        System.out.println(DateUtils.getTimeBeforeDays(30, DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
        System.out.println(DateUtils.getTimeBeforeDays(90, DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
    }

    @Test
    void getSeconds() {
        System.out.println(DateUtils.getSeconds("2020-01-01 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
    }

    @Test
    void dateAfter() {
        System.out.println(DateUtils.dateAfter(2021, 1, 14));
    }

    @Test
    void zoneTransform() {
        System.out.println(DateUtils.zoneTransform(ZoneEnum.CTT.getName()));
    }

    @Test
    void creditCardExpired() {
        System.out.println(DateUtils.EndOfMonth());
    }

    @Test
    void lengthOfMonth() {
        System.out.println(DateUtils.lengthOfMonth());
    }

    @Test
    void leapYear() {
        System.out.println(DateUtils.leapYear());
    }

    @Test
    void calculateGapInDaysOrMonth() {
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1));
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).getDays());
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).getYears());
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).getMonths());
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).minusDays(10));
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).minusDays(10).getDays());
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).plusMonths(1));
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).plusMonths(1).getMonths());
        System.out.println(DateUtils.calculateGapInDaysOrMonth(2020, 1, 1).withDays(5));
    }

    @Test
    void calculateDurationInTimes() {
        System.out.println(DateUtils.calculateDurationInTimes(
                "2020-01-01 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()).minusDays(10).getSeconds());
        System.out.println(DateUtils.calculateDurationInTimes(
                "2020/01/01 00:00:00", DateFomateEnum.DATE_FORMAT_SLASH_YYYY_MM_DD_HH_MM_SS.getName()).getSeconds());
        System.out.println(DateUtils.calculateDurationInTimes(
                "20200101 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYYMMDD_HHMMSS.getName()).toMinutes());
        System.out.println(DateUtils.calculateDurationInTimes(
                "20200101 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYYMMDD_HHMMSS.getName()).toDays());
        System.out.println(DateUtils.calculateDurationInTimes(
                "2020-01-01 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()).toHours());
    }

    @Test
    void fomateDate() {
        System.out.println(DateUtils.fomateDate("20210101"));
    }

    @Test
    void localDate2String() {
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_3_YEAR.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_MONTH_YEAR.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_MONTH_YEAR_NO_SECOND.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_VARIANT.getName()));
        System.out.println("-------------------------------------------------");

        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_3_TIMEZONE.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_TIMEZONE.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_NO_SECOND_TIMEZONE.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_VARIANT_TIMEZONE.getName()));
        System.out.println("-------------------------------------------------");

        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_NO_WEEKDAY_TIMEZONE_NO_SECOND.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_NO_WEEKDAY_TIMEZONE_4_YEAR.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_1123_NO_WEEKDAY_SECOND_4_YEAR_HOUR.getName()));
        System.out.println("-------------------------------------------------");

        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_822_2_YEAR_ZONE_OFFSET.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_822_4_YEAR_ZONE_OFFSET.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_822_3_4_YEAR_ZONE_OFFSET.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_RFC_822_4_VARIANT_ZONE_OFFSET.getName()));
        System.out.println("-------------------------------------------------");

        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_SIMPLE_2.getName()));
        System.out.println("-------------------------------------------------");

        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_0.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_1.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_2.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_3.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_4.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_5.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_6.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_7.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_8.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_ISO_8601_MODE_9.getName()));
        System.out.println("-------------------------------------------------");

        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_SLASH_YYYY_MM_DD_HH_MM_SS.getName()));
        System.out.println(DateUtils.localDate2String(DateFomateEnum.DATE_FORMAT_SIMPLE_YYYYMMDD_HHMMSS.getName()));
    }

    @Test
    void selfDate2String() {
        System.out.println(DateUtils.selfDate2String("2020-01-01 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD_HH_MM_SS.getName()));
    }

    @Test
    void string2LocalDate() {
        System.out.println(DateUtils.string2LocalDate("20200101 00:00:00", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYYMMDD_HHMMSS.getName()));
    }

    @Test
    void differentDays() {
        System.out.println(DateUtils.differentDays("2021-01-01", "2021-01-19", DateFomateEnum.DATE_FORMAT_SIMPLE_YYYY_MM_DD.getName()));
    }
    @Test
    void test(){
        String snowflakeMd5 = DigestUtils.md5Hex(
                String.format("%s|%s|%s","123456",
                        RandomStringUtils.randomAlphanumeric(20),
                        "15894663826"));
        try {
            byte[] qrcode = QRCodeUtil.getCodeByte("FHF_" + snowflakeMd5);
            String loginQrcode = "data:image/png;base64," + Base64Utils.encodeToString(qrcode);
            System.out.println("loginQrcode:" + loginQrcode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testtimes() {
        DateUtils.timestamp2String(1614050357);
    }
}