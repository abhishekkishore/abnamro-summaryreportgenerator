package com.abnamro.futuretransactions.report;

import org.apache.log4j.Logger;

import com.abnamro.futuretransactions.report.manager.ConsoleInputOutputManager;
import com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager;

/**
 * 
 *
 */
public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        log.info("Starting execution");
        log.debug("Entered com.abnamro.futuretransactions.report.App.main(String[])");
        new SummaryReportGenerator().generate(new ConsoleInputOutputManager(),
                new TransactionAmountGroupingTransformationManager());
    }

}
