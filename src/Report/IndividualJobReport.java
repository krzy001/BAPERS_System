package Report;

public class IndividualJobReport extends Report {

    int accountNo;
    String customerName;
    String discountType;
    String discountRate;

    public IndividualJobReport(int reportID) {
        super(reportID);
    }

    public String getIndividualJobReport(){
        return "Hello World";
    }

    public void setIndividualJobReport(String IndividualJobReport){

    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }
}
