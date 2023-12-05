package org.example;

import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor {
    public static FinanceReport getPaymentsByFirstName(FinanceReport report, char symbol){

        ArrayList<Payment> filteredPayments = new ArrayList<>();

        // Находим платежи людей на заданную букву
        for (int i = 0; i < report.getLengthPayment(); i++){
            Payment payment = report.getIndexArrPayment(i);
            if (Payment.getFullName().charAt(0) == symbol){
                filteredPayments.add(payment); // найденные платежи помещаем в список
            }
        }
        Payment[] newPayments = new Payment[filteredPayments.size()];
        newPayments = filteredPayments.toArray(newPayments);

        return new FinanceReport(report.getCreatorName(), report.getDayData(), report.getMonthData(), report.getYearData(), newPayments);
    }

    public static FinanceReport getPaymentsBelowValue(FinanceReport report, int maxValue){

        List<Payment> filteredPayments = new ArrayList<>();
        for (int i = 0; i < report.getLengthPayment(); i++){
            Payment payment = report.getIndexArrPayment(i);
            if (Payment.getSumPayment() < maxValue){
                filteredPayments.add(payment);
            }
        }
        Payment[] newPayments = new Payment[filteredPayments.size()];
        newPayments = filteredPayments.toArray(newPayments);

        return new FinanceReport(report.getCreatorName(), report.getDayData(), report.getMonthData(), report.getYearData(), newPayments);
    }
}
