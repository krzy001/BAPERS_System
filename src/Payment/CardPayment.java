package Payment;

import java.time.LocalDate;

public class CardPayment extends Payment {
    String cardNumber;
    LocalDate expiryDate;
    String name;
    String lastFourDigits;

    public CardPayment(int transactionID, float amount, String paymentType, LocalDate date) {
        super(transactionID, amount, paymentType, date);
    }

    public void makePayment(){

    }
    //KK//
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits() {
        this.lastFourDigits = getCardNumber().substring(getCardNumber().length() - 4);
    }
}
