package com.abnamro.futuretransactions.report.exception;

/**
 * Thrown to indicate an error occurred while transformting input records to
 * output records.
 *
 */
public class TransformationException extends SummaryReportException {

    public TransformationException(String message) {
        super(message);
    }

}
