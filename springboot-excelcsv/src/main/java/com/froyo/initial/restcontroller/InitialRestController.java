package com.froyo.initial.restcontroller;

import com.froyo.initial.MapObjectRowResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class InitialRestController {

    @GetMapping("/basicCsvWriter")
    public String basicCsvWriter(){

        try {

            //We have to create CSVPrinter class object
            Writer writer = Files.newBufferedWriter(Paths.get("C:\\test\\student.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Student Name", "Fees"));

            //Writing records in the generated CSV file
            csvPrinter.printRecord("Akshay Sharma", 1000);
            csvPrinter.printRecord("Rahul Gupta", 2000);
            csvPrinter.printRecord("Jay Karn", 3000);

            //writing record in the form of list
            csvPrinter.printRecord(Arrays.asList("Dev Bhatia", 4000));

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";

    }

    @GetMapping("/basicCsvReader")
    public String basicCsvReader() throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\test\\student.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Student Name", "Fees").withIgnoreHeaderCase().withTrim());

        for (CSVRecord csvRecord: csvParser) {

            // Accessing Values by Column Index
            String name = csvRecord.get(0);

            //Accessing the values by column header name
            String fees = csvRecord.get("fees");

            //Printing the record
            System.out.println("Record Number - " + csvRecord.getRecordNumber());
            System.out.println("Name : " + name);
            System.out.println("Fees : " + fees);
            System.out.println("\n\n");
        }

        return "success";

    }

    @GetMapping("/basicCsvReaderDataExample")
    public MapObjectRowResponse basicCsvReaderDataExample() throws Exception {

        MapObjectRowResponse response = new MapObjectRowResponse();

        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\test\\vehicle_order_status_upfit.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());

        List<String> headerList = new ArrayList<>();

        for (Map.Entry<String, Integer> me : csvParser.getHeaderMap().entrySet()) {
            headerList.add(me.getKey());
        }

        List<Map<String,String>> objMapRowList = new ArrayList<>();
        for (CSVRecord csvRecord: csvParser) {

            Map<String,String> objMapRow = new HashMap<>();
            for(String header : headerList){
                objMapRow.put(header,csvRecord.get(header));
            }

            objMapRowList.add(objMapRow);

        }

        response.setObjMapRowList(objMapRowList);
        response.setHeaderList(headerList);

        return response;

    }


}
