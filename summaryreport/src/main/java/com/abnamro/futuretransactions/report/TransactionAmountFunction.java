package com.abnamro.futuretransactions.report;

import java.util.function.ToLongFunction;

import org.apache.log4j.Logger;

import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;

/**
 * Function to calculate the total transaction amount of a
 * {@link FutureTransactionRecord}
 *
 */
public class TransactionAmountFunction implements ToLongFunction<FutureTransactionRecord> {
    private static final Logger log = Logger.getLogger(TransactionAmountFunction.class.getName());

    @Override
    public long applyAsLong(FutureTransactionRecord value) {
        log.info("Calculating transaction amount for record: " + value.toString());
        log.debug(
                "Entering com.abnamro.futuretransactions.report.TransactionAmountFunction.applyAsLong(FutureTransactionRecord)");
        return value.getQuantityLong() - value.getQuantityShort();
    }

}
