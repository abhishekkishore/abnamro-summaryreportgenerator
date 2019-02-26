package com.abnamro.futuretransactions.report.manager;

import java.util.List;

import com.abnamro.futuretransactions.report.ReportGenerator;
import com.abnamro.futuretransactions.report.exception.SummaryReportException;
import com.abnamro.futuretransactions.report.model.InputRecord;
import com.abnamro.futuretransactions.report.model.OutputRecord;

/**
 * Interface that manages the reading and writing of input and output data for
 * report generation. An implementation will be specified by a
 * {@link ReportGenerator} class.
 *
 * @param <T>
 * @param <U>
 */
public interface InputOutputManager<T extends InputRecord, U extends OutputRecord> {

    public void initialize() throws SummaryReportException;

    public List<T> read() throws SummaryReportException;

    public void write(List<U> outputRecords) throws SummaryReportException;
}
