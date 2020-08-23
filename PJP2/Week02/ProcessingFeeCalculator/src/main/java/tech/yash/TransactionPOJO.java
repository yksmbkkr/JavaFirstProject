package tech.yash;

import java.util.Calendar;
import tech.yash.DateCalculator;

public class TransactionPOJO {
    private String uid;
    private String clientID;
    private String securityID;
    private Calendar date;
    private String type;
    private String priority;
    private String processingFee = "0";

    public TransactionPOJO(String uid, String clientID, String securityID, String date, String type, String priority) {
        this.uid = uid;
        this.clientID = clientID;
        this.securityID = securityID;
        this.date = DateCalculator.stringToDate(date);
        this.type = type;
        this.priority = priority;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getSecurityID() {
        return securityID;
    }

    public void setSecurityID(String securityID) {
        this.securityID = securityID;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setDateString(String date) {
        this.date = DateCalculator.stringToDate(date);
    }

    public String getDateString() {
        return DateCalculator.dateToString(this.date);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(String processingFee) {
        this.processingFee = processingFee;
    }
}
