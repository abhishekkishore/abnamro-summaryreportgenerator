package com.abnamro.futuretransactions.report.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.abnamro.futuretransactions.report.TransactionAmountFunction;
import com.abnamro.futuretransactions.report.TransactionGroupingClassifierFunction;
import com.abnamro.futuretransactions.report.exception.TransformationException;
import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.SummaryRecord;
import com.abnamro.futuretransactions.report.model.TransactionAmountGroupingRecord;

/**
 * A {@link TransformationManager} implementation that groups records by client
 * and product information, and transaction date, and calculates total
 * transaction amount for each group.
 *
 */
public class TransactionAmountGroupingTransformationManager
        implements TransformationManager<FutureTransactionRecord, TransactionAmountGroupingRecord> {

    private static final Logger log = Logger.getLogger(TransactionAmountGroupingTransformationManager.class.getName());

    private Date summaryDate;

    @Override
    public List<TransactionAmountGroupingRecord> transform(List<FutureTransactionRecord> input) {

        log.info("Beginning transformation of records");
        log.debug(
                "Entering com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager.transform(List<FutureTransactionRecord>)");
        List<TransactionAmountGroupingRecord> outputRecords = new ArrayList<>();
        /*
         * 1. Filter transactions to fetch only those done on the requested date. 
         * 2. Group transactions by client info and product info. 
         * 3. Calculate transaction amount per group.
         * 4. Add result to output list.
         */
        input.stream().filter(filterCriteria())
                .collect(Collectors.groupingBy(new TransactionGroupingClassifierFunction(),
                        Collectors.summingLong(new TransactionAmountFunction())))
                .entrySet().stream().forEach(entry -> {
                    outputRecords.add(createOutputRecord(entry));
                });
        return outputRecords;
    }

    private TransactionAmountGroupingRecord createOutputRecord(Entry<SummaryRecord, Long> transactionRecordEntry) {
        TransactionAmountGroupingRecord outputRecord = new TransactionAmountGroupingRecord();
        SummaryRecord summaryRecord = transactionRecordEntry.getKey();
        outputRecord.setClientInformation(summaryRecord.getClientInfo().toString());
        outputRecord.setProductInformation(summaryRecord.getProductInfo().toString());
        outputRecord.setTotalTransactionAmount(transactionRecordEntry.getValue().toString());
        return outputRecord;
    }

    @Override
    public Predicate<FutureTransactionRecord> filterCriteria() {
        log.debug(
                "Entering com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager.filterCriteria()");
        return (record) -> {
            log.info("Checking transformation filter for record: " + record.toString());
            return summaryDate.equals(record.getTransactionDate());
        };
    }

    @Override
    public void initialize() throws TransformationException {
        log.info("Initializing transformation manager");
        log.debug(
                "Entering com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager.initialize()");
        try {
            getReportDate();
        } catch (ParseException e) {
            throw new TransformationException("Summary generation date is in incorrect format.");
        }
    }

    private void getReportDate() throws ParseException {
        log.info("Read date for report generation from the console.");
        log.debug(
                "Entering com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager.getReportDate()");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction date for summary report generation [yyyyMMdd. Hit Enter for today]: ");
        String summaryDateInput = scanner.nextLine();
        log.info("Transaction date for filtering provided by user: " + summaryDateInput);
        summaryDate = removeTime(new Date());
        if (!"".equals(summaryDateInput)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            formatter.setLenient(false);
            summaryDate = formatter.parse(summaryDateInput);
        } else {
            log.info("No filtering date provided by user. Picking today as filter.");
        }
    }

    private Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
