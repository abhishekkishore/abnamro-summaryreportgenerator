package com.abnamro.futuretransactions.report;

import java.util.List;

import org.apache.log4j.Logger;

import com.abnamro.futuretransactions.report.exception.SummaryReportException;
import com.abnamro.futuretransactions.report.manager.ConsoleInputOutputManager;
import com.abnamro.futuretransactions.report.manager.InputOutputManager;
import com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager;
import com.abnamro.futuretransactions.report.manager.TransformationManager;
import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.TransactionAmountGroupingRecord;

/**
 * 
 * Implementation of ReportGenerator that uses {@link ConsoleInputOutputManager}
 * and {@link TransactionAmountGroupingTransformationManager}. It has the following steps:
 * 1. Initialize the {@link InputOutputManager} and {@link TransformationManager} objects. 
 * 2. Read input data into a list using {@link InputOutputManager} object. 
 * 3. Transform input list to output list using {@link TransformationManager} object. 
 * 4. Write output list to destination.
 */
public class SummaryReportGenerator
        implements ReportGenerator<ConsoleInputOutputManager, TransactionAmountGroupingTransformationManager> {

    private static final Logger log = Logger.getLogger(SummaryReportGenerator.class.getName());

    @Override
    public void generate(ConsoleInputOutputManager ioManager,
            TransactionAmountGroupingTransformationManager transformationManager) {
        log.debug(
                "Entered com.abnamro.futuretransactions.report.SummaryReportGenerator.generate(ConsoleInputOutputManager, TransactionAmountGroupingTransformationManager)");
        try {
            ioManager.initialize();
            transformationManager.initialize();

            List<FutureTransactionRecord> input = ioManager.read();
            List<TransactionAmountGroupingRecord> outputRecords = transformationManager.transform(input);

            ioManager.write(outputRecords);
        } catch (SummaryReportException e) {
            System.err.println(e.getMessage());
            log.error(e.getMessage());
        }
    }

}
