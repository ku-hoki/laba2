package org.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {
    public static FinanceReport getPaymentsByFirstName(FinanceReport report, char startChar){
        FinanceReport filteredReport = new FinanceReport(report.getNumberPayment(), report.getCreatorName(), report.getData());
        List<Payment> filteredPayments = new ArrayList<>();

        // Находим платежи людей на заданную букву
        for (int i = 0; i < report.getNumberPayment(); i++){
            Payment payment = report.getPayment(i);
            if (Payment.getFullName().charAt(0) == startChar){
                filteredPayments.add(payment); // найденные платежи помещаем в список
            }
        }

        for (int i = 0; i < filteredPayments.size(); i++){
            filteredReport.setPayment(i, filteredPayments.get(i));
        }

        return filteredReport;
    }

    public static FinanceReport getPaymentsBelowValue(FinanceReport report, int maxValue){
        FinanceReport filteredReport = new FinanceReport(report.getNumberPayment(), report.getCreatorName(), report.getData());
        List<Payment> filteredPayments = new ArrayList<>();

        for (int i = 0; i < report.getNumberPayment(); i++){
            Payment payment = report.getPayment(i);
            if (Payment.getSumPayment() < maxValue){
                filteredPayments.add(payment);
            }
        }

        for (int i = 0; i < filteredPayments.size(); i++){
            filteredReport.setPayment(i, filteredPayments.get(i));
        }

        return filteredReport;
    }
}
