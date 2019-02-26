package com.abnamro.futuretransactions.report.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.abnamro.futuretransactions.report.exception.SummaryReportException;
import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.TransactionAmountGroupingRecord;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ TransactionAmountGroupingTransformationManager.class, Scanner.class })
public class TransactionAmountGroupingTransformationManagerTest {

    @Test
    public void testTransform() throws SummaryReportException {
        Date date = new Date(110, 7, 20);
        FutureTransactionRecord record1 = createFutureTransactionRecord(date);
        FutureTransactionRecord record2 = createFutureTransactionRecord(date);
        List<FutureTransactionRecord> input = new ArrayList<>();
        input.add(record1);
        input.add(record2);
        TransactionAmountGroupingTransformationManager manager = new TransactionAmountGroupingTransformationManager();
        Whitebox.setInternalState(manager, "summaryDate", new Date(110, 7, 20));

        List<TransactionAmountGroupingRecord> output = manager.transform(input);
        Assert.assertEquals(1, output.size());
    }

    @Test
    public void testInitialize() throws Exception {
        Scanner scanner = PowerMockito.mock(Scanner.class);
        PowerMockito.whenNew(Scanner.class).withAnyArguments().thenReturn(scanner);
        PowerMockito.when(scanner.nextLine()).thenReturn("20100820");
        TransactionAmountGroupingTransformationManager manager = new TransactionAmountGroupingTransformationManager();
        manager.initialize();
        Assert.assertEquals(new Date(110, 7, 20), Whitebox.getInternalState(manager, "summaryDate"));
    }

    private FutureTransactionRecord createFutureTransactionRecord(Date date) {
        FutureTransactionRecord futureTransactionRecord = new FutureTransactionRecord();
        futureTransactionRecord.setTransactionDate(date);
        futureTransactionRecord.setClientType("dummyClientType");
        futureTransactionRecord.setClientNumber("dummyClientNumber");
        futureTransactionRecord.setAccountNumber("dummyAccountNumber");
        futureTransactionRecord.setSubAccountNumber("dummySubAccountNumber");

        futureTransactionRecord.setProductGroupCode("dummyProductGroupCode");
        futureTransactionRecord.setExchangeCode("exchangeCode");
        futureTransactionRecord.setSymbol("dummySymbol");
        futureTransactionRecord.setExpirationDate(new Date());

        futureTransactionRecord.setQuantityLong(2L);
        futureTransactionRecord.setQuantityShort(1L);

        return futureTransactionRecord;
    }
}
