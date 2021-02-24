package Payment;

import java.time.LocalDate;

public class CashPayment extends Payment {

    public CashPayment(int transactionID, float amount, String paymentType, LocalDate date) {
        super(transactionID, amount, paymentType, date);
    }

    public boolean paid(){
        return false;
    }

    public void makePayment(){

    }
}
