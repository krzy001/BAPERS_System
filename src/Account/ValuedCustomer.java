package Account;

public class ValuedCustomer extends CustomerAccount {

    String discountPlan;
    Boolean valuedCustomer;

    public ValuedCustomer(
            String name, String email,
            String contactName, String accountNo, int address, int phone,
            String discountPlan, boolean valuedCustomer ){

        super(name, discountPlan, email, phone, accountNo, address, contactName,valuedCustomer);
        this.discountPlan = discountPlan;
        this.valuedCustomer = valuedCustomer;
    }

    public String getDiscountPlan() {
        return discountPlan;
    }

    public void setDiscountPlan(String discountPlan) {
        this.discountPlan = discountPlan;
    }

    public Boolean getValuedCustomer() {
        return valuedCustomer;
    }

    public void setValuedCustomer(boolean valuedCustomer) {
        this.valuedCustomer = valuedCustomer;
    }
}
