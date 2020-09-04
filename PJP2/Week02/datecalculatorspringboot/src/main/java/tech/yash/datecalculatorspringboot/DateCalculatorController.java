package tech.yash.datecalculatorspringboot;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.yash.datecalculatorspringboot.Calculator.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@Controller
public class DateCalculatorController {

    @RequestMapping(value = "/date-calculator", method = RequestMethod.GET)
    public String calculatorHome(){
        return "calculatorHome";
    }

    @RequestMapping(value = "/date-calculator-result", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String calculatorResult(CustomJsonObject customJsonObject) throws FileNotFoundException, SQLException {

        CalculatorIO_withHibernate calculatorIO = new CalculatorIO_withHibernate();

        String[] op_list = {"", "add_dates", "subtract_dates", "add_days", "add_weeks", "add_months", "get_day_of_week", "get_week_number", "natural_language_processor"};

        String ret_val = calculatorIO.executeSelectQuery(op_list[Integer.parseInt(customJsonObject.getOperation())], customJsonObject.getArg1(), customJsonObject.getArg2());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ret_val", ret_val);
        return jsonObject.toString();
    }
}
