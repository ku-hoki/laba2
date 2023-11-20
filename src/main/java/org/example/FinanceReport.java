package org.example;


import java.util.Arrays;
import java.util.IllegalFormatWidthException;

public class FinanceReport {
    private Payment [] payments;
    private String creatorName;
    private String data;

    public FinanceReport(int numberPayment, String creatorName, String data){
        this.payments = new Payment[numberPayment];
        this.creatorName = creatorName;
        this.data = data;
    }

    //конструктор копирования
    public FinanceReport(FinanceReport original){
        this.creatorName = original.creatorName;
        this.data = original.data;

        //копирование массива
        this.payments = Arrays.copyOf(original.payments, original.payments.length);
        for (int i = 0 ; i < original.payments.length; i++){
            this.payments[i] = new Payment(original.payments[i]);
        }
    }

    public int getNumberPayment(){
        return payments.length;
    }

    public Payment getPayment(int index){
        if (index >= 0 && index < payments.length){
            return payments[index];
        }
        throw new IllegalArgumentException("Индекс не имеет доступа к элементам массива");
    }

    public void setPayment(int index, Payment payment){
        if (index >= 0 && index < payments.length){
            payments[index] = payment;
        }
        throw new IllegalArgumentException("Индекс не имеет доступа к элементам массива");
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(String.format("Автор: %s, дата: %s, Платежи: [\n", creatorName, data));
        for (int i = 0; i < payments.length; i++){
            string.append(String.format("Плательщик: %s, дата: %d.%d.%d, сумма: %d руб. %d коп. \n",
            Payment.getFullName(), Payment.getDay(), Payment.getMonth(), Payment.getYear(), Payment.getSumPayment()/100, Payment.getSumPayment()%100));
        }
        string.append("]");
        return string.toString();
    }
}
