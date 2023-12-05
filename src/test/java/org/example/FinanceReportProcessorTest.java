package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    private FinanceReport testReport;
    @BeforeEach
    void setTestReport(){
        Payment[] payments = {
                new Payment("Sokolov", 8, 11, 2023, 30000),
                new Payment("Ivanov", 3, 8, 2023, 5000),
                new Payment("Nikonov", 1, 3, 2023, 11001),
                new Payment("Salamonow", 10, 10, 2023, 280)

        };
        testReport = new FinanceReport("Test", 12, 12, 2023, payments);

    }
    @Test
    public void testGetPaymentsByFirstName() {
        FinanceReport searchTest1 = FinanceReportProcessor.getPaymentsByFirstName(testReport, 'N');
        assertEquals(1, searchTest1.getPayment().length);

    }
}