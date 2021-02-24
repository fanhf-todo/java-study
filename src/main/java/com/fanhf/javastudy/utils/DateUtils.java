package com.fanhf.javastudy.utils;

import org.junit.jupiter.api.Test;

import javax.rmi.CORBA.Util;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author fanhf
 * @Description jdk8对日期的处理
 * @date 2021-01-12 17:32
 */
public class DateUtils {

    /**
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return LocalDate
     * @Description 根据给定年月日时间返回LocalDate实例
     **/
    public static LocalDate selfDefDate(int year, int month, int dayOfMonth) {
        if (0 == year || 0 == month || 0 == dayOfMonth) {
            return LocalDate.now();
        }
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return boolean
     * @Description 根据给定年月日时间判断和当前是否相等
     **/
    public static boolean dateEquals(int year, int month, int dayOfMonth) {
        LocalDate now = LocalDate.now();
        if (0 == year || 0 == month || 0 == dayOfMonth) {
            return false;
        }
        LocalDate defineDate = LocalDate.of(year, month, dayOfMonth);
        if (now.equals(defineDate)) {
            return true;
        }
        return false;
    }

    /**
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return boolean
     * @Description 根据给定年月日时间判断某年某月某日是否为生日（不论哪一年）
     **/
    public static boolean checkBirthday(int year, int month, int dayOfMonth) {
        if (0 == year || 0 == month || 0 == dayOfMonth) {
            return false;
        }
        LocalDate now = LocalDate.now();
        LocalDate selfDefine = LocalDate.of(year, month, dayOfMonth);
        MonthDay birthday = MonthDay.of(selfDefine.getMonth(), selfDefine.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(now);
        if (currentMonthDay.equals(birthday)) {
            return true;
        }
        return false;
    }

    /**
     * @param hours   时
     * @param minutes 分
     * @param seconds 秒
     * @return LocalTime
     * @Description 在当前时分秒的时间上，加上根据给定时分秒
     **/
    public static LocalTime plusDates(int hours, int minutes, int seconds) {
        LocalTime nowTime = LocalTime.now();
        LocalTime nextTimes = null;
        if (0 == hours && 0 == minutes && 0 == seconds) {
            return nowTime;
        }
        if (0 != hours) {
            nextTimes = nowTime.plusHours(hours);
        }
        if (0 != minutes) {
            nextTimes = nowTime.plusMinutes(minutes);
        }
        if (0 != seconds) {
            nextTimes = nowTime.plusSeconds(seconds);
        }
        if (0 != hours && 0 != minutes) {
            nextTimes = nowTime.plusHours(hours).plusMinutes(minutes);
        }
        if (0 != hours && 0 != seconds) {
            nextTimes = nowTime.plusHours(hours).plusSeconds(seconds);
        }
        if (0 != minutes && 0 != seconds) {
            nextTimes = nowTime.plusMinutes(minutes).plusSeconds(seconds);
        }
        if (0 != hours && 0 != minutes && 0 != seconds) {
            nextTimes = nowTime.plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
        }

        return nextTimes;
    }

    /**
     * @param hours   时
     * @param minutes 分
     * @param seconds 秒
     * @return LocalTime
     * @Description 在当前时分秒的时间上，减去根据给定时分秒
     **/
    public static LocalTime minusDates(int hours, int minutes, int seconds) {
        LocalTime nowTime = LocalTime.now();
        LocalTime previousTimes = null;
        if (0 == hours && 0 == minutes && 0 == seconds) {
            return nowTime;
        }
        if (0 != hours) {
            previousTimes = nowTime.minusHours(hours);
        }
        if (0 != minutes) {
            previousTimes = nowTime.minusMinutes(minutes);
        }
        if (0 != seconds) {
            previousTimes = nowTime.minusSeconds(seconds);
        }
        if (0 != hours && 0 != minutes) {
            previousTimes = nowTime.minusHours(hours).minusMinutes(minutes);
        }
        if (0 != hours && 0 != seconds) {
            previousTimes = nowTime.minusHours(hours).plusSeconds(seconds);
        }
        if (0 != minutes && 0 != seconds) {
            previousTimes = nowTime.plusMinutes(minutes).minusMinutes(seconds);
        }
        if (0 != hours && 0 != minutes && 0 != seconds) {
            previousTimes = nowTime.minusHours(hours).plusMinutes(minutes).minusMinutes(seconds);
        }

        return previousTimes;
    }

    /**
     * @param years  年
     * @param months 月
     * @param weeks  周
     * @param days   日
     * @return LocalDate
     * @Description 在当前年月周日的时间上，加上给定年月周日时间
     **/
    public static LocalDate beforeTimes(int years, int months, int weeks, int days) {
        LocalDate today = LocalDate.now();
        LocalDate previousDates = null; //previous
        if (0 == years && 0 == months && 0 == weeks && 0 == days) {
            return today;
        }
        if (0 != years) {
            previousDates = today.minusYears(years);
        }
        if (0 != months) {
            previousDates = today.minusMonths(months);
        }
        if (0 != weeks) {
            previousDates = today.minusWeeks(weeks);
        }
        if (0 != days) {
            previousDates = today.minusDays(days);
        }
        if (0 != years && 0 != months) {
            previousDates = today.minusYears(years).minusMonths(months);
        }
        if (0 != years && 0 != weeks) {
            previousDates = today.minusYears(years).minusWeeks(weeks);
        }
        if (0 != years && 0 != days) {
            previousDates = today.minusYears(years).minusDays(days);
        }
        if (0 != months && 0 != weeks) {
            previousDates = today.minusMonths(months).minusWeeks(weeks);
        }
        if (0 != months && 0 != days) {
            previousDates = today.minusMonths(months).minusDays(days);
        }
        if (0 != weeks && 0 != days) {
            previousDates = today.minusWeeks(weeks).minusDays(days);
        }
        if (0 != years && 0 != months && 0 != weeks) {
            previousDates = today.minusYears(years).minusMonths(months).minusWeeks(weeks);
        }
        if (0 != years && 0 != months && 0 != days) {
            previousDates = today.minusYears(years).minusMonths(months).minusDays(days);
        }
        if (0 != months && 0 != weeks && 0 != days) {
            previousDates = today.minusMonths(months).minusWeeks(weeks).minusDays(days);
        }
        if (0 != years && 0 != months && 0 != weeks && 0 != days) {
            previousDates = today.minusYears(years).minusMonths(months).minusWeeks(weeks).minusDays(days);
        }
        return previousDates;
    }

    /**
     * @param years  年
     * @param months 月
     * @param weeks  周
     * @param days   日
     * @return LocalDate
     * @Description 在当前年月周日的时间上，加上给定年月周日时间
     **/
    public static LocalDate afterTimes(int years, int months, int weeks, int days) {
        LocalDate today = LocalDate.now();
        LocalDate nextDate = null;
        if (0 == years && 0 == months && 0 == weeks && 0 == days) {
            return today;
        }
        if (0 != years) {
            nextDate = today.plusYears(years);
        }
        if (0 != months) {
            nextDate = today.plusMonths(months);
        }
        if (0 != weeks) {
            nextDate = today.plusWeeks(weeks);
        }
        if (0 != days) {
            nextDate = today.plusDays(days);
        }
        if (0 != years && 0 != months) {
            nextDate = today.plusYears(years).plusMonths(months);
        }
        if (0 != years && 0 != weeks) {
            nextDate = today.plusYears(years).plusWeeks(weeks);
        }
        if (0 != years && 0 != days) {
            nextDate = today.plusYears(years).plusDays(days);
        }
        if (0 != months && 0 != weeks) {
            nextDate = today.plusMonths(months).plusWeeks(weeks);
        }
        if (0 != months && 0 != days) {
            nextDate = today.plusMonths(months).plusDays(days);
        }
        if (0 != weeks && 0 != days) {
            nextDate = today.plusWeeks(weeks).plusDays(days);
        }
        if (0 != years && 0 != months && 0 != weeks) {
            nextDate = today.plusYears(years).plusMonths(months).plusWeeks(weeks);
        }
        if (0 != years && 0 != months && 0 != days) {
            nextDate = today.plusYears(years).plusMonths(months).plusDays(days);
        }
        if (0 != months && 0 != weeks && 0 != days) {
            nextDate = today.plusMonths(months).plusWeeks(weeks).plusDays(days);
        }
        if (0 != years && 0 != months && 0 != weeks && 0 != days) {
            nextDate = today.plusYears(years).plusMonths(months).plusWeeks(weeks).plusDays(days);
        }
        return nextDate;
    }

    /**
     * @param pulus1 年数
     * @return LocalDate
     * @Description 在当前年份上，加上给定年数
     **/
    public static LocalDate yearPlus1(int pulus1) {
        LocalDate today = LocalDate.now();
        if (0 == pulus1) {
            return today;
        }
        LocalDate handleYear = null;
        if (0 != pulus1) {
            handleYear = today.plus(pulus1, ChronoUnit.YEARS);
        }
        return handleYear;
    }

    /**
     * @param minus1 年数
     * @return LocalDate
     * @Description 在当前年份上，减去给定年数
     **/
    public static LocalDate yearMinus1(int minus1) {
        LocalDate today = LocalDate.now();
        if (0 == minus1) {
            return today;
        }
        LocalDate handleYear = null;
        if (0 != minus1) {
            handleYear = today.minus(minus1, ChronoUnit.YEARS);
        }
        return handleYear;
    }

    /**
     * @return long
     * @Description 返回UTC时区的当前年月日时分秒毫秒的毫秒值
     **/
    public static long clockMillis() {
        return Clock.systemUTC().millis();
    }

    /**
     * @return long
     * @Description 返回默认时区的当前年月日时分秒毫秒的时间戳
     **/
    public static long clockZoneMillis() {
        return Clock.systemDefaultZone().millis();
    }

    /**
     * @return long 当前时间的时分秒毫秒
     * @Description 返回默认时区的当前年月日时分秒毫秒的时间戳
     **/
    public static long currentTimeStamp() {
        Instant now = Instant.now();
        return now.toEpochMilli();
    }

    /**
     * @param beforeDays 当前日期的前多少天
     * @param format     日期格式
     *                   case 7:最近一周（前6天）
     *                   case 14:最近两周（前13天）
     *                   case 30:最近一个月（前29天）
     *                   case 90:最近三个月（前89天）
     * @return String
     * @Description 在当前时间点的基础上减去给定天数的时间
     */
    public static String getTimeBeforeDays(Integer beforeDays, String format) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.now();
        if (null == beforeDays) {
            return localDateTime.format(dateTimeFormatter);
        }
        LocalDateTime minus = null;
        switch (beforeDays.intValue()) {
            case 7:
                minus = localDateTime.minusDays(6L);
                break;
            case 14:
                minus = localDateTime.minusDays(13L);
                break;
            case 30:
                minus = localDateTime.minusDays(29L);
                break;
            case 90:
                minus = localDateTime.minusDays(89L);
                break;
            default:
                minus = localDateTime;
        }
        String time = minus.format(dateTimeFormatter);
        return time;
    }

    /**
     * @param time   自定义时间
     * @param format 时间格式
     * @return long 当前时间的时分秒毫秒
     * @Description 返回默认时区的当前年月日时分秒毫秒的时间戳
     * @apiNote time的格式和format的格式必须一致，否则就会异常
     **/
    public static long getSeconds(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(time, df);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli() / 1000;
    }

    /**
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return boolean
     * @Description 判断根据给定的年月日在当前年月日之前还是之后
     **/

    public static boolean dateAfter(int year, int month, int dayOfMonth) {
        LocalDate today = LocalDate.now();
        LocalDate compareDate = LocalDate.of(year, month, dayOfMonth);
        if (compareDate.isAfter(today)) {
            return true;
        }
        return false;
    }

    /**
     * @param zoneId 时区名称（从ZoneEnum枚举类中获取）
     * @return ZonedDateTime
     * @Description 将当前时间所在时区转为指定时区的时间
     **/

    public static ZonedDateTime zoneTransform(String zoneId) {
        ZoneId zone = ZoneId.of(zoneId);
        LocalDateTime now = LocalDateTime.now();
        return ZonedDateTime.of(now, zone);
    }

    /**
     * @return LocalDate
     * @Description 获取当前月的最后一天
     **/

    public static LocalDate EndOfMonth() {
        YearMonth currenYearMonth = YearMonth.now();
        return currenYearMonth.atEndOfMonth();
    }

    /**
     * @return int
     * @Description 根据给定年份的当前月的天数
     **/

    public static int lengthOfMonth() {
        YearMonth currenYearMonth = YearMonth.now();
        return currenYearMonth.lengthOfMonth();
    }

    /**
     * @return true是闰年，false是平年
     * @Description 判断当前年份是平年还是闰年
     **/

    public static boolean leapYear() {
        LocalDate now = LocalDate.now();
        if (now.isLeapYear()) {
            return true;
        }
        return false;
    }


    /**
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return Period 相差时间，可以获取到相差的年月日
     * @Description 根据给定年月日，算出和当前年月日相差的时间
     **/
    public static Period calculateGapInDaysOrMonth(int year, int month, int dayOfMonth) {
        LocalDate now = LocalDate.now();
        LocalDate selfDefine = LocalDate.of(year, month, dayOfMonth);
        return Period.between(now, selfDefine);
    }

    /**
     * @param time   时间
     * @param format 从枚举类中:DateFomateEnum获取
     * @return Duration 相差时间，可以获取到相差的时分秒
     * @Description 根据给定年月日，算出和当前时分秒相差的时间
     * @apiNote time的格式和format的格式必须一致，否则就会异常
     **/
    public static Duration calculateDurationInTimes(String time, String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime selfDefineTime = LocalDateTime.parse(time, df);
        Duration duration = Duration.between(selfDefineTime, now);
        return duration;
    }

    public static long differentDays(String date1, String date2, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDate selfDefineTime1 = LocalDate.parse(date1, df);
        LocalDate selfDefineTime2 = LocalDate.parse(date2, df);
        long days = Period.between(selfDefineTime1, selfDefineTime2).getDays();
        return days;
    }

    /**
     * @param date 给定日期
     * @return LocalDate 格式化后的日期 ，date 的格式必须为 YYYYMMDD，其他的格式都无法解析
     * @Description 将给定日期格式化为BASIC_ISO_DATE的日期格式
     **/
    public static LocalDate fomateDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * @param format 从枚举类中:DateFomateEnum获取
     * @return String 自定义格式化String类型日期
     * @Description 将当前时间格式化为指定的时间格式后转成string
     **/
    public static String localDate2String(String format) {
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedTime = null;
        if (format.toLowerCase().indexOf("z") != -1) {
            ZonedDateTime zdt2 = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
            formattedTime = DateTimeFormatter.ofPattern(format).format(zdt2);
        } else {
            formattedTime = dateTime.format(DateTimeFormatter.ofPattern(format));
        }
        return formattedTime;
    }

    /**
     * @param format 从枚举类中:DateFomateEnum获取
     * @return String 自定义格式化String类型日期
     * @Description 将给定时间格式化为指定的时间格式后转成string
     * @apiNote time的格式和format的格式必须一致，否则就会异常
     **/
    public static String selfDate2String(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime selfDefineTime = LocalDateTime.parse(time, df);
        String formattedTime = null;
        if (format.toLowerCase().indexOf("z") != -1) {
            ZonedDateTime zdt2 = ZonedDateTime.of(selfDefineTime, ZoneId.systemDefault());
            formattedTime = DateTimeFormatter.ofPattern(format).format(zdt2);
        } else {
            formattedTime = selfDefineTime.format(DateTimeFormatter.ofPattern(format));
        }
        return formattedTime;
    }

    /**
     * @param format 从枚举类中:DateFomateEnum获取
     * @return LocalDate 自定义格式日期类型
     * @Description 将给定时间格式化为指定的时间格式
     * @apiNote time的格式和format的格式必须一致，否则就会异常
     **/

    public static LocalDate string2LocalDate(String date, String format) {
        LocalDate formattedTime = null;

        if (format.toLowerCase().indexOf("z") != -1) {
            LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
            formattedTime = ZonedDateTime.of(ldt, ZoneId.systemDefault()).toLocalDate();
        } else {
            formattedTime = LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
        }
        return formattedTime;
    }

    public static void timestamp2String(long timestamps){
        Instant timestamp = Instant.ofEpochMilli(timestamps);
        LocalDateTime dateTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        String yyyyMM = dateTime.format(DateTimeFormatter.ofPattern("yyyyMM"));
        System.out.println("yyyyMM:" + yyyyMM);
    }
}
