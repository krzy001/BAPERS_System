package Account;

public class CustomerAccount {
    String name;
    String contactName;
    String email;
    int accountNo;
    String address;
    int phone;
    String discountPlan;
    boolean valuedCustomer;

    public CustomerAccount(
            String name, String contactName, String email, int accountNo, String address, int phone, String discountPlan, boolean valuedCustomer){

        this.name = name;
        this.email = email;
        this.contactName = contactName;
        this.accountNo = accountNo;
        this.address = address;
        this.phone = phone;
        this.discountPlan = discountPlan;
        this.valuedCustomer = valuedCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) { this.contactName = contactName; }

    public void setDiscountPlan(String discountPlan) { this.discountPlan = discountPlan;}

    public String getDiscountPlan() { return discountPlan; }

    public void setValuedCustomer(boolean valuedCustomer) { this.valuedCustomer = valuedCustomer;}

    public Boolean getValuedCustomer() {return valuedCustomer; }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /* Getter and setters for address aren't on the design diagram. mistake?
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
*/

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
