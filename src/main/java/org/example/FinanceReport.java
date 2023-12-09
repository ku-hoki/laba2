package org.example;


public class FinanceReport {
    private Payment [] arrPayments;
    private String creatorName;
    private int dayData;
    private int monthData;
    private int yearData;

    public FinanceReport(String creatorName, int dayDateReport, int monthDateReport, int yearDateReport, Payment[] payments){
        this.arrPayments = payments;
        this.creatorName = creatorName;
        this.dayData = dayDateReport;
        this.monthData = monthDateReport;
        this.yearData = yearDateReport;
    }

    //конструктор копирования
    public FinanceReport(FinanceReport report){
        creatorName = report.getCreatorName();
        dayData = report.getDayData();
        monthData = report.getMonthData();
        yearData = report.getYearData();
        arrPayments = report.arrPayments.clone();

    }

    public int getLengthPayment(){ return arrPayments.length; }

    public Payment[] getPayment(){
        return arrPayments;
    }

    public void setPayment(Payment[] arrPayments){
        this.arrPayments = arrPayments;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(String.format("Автор: %s, дата: %d.%d.%d, Платежи: [\n", creatorName, dayData, monthData,yearData));
        for (int i = 0; i < arrPayments.length; i++){
            Payment payment = arrPayments[i];
            string.append(payment.toString());
        }
        string.append("]");
        return string.toString();
    }

    public Payment getIndexArrPayment(int index){
        return arrPayments[index];
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getDayData() {
        return dayData;
    }

    public void setDayData(int dayData) {
        this.dayData = dayData;
    }

    public int getMonthData() {
        return monthData;
    }

    public void setMonthData(int monthData) {
        this.monthData = monthData;
    }

    public int getYearData() {
        return yearData;
    }

    public void setYearData(int yearData) {
        this.yearData = yearData;
    }

    public void setArrPayment(Payment payment, int numberPayment) {
        arrPayments[numberPayment] = payment;
    }
}
