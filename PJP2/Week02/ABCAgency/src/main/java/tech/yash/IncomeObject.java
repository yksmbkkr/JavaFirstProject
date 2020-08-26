package tech.yash;

import java.text.DecimalFormat;
import java.util.regex.Matcher;

public class IncomeObject {
    private String City;
    private String Country;
    private String Gender;
    private String Currency;
    private String Amount;

    public IncomeObject(String city, String country, String gender, String currency, String amount) {
        City = city.toLowerCase();
        Country = country.toLowerCase();
        Gender = gender.toLowerCase();
        Currency = currency.toLowerCase();
        Amount = this.convertToUSD(amount.toLowerCase(), currency.toLowerCase());
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    private String convertToUSD(String income, String currency){

        double retval;

        if(currency.toString().contains("inr")) {

            retval = (Double.parseDouble(income)/66);

        }else if(currency.toString().contains("gbp")) {
           retval = (Double.parseDouble(income)/0.67);

        }else if(currency.toString().contains("sgd")) {

            retval = (Double.parseDouble(income)/1.5);
        }else if(currency.toString().contains("hkd")) {

            retval=(Double.parseDouble(income)/8);
        }else {
            return income;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(retval)).toString();
    }
}
