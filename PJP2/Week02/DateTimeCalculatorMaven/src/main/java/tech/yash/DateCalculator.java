package tech.yash;

import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DateCalculator {

    public static Calendar add(Calendar date1, Calendar date2){
        Calendar ret_cal = (Calendar) date1.clone();
        ret_cal.add(Calendar.YEAR, date2.get(Calendar.YEAR));
        ret_cal.add(Calendar.MONTH, date2.get(Calendar.MONTH));
        ret_cal.add(Calendar.DATE, date2.get(Calendar.DATE));
        return ret_cal;
    }

    public static HashMap<String, Long> subtract(Calendar date1, Calendar date2){
        LocalDate from, to;
        if (date1.before(date2)){
            from = LocalDateTime.ofInstant(date1.toInstant(), date1.getTimeZone().toZoneId()).toLocalDate();
            to = LocalDateTime.ofInstant(date2.toInstant(), date2.getTimeZone().toZoneId()).toLocalDate();
        } else {
            from = LocalDateTime.ofInstant(date2.toInstant(), date2.getTimeZone().toZoneId()).toLocalDate();
            to = LocalDateTime.ofInstant(date1.toInstant(), date1.getTimeZone().toZoneId()).toLocalDate();
        }
        HashMap<String, Long> diff = new HashMap<String, Long>();
        diff.put("DAYS", ChronoUnit.DAYS.between(from, to));
        diff.put("WEEKS", ChronoUnit.WEEKS.between(from, to));
        diff.put("MONTHS", ChronoUnit.MONTHS.between(from, to));

        return diff;
    }

    public static String dateToString(Calendar date){
        return new SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(date.getTime());
    }

    public static Calendar stringToDate(String date){
        Calendar ret_cal = Calendar.getInstance();
        int[] d =Stream.of(date.split(" ")).mapToInt(Integer::parseInt).toArray();
        if (d.length != 3){
            throw new InvalidParameterException("Date should have exactly 3 values.");
        }
        ret_cal.set(d[2], d[1]-1, d[0]);
        return ret_cal;
    }

    public static Calendar addWeeks(Calendar date, int weeks){
        date.add(Calendar.WEEK_OF_YEAR, weeks);
        return date;
    }

    public static Calendar addDays(Calendar date, int days){
        date.add(Calendar.DAY_OF_MONTH, days);
        return date;
    }

    public static Calendar addMonths(Calendar date, int months){
        date.add(Calendar.MONTH, months);
        return date;
    }

    public static String getWeekofYear(Calendar date){
        return Integer.toString(date.get(Calendar.WEEK_OF_YEAR));
    }

    public static String getDayofWeek(Calendar date){
        return new SimpleDateFormat("EEEE").format(date.getTime());
    }

    public static Calendar smartConverter(String string){
//        System.out.println("\n########"+string+"#######\n");
        string = string.toLowerCase();
        final Calendar[] date = new Calendar[1];

        int diff = 0;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()){
            diff = Integer.parseInt(matcher.group(0));
        }
        string = string.replaceAll("\\d","");
        string = string.strip();
//        System.out.println(diff);
//        System.out.println(string);

        Map<String, Consumer<Integer>> smartLambdas = new HashMap<>();
//        commands.put("today", (String i_val) -> System.out.println(i_val));
//        commands.get("today").accept("Hello");
        smartLambdas.put("today", (Integer n) -> {
            date[0] = Calendar.getInstance();
        });
        smartLambdas.put("tomorrow", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.DAY_OF_MONTH, 1);
        });
        smartLambdas.put("day after tomorrow", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.DAY_OF_MONTH, 2);
        });
        smartLambdas.put("yesterday", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.DAY_OF_MONTH, -1);
        });
        smartLambdas.put("day before yesterday", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.DAY_OF_MONTH, -2);
        });
        smartLambdas.put("last week", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.WEEK_OF_YEAR, -1);
        });
        smartLambdas.put("previous week", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.WEEK_OF_YEAR, -1);
        });
        smartLambdas.put("last month", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.MONTH, -1);
        });
        smartLambdas.put("last year", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.YEAR, -1);
        });
        smartLambdas.put("month after", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.MONTH, 1);
        });
        smartLambdas.put("next month", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.MONTH, 1);
        });
        smartLambdas.put("next week", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.WEEK_OF_YEAR, 1);
        });
        smartLambdas.put("next year", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.YEAR, 1);
        });
        smartLambdas.put("month before", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.MONTH, -1);
        });
        smartLambdas.put("weeks from now", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.WEEK_OF_YEAR, n);
        });
        smartLambdas.put("days from now", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.DAY_OF_MONTH, n);
        });
        smartLambdas.put("months from now", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.MONTH, n);
        });
        smartLambdas.put("years from now", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.YEAR, n);
        });
        smartLambdas.put("weeks earlier", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.WEEK_OF_YEAR, -n);
        });
        smartLambdas.put("days earlier", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.DAY_OF_MONTH, -n);
        });
        smartLambdas.put("months earlier", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.MONTH, -n);
        });
        smartLambdas.put("years earlier", (Integer n) -> {
            date[0] = Calendar.getInstance();
            date[0].add(Calendar.YEAR, -n);
        });


        if(smartLambdas.containsKey(string)){
            smartLambdas.get(string).accept(diff);
        } else {
            throw new InvalidParameterException("Smart string to date converter currently do not understand "+string);
//            return date[0];
        }

        return date[0];
    }
}

