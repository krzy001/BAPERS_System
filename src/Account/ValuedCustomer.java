package Account;

import java.time.LocalDate;

public class ValuedCustomer extends CustomerAccount {

    String discountRate;
    String discountType;

    public ValuedCustomer(
            String name, LocalDate dateOfBirth, String customerType, String email,
            String contactName, int accountNo, String address, int phone,
            String discountRate, String discountType ){

        super(name, dateOfBirth, customerType, email, contactName, accountNo, address, phone);
        this.discountRate = discountRate;
        this.discountType = discountType;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
}
