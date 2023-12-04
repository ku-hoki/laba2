package org.example;

import java.util.Objects;

public class Payment {
    private static String fullName;
    private static int day;
    private static int month;
    private static int year;
    private static int sumPayment;

    public Payment(String fullName, int day, int month, int year, int sumPayment) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sumPayment = sumPayment;
    }

    //конструктор для копирования
    public Payment(Payment originalPayment){
        this.fullName = originalPayment.fullName;
        this.day = originalPayment.day;
        this.month = originalPayment.month;
        this.year = originalPayment.year;
        this.sumPayment = originalPayment.sumPayment;
    }

    // Геттеры и сеттеры

    public static String getFullName() {
        return fullName;
    }



    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public static int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getSumPayment() {
        return sumPayment;
    }

    public void setSumPayment(int sumPayment) {
        this.sumPayment = sumPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return day == payment.day &&
                month == payment.month &&
                year == payment.year &&
                sumPayment == payment.sumPayment &&
                Objects.equals(fullName, payment.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, sumPayment);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "fullName='" + fullName + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", sumPayment=" + sumPayment +
                '}';
    }
}