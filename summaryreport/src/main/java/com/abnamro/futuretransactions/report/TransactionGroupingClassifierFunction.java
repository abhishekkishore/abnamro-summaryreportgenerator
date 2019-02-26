package com.abnamro.futuretransactions.report;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

import org.apache.log4j.Logger;

import com.abnamro.futuretransactions.report.model.ClientInfo;
import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.ProductInfo;
import com.abnamro.futuretransactions.report.model.SummaryRecord;

/**
 * Function that helps with grouping objects of {@link FutureTransactionRecord}
 * by extracting {@link SummaryRecord} objects from them.
 *
 */
public class TransactionGroupingClassifierFunction implements Function<FutureTransactionRecord, SummaryRecord> {

    private static final Logger log = Logger.getLogger(TransactionGroupingClassifierFunction.class.getName());

    public SummaryRecord apply(FutureTransactionRecord transaction) {
        log.info("Identifying grouping record for transaction record: " + transaction.toString());
        log.debug(
                "Entering com.abnamro.futuretransactions.report.TransactionGroupingClassifierFunction.apply(FutureTransactionRecord)");
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setAccountNumber(transaction.getAccountNumber());
        clientInfo.setClientNumber(transaction.getClientNumber());
        clientInfo.setClientType(transaction.getClientType());
        clientInfo.setSubAccountNumber(transaction.getSubAccountNumber());

        ProductInfo productInfo = new ProductInfo();
        productInfo.setExchangeCode(transaction.getExchangeCode());
        productInfo.setExpirationDate(removeTime(transaction.getExpirationDate()));
        productInfo.setProductGroupCode(transaction.getProductGroupCode());
        productInfo.setSymbol(transaction.getSymbol());

        SummaryRecord summaryRecord = new SummaryRecord();
        summaryRecord.setClientInfo(clientInfo);
        summaryRecord.setProductInfo(productInfo);
        summaryRecord.setTransactionDate(transaction.getTransactionDate());

        return summaryRecord;

    }

    private Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}