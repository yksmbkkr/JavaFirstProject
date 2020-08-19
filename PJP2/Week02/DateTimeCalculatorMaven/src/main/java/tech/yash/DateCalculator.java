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
    private Calendar date1;
    private Calendar date2;
    private LocalDate localDate1, localDate2;

    public DateCalculator(int[] date1, int[] date2) {
        if (date1.length != 3 || date2.length != 3){
            throw new InvalidParameterException("Date1 or Date2 should have exactly 3 values.");
        }
        this.date1 = Calendar.getInstance();
        this.date1.set(date1[2], date1[1]-1, date1[0]);
        this.date2 = Calendar.getInstance();
        this.date2.set(date2[2], date2[1]-1, date2[0]);

        this.localDate1 = LocalDateTime.ofInstant(this.date1.toInstant(), this.date1.getTimeZone().toZoneId()).toLocalDate();
        this.localDate2 = LocalDateTime.ofInstant(this.date2.toInstant(), this.date2.getTimeZone().toZoneId()).toLocalDate();
    }

    public Calendar getDate1() {
        return date1;
    }

    public void setDate1(Calendar date1) {
        this.date1 = date1;
    }

    public Calendar getDate2() {
        return date2;
    }

    public void setDate2(Calendar date2) {
        this.date2 = date2;
    }

    public Calendar add(){
        Calendar ret_cal = (Calendar) this.date1.clone();
        ret_cal.add(Calendar.YEAR, this.date2.get(Calendar.YEAR));
        ret_cal.add(Calendar.MONTH, this.date2.get(Calendar.MONTH));
        ret_cal.add(Calendar.DATE, this.date2.get(Calendar.DATE));
        return ret_cal;
    }

    public HashMap<String, Long> subtract(){
        LocalDate from, to;
        if (this.date1.before(this.date2)){
            from = this.localDate1;
            to = this.localDate2;
        } else {
            from = this.localDate2;
            to = this.localDate1;
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

    public static int getWeekofYear(Calendar date){
        return date.get(Calendar.WEEK_OF_YEAR);
    }

    public static String getDayofWeek(Calendar date){
        return new SimpleDateFormat("EEEE").format(date.getTime());
    }

    public static Calendar smartConverter(String string){
        System.out.println("\n########"+string+"#######\n");
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

