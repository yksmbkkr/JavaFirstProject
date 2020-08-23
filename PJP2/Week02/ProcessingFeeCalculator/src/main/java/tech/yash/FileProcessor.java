package tech.yash;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileProcessor {

    public static ArrayList<TransactionPOJO> parseTransactionFile(String path) throws FileNotFoundException {
        ArrayList<TransactionPOJO> transactions = new ArrayList<>();
        path = path.strip();
        Scanner s = new Scanner(new FileReader(path));
        while (s.hasNext()) {
            String[] transactionDetail = s.nextLine().split("\\|");
            TransactionPOJO transactionPOJO = new TransactionPOJO(transactionDetail[0], transactionDetail[1],
                    transactionDetail[2], transactionDetail[3], transactionDetail[4], transactionDetail[5]);
            transactions.add(transactionPOJO);
//            System.out.println(Arrays.toString(transactionDetail));
        }
        return transactions;
    }

    public static void generateProcessingFeeFile(ArrayList<TransactionPOJO> transactions, String out_path) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(out_path, true);
        transactions.forEach(transaction -> {
            try {
                fos.write((transaction.getUid()+"|"+transaction.getClientID()+"|"+transaction.getSecurityID()+"|"+transaction.getDateString()+"|"+transaction.getType()+"|"+transaction.getPriority()+"|"+transaction.getProcessingFee()+"\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Processing Fee Details Are added to the file - "+out_path);
    }
}
