package tech.yash.datecalculatorspringboot;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.yash.datecalculatorspringboot.Calculator.CalculatorIO_withHibernate;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorRestController {

    @Autowired
    private CalculatorIO_withHibernate calculatorIO;

    @RequestMapping(value = "/date-calculator-result", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String calculatorResult(CustomJsonObject customJsonObject) throws FileNotFoundException, SQLException {

        String[] op_list = {"", "add_dates", "subtract_dates", "add_days", "add_weeks", "add_months", "get_day_of_week", "get_week_number", "natural_language_processor"};

        String ret_val = calculatorIO.executeSelectQuery(op_list[Integer.parseInt(customJsonObject.getOperation())], customJsonObject.getArg1(), customJsonObject.getArg2());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ret_val", ret_val);
        return jsonObject.toString();
    }

}
