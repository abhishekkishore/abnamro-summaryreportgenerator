package com.abnamro.futuretransactions.report.exception;

/**
 * Base class for all exceptions thrown by report generators.
 *
 */
public class SummaryReportException extends Exception {

    public SummaryReportException(String message) {
        super(message);
    }

}
