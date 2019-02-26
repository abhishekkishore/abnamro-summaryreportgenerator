package com.abnamro.futuretransactions.report.exception;

/**
 * Thrown to indicate reading an error occurred while writing output data for
 * report generation.
 *
 */
public class OutputStreamCreationException extends SummaryReportException {
    public OutputStreamCreationException(String message) {
        super(message);
    }
}
