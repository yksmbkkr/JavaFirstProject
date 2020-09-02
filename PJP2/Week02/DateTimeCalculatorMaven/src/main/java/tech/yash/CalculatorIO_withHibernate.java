package tech.yash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.function.Consumer;

public class CalculatorIO_withHibernate extends CalculatorIO{
    final Object[] result = new Object[1];
    ArrayList<String> menuOptions;
    Map<Integer, Consumer<Integer>> smartLambdaMap = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);
//    Connection con;
    private SessionFactory factory;

    CalculatorIO_withHibernate() throws SQLException, FileNotFoundException {
        this.menuOptions = new ArrayList<>();

        this.menuOptions.add("Press 1 to add dates - ");
        this.menuOptions.add("Press 2 to subtract dates - ");
        this.menuOptions.add("Press 3 to add/subtract days from a specific date - ");
        this.menuOptions.add("Press 4 to add/subtract weeks from a specific date - ");
        this.menuOptions.add("Press 5 to add/subtract months from a specific date - ");
        this.menuOptions.add("Press 6 to determine the Day of the Week for a specific date - ");
        this.menuOptions.add("Press 7 to determine the Week Number for a specific date - ");
        this.menuOptions.add("Press 8 to get date from a natural language string - ");
        this.factory = new Configuration().configure().buildSessionFactory();
//        this.con = getDBConnection();

        String universalQuery = "SELECT perform_operation('%s', '%s', '%s');";

        smartLambdaMap.put(1, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing Addition\n");
            System.out.println("Input date 1 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            System.out.println("Input date 2 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date2 = getStringInput();
            try {
                result[0] = this.executeSelectQuery("add_dates", date1, date2);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(2, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing Subtraction\n");
            System.out.println("Input date 1 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            System.out.println("Input date 2 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date2 = getStringInput();
            try {
                result[0] = this.executeSelectQuery("subtract_dates", date1, date2);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(3, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing add/subtract days from a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            System.out.println("Input days to add or subtract (e.g. 20 or -20) > ");
            String diff = getStringInput();
            try {
                result[0] = this.executeSelectQuery("add_days", date1, diff);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(4, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing add/subtract weeks from a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            System.out.println("Input weeks to add or subtract (e.g. 20 or -20) > ");
            String diff = getStringInput();
            try {
                result[0] = this.executeSelectQuery("add_weeks", date1, diff);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(5, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing add/subtract months from a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            System.out.println("Input months to add or subtract (e.g. 20 or -20) > ");
            String diff = getStringInput();
            try {
                result[0] = this.executeSelectQuery("add_months", date1, diff);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(6, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Determining the Day of the Week for a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            try {
                result[0] = this.executeSelectQuery("get_day_of_week", date1, "0");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(7, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Determining the Week Number for a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String date1 = getStringInput();
            try {
                result[0] = this.executeSelectQuery("get_week_number", date1, "0");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        smartLambdaMap.put(8, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Getting date from a natural language string\n");
            System.out.println("\tAvailable options are - ");
            System.out.println("\tToday, Tomorrow, Day after tomorrow, yesterday, Day before yesterday, Last week, Previous week, Next " +
                    "week, Next month, Next Year, Last month, Last year, Month after, Month " +
                    "before, n weeks from now, n days from now, n months from now, n years " +
                    "from now, n days earlier, n weeks earlier, n months earlier, n years earlier.");
//            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            String phrase = getStringInput();
            try {
                result[0] = this.executeSelectQuery("natural_language_processor", phrase, "0");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public Connection getDBConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        String mysqlUrl = "jdbc:postgresql://35.229.248.239:9274/datetimecalculatordb";
        return DriverManager.getConnection(mysqlUrl, Credentials.uname, Credentials.passwd);
    }

    public String executeSelectQuery(String op, String arg1, String arg2) throws SQLException {
        Session session = factory.openSession();
        Calendar calendar = Calendar.getInstance();
        long startTime = calendar.getTimeInMillis();
        Transaction tx = session.beginTransaction();
        StoredProcedureQuery spq = session.createNamedStoredProcedureQuery("perform_operation_sp");
        spq.setParameter("operation", op);
        spq.setParameter("arg1", arg1);
        spq.setParameter("arg2", arg2);

        String ret_val = (String) spq.getSingleResult();
        tx.commit();
        Calendar calendarEnd = Calendar.getInstance();
        long endTime = calendarEnd.getTimeInMillis();
        Query query = session.createNativeQuery("SELECT uid FROM date_operations ORDER BY uid DESC LIMIT 1");
        String uid = String.valueOf(query.uniqueResult());
        String queryString = String.format("INSERT INTO execution_time (time_taken, uid) VALUES ('%s', %s);", endTime-startTime, uid);
        Transaction tx2 = session.beginTransaction();
        session.createNativeQuery(queryString).executeUpdate();
        tx2.commit();
        return ret_val;
    }

    public void performOperation(int op) throws IOException {
        if (this.smartLambdaMap.containsKey(op)){
            this.smartLambdaMap.get(op).accept(0);
            if (result[0].getClass() == GregorianCalendar.class){
                System.out.println("Result of operation - ");
                System.out.println(DateCalculator.dateToString(((Calendar) result[0])));
                System.out.println("##################################################");
            } else if (result[0].getClass() == String.class) {
                System.out.println("Result of operation - ");
                System.out.println(result[0]);
                System.out.println("##################################################");
            } else {
                System.out.println("Result of operation - ");
                System.out.println(((HashMap<String, Long>) result[0]).toString());
                System.out.println("##################################################");
            }
        }
    }
}
