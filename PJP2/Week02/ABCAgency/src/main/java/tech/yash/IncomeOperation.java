package tech.yash;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class IncomeOperation {
    private final String inputFileName;
    private String outputFilename;
    private List<IncomeObject> incomeObjects;
    private Map<String, Map<String, List<Double>>> avg;

    public IncomeOperation(String inputFileName, String outputFilename) throws IOException {
        this.inputFileName = inputFileName;
        this.outputFilename = outputFilename;
        this.incomeObjects = new ArrayList<>();
        System.out.println("Processing...");
        loadIncomeObjects();
        calculateAverage();
        generateOutputFile();
        System.out.println("Output File Saved !");
    }

    private void loadIncomeObjects(){
        File file = new File(this.inputFileName);
        try (
                BufferedReader br = new BufferedReader(new FileReader(file));
                CSVReader csvReader = new CSVReader(br)) {
                String[] line = csvReader.readNext(); //col titles ignored
                while ((line = csvReader.readNext()) != null) {
                    if(line[0].strip().equals("")){
                        continue;
                    }
                    IncomeObject incomeObject = new IncomeObject(line[0], line[1], line[2], line[3], line[4]);
                    this.incomeObjects.add(incomeObject);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculateAverage(){
        this.avg = new HashMap<>();
        this.incomeObjects.forEach(entry -> {
//            System.out.println(entry.getAmount());
            String country = entry.getCountry();
            if (country.strip().equals("")){
                country = entry.getCity();
            }
            String gender = entry.getGender();
            if(avg.containsKey(country)){
                Double inc = avg.get(country).get(gender).get(0);
                Double count = avg.get(country).get(gender).get(1);
                Double result = ((inc*count)+Double.parseDouble(entry.getAmount()))/(count+1);
//                System.out.println(result);
                avg.get(country).get(gender).set(0,result);
                avg.get(country).get(gender).set(1, count+1);
            } else {
                Map<String, List<Double>> temp = new HashMap<>();
                List<Double> t = new ArrayList<>();
                t.add(Double.parseDouble(entry.getAmount()));
                t.add((double) 1);
                temp.put(gender, t);
                String gender2;
                if(gender.equals("f")){
                    gender2="m";
                } else {
                    gender2 = "f";
                }
                List<Double> t2 = new ArrayList<>();
                t2.add((double) 0);
                t2.add((double) 0);
                temp.put(gender2, t2);
                avg.put(country, temp);
            }
        });
    }


    private void generateOutputFile() throws IOException {
        File file = new File(this.outputFilename);
        file.createNewFile();
        CSVWriter writer = new CSVWriter(
                new FileWriter(file),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END
        );
        String[] array = new String[3];
        array[0] = "City/Country";
        array[1] = "Gender";
        array[2] = "Average Income(in USD)";
        writer.writeNext(array);
        List<String[]> averages = new ArrayList<>();
        this.avg.keySet().forEach(country -> {
            this.avg.get(country).keySet().forEach(gender ->{
                String[] row = new String[3];
                row[0] = StringUtils.capitalize(country);
                row[1] = gender.toUpperCase();
                DecimalFormat df = new DecimalFormat("#.##");
                row[2] = Double.valueOf(df.format(this.avg.get(country).get(gender).get(0))).toString();
                averages.add(row);
            });
        });

        averages.sort(Comparator.comparing(o -> o[0]));

        averages.forEach(writer::writeNext);
        writer.close();
    }
}
