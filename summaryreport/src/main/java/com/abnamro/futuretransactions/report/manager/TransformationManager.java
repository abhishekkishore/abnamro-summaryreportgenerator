package com.abnamro.futuretransactions.report.manager;

import java.util.List;
import java.util.function.Predicate;

import com.abnamro.futuretransactions.report.exception.SummaryReportException;
import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.InputRecord;
import com.abnamro.futuretransactions.report.model.OutputRecord;

/**
 * Interface that handles the step of the report generation process where the
 * input records are transformed to output records based on criteria provided in
 * required.
 *
 * @param <T>
 * @param <U>
 */
public interface TransformationManager<T extends InputRecord, U extends OutputRecord> {
    public List<U> transform(List<T> input) throws SummaryReportException;

    public Predicate<FutureTransactionRecord> filterCriteria();

    public void initialize() throws SummaryReportException;
}
