package com.abnamro.futuretransactions.report;

import com.abnamro.futuretransactions.report.manager.InputOutputManager;
import com.abnamro.futuretransactions.report.manager.TransformationManager;
import com.abnamro.futuretransactions.report.model.InputRecord;
import com.abnamro.futuretransactions.report.model.OutputRecord;

/**
 * 
 * This interface provides API that can be used for generation of reports that
 * involve transforming a kind of record to another one.
 *
 * @param <T>
 * @param <U>
 */
public interface ReportGenerator<T extends InputOutputManager<? extends InputRecord, ? extends OutputRecord>, U extends TransformationManager<? extends InputRecord, ? extends OutputRecord>> {
    public void generate(T ioManager, U transformationManager);
}
