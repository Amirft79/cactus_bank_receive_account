package ir.cactus.util;

public class OutPutFileModel {
    private int Customer_Id;
    private String Customer_Name;
    private String Customer_SurName;
    private String National_Id;
    private String Account_Number;
    private String Account_Open_Date;
    private int Account_Balance;

    public OutPutFileModel(int customer_Id, String customer_Name, String customer_SurName, String national_Id, String account_Number, String account_Open_Date, int account_Balance) {
        Customer_Id = customer_Id;
        Customer_Name = customer_Name;
        Customer_SurName = customer_SurName;
        National_Id = national_Id;
        Account_Number = account_Number;
        Account_Open_Date = account_Open_Date;
        Account_Balance = account_Balance;
    }

    public void setCustomer_Id(int customer_Id) {
        Customer_Id = customer_Id;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public void setCustomer_SurName(String customer_SurName) {
        Customer_SurName = customer_SurName;
    }

    public void setNational_Id(String national_Id) {
        National_Id = national_Id;
    }

    public void setAccount_Number(String account_Number) {
        Account_Number = account_Number;
    }

    public void setAccount_Open_Date(String account_Open_Date) {
        Account_Open_Date = account_Open_Date;
    }

    public void setAccount_Balance(int account_Balance) {
        Account_Balance = account_Balance;
    }

    public int getCustomer_Id() {
        return Customer_Id;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public String getCustomer_SurName() {
        return Customer_SurName;
    }

    public String getNational_Id() {
        return National_Id;
    }

    public String getAccount_Number() {
        return Account_Number;
    }

    public String getAccount_Open_Date() {
        return Account_Open_Date;
    }

    public int getAccount_Balance() {
        return Account_Balance;
    }

    @Override
    public String toString() {
        return this.Customer_Id+this.Account_Number;
    }
}
