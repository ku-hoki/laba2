package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    @Test
    public void testGetPaymentsByFirstName() {
        FinanceReport report = new FinanceReport(5, "John Smith", null);
        report.setPayment(0, new Payment("Alice Johnson", 10, 11, 2021, 5000));
        report.setPayment(1, new Payment("Bob Williams", 15, 12, 2022, 7000));
        report.setPayment(2, new Payment("Charlie Brown", 20, 1, 2023, 3000));
        report.setPayment(3, new Payment("David Smith", 25, 2, 2023, 4000));
        report.setPayment(4, new Payment("Emma Johnson", 1, 3, 2023, 6000));

        // Фильтрация платежей по начальной букве фамилии 'J'
        FinanceReport filteredReport = FinanceReportProcessor.getPaymentsByFirstName(report, 'J');

        // Проверка корректности фильтрации
        assertEquals(2, filteredReport.getNumberPayment()); // Ожидается, что найдено 2 платежа
        assertEquals("Alice Johnson", filteredReport.getPayment(0).getFullName());
        assertEquals("Emma Johnson", filteredReport.getPayment(1).getFullName());
    }
}