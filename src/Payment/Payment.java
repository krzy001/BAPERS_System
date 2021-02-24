package Payment;

import java.time.LocalDate;

public class Payment {
    int transactionID;
    float amount;
    String paymentType;
    LocalDate date;

    public Payment(int transactionID, float amount, String paymentType, LocalDate date) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.paymentType = paymentType;
        this.date = date;
    }

    public boolean processPayment(){
        return false;
    }

    public void recordPayment(int transactionID){

    }

    public void alertLatePayments(){

    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
