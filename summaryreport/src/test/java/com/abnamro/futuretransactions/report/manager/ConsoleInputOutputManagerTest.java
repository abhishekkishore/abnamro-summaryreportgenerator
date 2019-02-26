package com.abnamro.futuretransactions.report.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.abnamro.futuretransactions.report.model.FutureTransactionRecord;
import com.abnamro.futuretransactions.report.model.TransactionAmountGroupingRecord;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StreamFactory.class, ConsoleInputOutputManager.class, FileInputStream.class, File.class })
public class ConsoleInputOutputManagerTest {

    @Test
    public void testRead() throws Exception {
        StreamFactory factory = PowerMockito.mock(StreamFactory.class);
        BeanReader reader = PowerMockito.mock(BeanReader.class);
        PowerMockito.mockStatic(StreamFactory.class);
        PowerMockito.when(StreamFactory.newInstance()).thenReturn(factory);
//        InputStreamReader inputStreamReader = PowerMockito.mock(InputStreamReader.class);
        FileInputStream fileInputStream = PowerMockito.mock(FileInputStream.class);
//        PowerMockito.whenNew(InputStreamReader.class).withArguments(ArgumentMatchers.any(FileInputStream.class))
//                .thenReturn(inputStreamReader);
        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(fileInputStream);
//        PowerMockito.doReturn(reader).when(factory).createReader(ArgumentMatchers.anyString(),
//                ArgumentMatchers.any(Reader.class));
        PowerMockito.when(factory.createReader(ArgumentMatchers.anyString(), ArgumentMatchers.any(Reader.class)))
                .thenReturn(reader);

        Date date = new Date();
        FutureTransactionRecord record1 = createFutureTransactionRecord(date);
        FutureTransactionRecord record2 = createFutureTransactionRecord(date);

        PowerMockito.when(reader.read()).thenReturn(record1).thenReturn(record2).thenReturn(null);
        ConsoleInputOutputManager manager = new ConsoleInputOutputManager();
        List<FutureTransactionRecord> records = manager.read();
        Assert.assertEquals(record1, records.get(0));
        Assert.assertEquals(record2, records.get(1));
    }

    @Test
    public void testWrite() throws Exception {
        StreamFactory factory = PowerMockito.mock(StreamFactory.class);
        BeanWriter writer = PowerMockito.mock(BeanWriter.class);
        PowerMockito.mockStatic(StreamFactory.class);
        PowerMockito.when(StreamFactory.newInstance()).thenReturn(factory);
        File file = PowerMockito.mock(File.class);
        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(file);
        PowerMockito.when(factory.createWriter(ArgumentMatchers.anyString(), ArgumentMatchers.any(File.class)))
                .thenReturn(writer);

        List<TransactionAmountGroupingRecord> output = new ArrayList<>();
        output.add(new TransactionAmountGroupingRecord());

        ConsoleInputOutputManager manager = new ConsoleInputOutputManager();
        Whitebox.setInternalState(manager, "outputFilePath", "dummyPath");
        manager.write(output);

        Mockito.verify(writer, Mockito.times(2)).write(ArgumentMatchers.any(TransactionAmountGroupingRecord.class));
    }

    @Test
    public void testInitialize() throws Exception {
        Scanner scanner = PowerMockito.mock(Scanner.class);
        PowerMockito.whenNew(Scanner.class).withAnyArguments().thenReturn(scanner);
        PowerMockito.when(scanner.nextLine()).thenReturn("inputPath").thenReturn("outputPath");

        ConsoleInputOutputManager manager = new ConsoleInputOutputManager();
        manager.initialize();
        Assert.assertEquals("inputPath", Whitebox.getInternalState(manager, "inputFilePath"));
        Assert.assertEquals("outputPath", Whitebox.getInternalState(manager, "outputFilePath"));
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
