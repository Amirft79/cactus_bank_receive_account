package ir.cactus.database;

import ir.cactus.model.Account;
import ir.cactus.model.Customer;
import ir.cactus.util.AccountType;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankAccountDataBase {
    private ArrayList<Account> accounts;
    private ArrayList<Customer> customers;

    private Connection connection=null;
    private PreparedStatement Main_Statement=null;
    private ResultSet Main_Set=null;
    private Logger logger=Logger.getLogger(BankAccountDataBase.class);

     String SELECT_ACCOUNT_DATA="SELECT * FROM bank_account WHERE account_balance>1000";
    private static final String SELECT_CUSTOMER_DATA="SELECT * FROM customers";


    public BankAccountDataBase(){
        try{
            DataSource Main_DataSource=BankAccountConnectionPool.getDataSource();
            connection=Main_DataSource.getConnection();
        }catch (Exception e){
            logger.error(e);
        }
    }

    public ArrayList<Account> getAccounts(){
        this.accounts=new ArrayList<>();
        try{
            Main_Statement=connection.prepareStatement(SELECT_ACCOUNT_DATA);
            Main_Set=Main_Statement.executeQuery();
            while (Main_Set.next()){
                accounts.add(new Account(Main_Set.getString("account_number"),AccountType.valueOf(Main_Set.getString("account_type")),
                        Main_Set.getInt("account_customer_id"),Main_Set.getInt("account_limit"),
                        Main_Set.getString("account_open_date"),Main_Set.getInt("account_balance")));
            }

        }catch (Exception e){
            logger.error(e);
        }
        return accounts;
    }



    public ArrayList<Customer>getCustomers(){
        this.customers=new ArrayList<>();
        try{
            Main_Statement=connection.prepareStatement(SELECT_CUSTOMER_DATA);
            Main_Set=Main_Statement.executeQuery();
            while (Main_Set.next()){
                customers.add(new Customer(Main_Set.getInt("customer_id"),Main_Set.getString("customer_name"),Main_Set.getString("customer_surname"),
                        Main_Set.getString("customer_address"),Main_Set.getInt("customer_zip_code"),
                        Main_Set.getString("customer_national_id"),Main_Set.getString("customer_birth_date")));
            }
        }catch (Exception e){
            logger.error(e);
        }


        return customers;
    }



}
