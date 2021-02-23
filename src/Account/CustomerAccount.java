package Account;

import java.time.LocalDate;

public class CustomerAccount {
    String name;
    LocalDate dateOfBirth;
    String customerType;
    String email;
    String contactName;
    int accountNo;
    String address;
    int phone;

    public CustomerAccount(
            String name, LocalDate dateOfBirth, String customerType, String email,
            String contactName, int accountNo, String address, int phone){

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this. customerType = customerType;
        this.email = email;
        this.contactName = contactName;
        this.accountNo = accountNo;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    /*
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
