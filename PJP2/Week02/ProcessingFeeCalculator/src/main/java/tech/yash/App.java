package tech.yash;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        ArrayList<TransactionPOJO> transactions = FileProcessor.parseTransactionFile("sample_transaction.txt");
        TransactionProcessor transactionProcessor = new TransactionProcessor();
        transactions.forEach(transactionProcessor::addTransaction);
        transactionProcessor.processAll();
//        transactions.forEach(temp -> System.out.println(temp.getProcessingFee()));
        FileProcessor.generateProcessingFeeFile(transactions, "sample_transactions_with_fee.txt");
    }
}
