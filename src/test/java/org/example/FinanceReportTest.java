package org.example;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportTest {
    private FinanceReport financeReport;

    @Before
    public void createFinanceReport() {

        Payment payment1 = new Payment("Иванов Сергей Васильевич", 10, 12, 2007, 2567850);
        Payment payment2 = new Payment("Бондарев Алексей Сергеевич", 13, 10, 2005, 4580024);
        Payment payment3 = new Payment("Барсуков Константин Викторович", 20, 11, 2010, 3789023);
        Payment payment4 = new Payment("Иванова Юлия Витальевна", 14, 10, 2003, 5257043);
        Payment payment5 = new Payment("Попов Олег Владимирович", 18, 10, 2009, 3697041);
        Payment[] payments = new Payment[]{payment1, payment2, payment3, payment4, payment5};
        financeReport = new FinanceReport("Соколов Валерий Дмитриевич", payments, 28, 11, 2010);
    }

    @Test    public void test1_getIPayments() {
        Payment payment = new Payment("Бондарев Алексей Сергеевич", 13, 10, 2005, 4580024);
        assertEquals(payment, financeReport.getPayment(1));
    }
    @Test    public void test2_getIPayments() {
        Payment payment = new Payment("Бондарев Алексей Сергеевич", 13, 10, 2005, 4580024);
        assertNotEquals(payment, financeReport.getPayment(3));
    }
    @Test    public void setFinanceReport() {
        Payment payment = new Payment("Васильева Валерия Генадьевна", 23, 8, 2012, 4892018);
        financeReport.setPayment( 1, payment);
        assertEquals(payment, financeReport.getPayment(1));
    }
    @Test    public void test1_copyFinanceReport() {
        FinanceReport financeReportNew = new FinanceReport(financeReport);
        assertEquals(financeReportNew, financeReport);
    }
    @Test    public void test2_copyFinanceReport() {
        FinanceReport financeReportNew = new FinanceReport(financeReport);
        financeReport.setCreatorName("Мальцев Петр Григорьевич");
        assertNotEquals(financeReportNew, financeReport);    }
    @Test
    public void test1_paymentByLastName() {        assertNotEquals(financeReport, FinanceReportProcessor.getPaymentsByFirstName(financeReport, 'Б'));
    }
    @Test    public void test2_paymentByLastName() {
        Payment payment1 = new Payment("Бондарев Алексей Сергеевич", 13, 10, 2005, 4580024);
        Payment payment2 = new Payment("Барсуков Константин Викторович", 20, 11, 2010, 3789023);
        Payment[] payments = new Payment[]{payment1, payment2};
        FinanceReport financeReportNew = new FinanceReport(financeReport);
        assertEquals(financeReportNew, FinanceReportProcessor.getPaymentsByFirstName(financeReport, 'Б'));
    }
    @Test
    public void test1_paymentsOfAGivenValue() {
        assertNotEquals(financeReport, FinanceReportProcessor.getPaymentsBelowValue(financeReport, 4000000));
    }
    @Test    public void test2_paymentsOfAGivenValue() {
        Payment payment1 = new Payment("Иванов Сергей Васильевич", 10, 12, 2007, 2567850);
        Payment payment2 = new Payment("Барсуков Константин Викторович", 20, 11, 2010, 3789023);
        Payment payment3 = new Payment("Попов Олег Владимирович", 18, 10, 2009, 3697041);
        Payment[] payments = new Payment[]{payment1, payment2, payment3};
        FinanceReport financeReportNew = new FinanceReport(financeReport);

        assertEquals(financeReportNew, FinanceReportProcessor.getPaymentsBelowValue(financeReport, 4000000));    }
}