package com.abnamro.futuretransactions.report.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.beanio.BeanIOException;
import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.abnamro.futuretransactions.report.App;
import com.abnamro.futuretransactions.report.exception.InputStreamCreationException;
import com.abnamro.futuretransactions.report.exception.OutputStreamCreationException;
import com.abnamro.futuretransactions.report.exception.SummaryReportException;
import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.TransactionAmountGroupingRecord;

/**
 * Implementation of {@link InputOutputManager} that reads and writes input and
 * output data to files specified on the input console.
 * 
 *
 */
public class ConsoleInputOutputManager
        implements InputOutputManager<FutureTransactionRecord, TransactionAmountGroupingRecord> {

    private static final Logger log = Logger.getLogger(ConsoleInputOutputManager.class.getName());

    private String inputFilePath;

    private String outputFilePath;

    @Override
    public List<FutureTransactionRecord> read() throws SummaryReportException {
        log.info("Reading input for report generation");
        log.debug("Entering com.abnamro.futuretransactions.report.manager.ConsoleInputOutputManager.read()");
        try {
            StreamFactory inputFactory = StreamFactory.newInstance();
            inputFactory
                    .load(ConsoleInputOutputManager.class.getClassLoader().getResourceAsStream("input_mapping.xml"));
            BeanReader in = null;
            if ("".equals(inputFilePath)) {
                in = inputFactory.createReader("clientFile",
                        new InputStreamReader(App.class.getClassLoader().getResourceAsStream("Input.txt")));
            } else {
                in = inputFactory.createReader("clientFile", new InputStreamReader(new FileInputStream(inputFilePath)));
            }
            FutureTransactionRecord transaction;
            List<FutureTransactionRecord> transactions = new ArrayList<>();
            while ((transaction = (FutureTransactionRecord) in.read()) != null) {
                transactions.add(transaction);
            }
            in.close();
            return transactions;
        } catch (BeanIOException | IllegalArgumentException | IOException e) {
            throw new InputStreamCreationException("Error reading input file.");
        }
    }

    @Override
    public void write(List<TransactionAmountGroupingRecord> outputRecords) throws SummaryReportException {
        log.info("Writing output for report generation");
        log.debug(
                "Entering com.abnamro.futuretransactions.report.manager.ConsoleInputOutputManager.write(List<TransactionAmountGroupingRecord>)");
        try {
            StreamFactory outputFactory = StreamFactory.newInstance();
            outputFactory.load(App.class.getClassLoader().getResourceAsStream("output_mapping.xml"));
            File outputFile = new File(outputFilePath);
            BeanWriter writer = outputFactory.createWriter("output", outputFile);
            writer.write(createOutputHeader());
            outputRecords.stream().forEach(outputRecord -> {
                writer.write(outputRecord);
            });
            writer.flush();
            writer.close();
        } catch (BeanIOException | IllegalArgumentException | IOException e) {
            throw new OutputStreamCreationException("Failed to write output.");
        }
    }

    private TransactionAmountGroupingRecord createOutputHeader() {
        TransactionAmountGroupingRecord header = new TransactionAmountGroupingRecord();
        header.setClientInformation("Client_Information");
        header.setProductInformation("Product_Information");
        header.setTotalTransactionAmount("Total_Transaction_Amount");
        return header;
    }

    @Override
    public void initialize() throws SummaryReportException {
        log.info("Reading input and output file paths from the console");
        log.debug("Entering com.abnamro.futuretransactions.report.manager.ConsoleInputOutputManager.initialize()");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to input file [Hit Enter for default file]: ");
        inputFilePath = scanner.nextLine();
        log.debug("Input file path provided by user: " + inputFilePath);

        System.out.print("Enter path to output file: ");
        outputFilePath = scanner.nextLine();
        log.debug("Output file path provided by user: " + outputFilePath);
        if ("".equals(outputFilePath)) {
            throw new OutputStreamCreationException("Output file path not provided.");
        }
    }

}
