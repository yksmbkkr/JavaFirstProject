package tech.yash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class TransactionProcessor {
    HashMap<String, ArrayList<TransactionPOJO>> transactions;

    public TransactionProcessor() {
        this.transactions = new HashMap<>();
    }

    public HashMap<String, ArrayList<TransactionPOJO>> getTransactions() {
        return transactions;
    }

    public void addTransaction(TransactionPOJO temp){
        String hash_idx = temp.getClientID()+"|"+temp.getSecurityID()+"|"+temp.getDateString();
        if (this.transactions.containsKey(hash_idx)){
            this.transactions.get(hash_idx).add(temp);
        } else {
            ArrayList<TransactionPOJO> temp_list = new ArrayList<>();
            temp_list.add(temp);
            this.transactions.put(hash_idx, temp_list);
        }
    }

    public int feeCalculator(TransactionPOJO transaction, ArrayList<TransactionPOJO> transactions){
        if (transaction.getPriority().toLowerCase().strip().charAt(0) == 'y'){
            transaction.setProcessingFee("500");
            return 500;
        }
        String current = transaction.getType();
        String toFind = "";
        if (current.toLowerCase().equals("buy")){
            toFind = "sell";
        } else {
            toFind = "buy";
        }
        Boolean intraDay;
        if (transactions.size() > 1 && (transaction.getType().toLowerCase().equals("buy") || transaction.getType().toLowerCase().equals("sell"))){
            String finalToFind = toFind;
            try {
                TransactionPOJO temp = transactions.stream()
                                                .filter(x -> x.getType().toLowerCase().equals(finalToFind) && x.getProcessingFee().equals("0"))
                                                .findFirst().get();
                temp.setProcessingFee("10");
                transaction.setProcessingFee("10");
                return 10;
            }
            catch (NoSuchElementException noSuchElementException){
                if (transaction.getType().toLowerCase().equals("buy")){
                    transaction.setProcessingFee("50");
                    return 50;
                } else {
                    transaction.setProcessingFee("100");
                    return 100;
                }
            }

        } else {
            if (transaction.getType().toLowerCase().equals("sell") || transaction.getType().toLowerCase().equals("withdraw")){
                transaction.setProcessingFee("100");
                return 100;
            } else {
                transaction.setProcessingFee("50");
                return 50;
            }
        }
//        ArrayList<TransactionPOJO> probableIntraday =
    }

    public void processAll(){
        this.transactions.keySet().forEach(entry ->
                this.transactions.get(entry).forEach(temp ->
                        System.out.println(feeCalculator(temp, this.transactions.get(entry)))));
    }
}
