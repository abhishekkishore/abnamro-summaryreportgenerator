package com.abnamro.futuretransactions.report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.abnamro.futuretransactions.report.exception.SummaryReportException;
import com.abnamro.futuretransactions.report.manager.ConsoleInputOutputManager;
import com.abnamro.futuretransactions.report.manager.TransactionAmountGroupingTransformationManager;

@RunWith(MockitoJUnitRunner.class)
public class SummaryReportGeneratorTest {

    @Test
    public void testGenerate() throws SummaryReportException {
        ConsoleInputOutputManager consoleInputOutputManager = Mockito.mock(ConsoleInputOutputManager.class);
        TransactionAmountGroupingTransformationManager transformationManager = Mockito
                .mock(TransactionAmountGroupingTransformationManager.class);

        new SummaryReportGenerator().generate(consoleInputOutputManager, transformationManager);

        InOrder orderVerifier = Mockito.inOrder(consoleInputOutputManager, transformationManager);
        orderVerifier.verify(consoleInputOutputManager).initialize();
        orderVerifier.verify(transformationManager).initialize();
        orderVerifier.verify(consoleInputOutputManager).read();
        orderVerifier.verify(transformationManager).transform(ArgumentMatchers.anyList());
        orderVerifier.verify(consoleInputOutputManager).write(ArgumentMatchers.anyList());
        orderVerifier.verifyNoMoreInteractions();
    }
}
