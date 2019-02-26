package com.abnamro.futuretransactions.report.exception;

/**
 * Thrown to indicate reading an error occurred while reading input data for
 * report generation.
 *
 */
public class InputStreamCreationException extends SummaryReportException {

    public InputStreamCreationException(String message) {
        super(message);
    }

}
