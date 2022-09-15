package ir.cactus;

import ir.cactus.database.BankAccountDataBase;
import ir.cactus.model.Account;
import ir.cactus.model.Customer;
import ir.cactus.parser.BankDataJsonParser;
import ir.cactus.parser.BankDataXMLParser;
import ir.cactus.util.OutPutFileModel;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class BankAccountDataServerOutput {

    private static Logger logger=Logger.getLogger(BankAccountDataServerOutput.class);




    public static void main(String[] args) {
         ArrayList<OutPutFileModel>outPutFileModels=new ArrayList<>();


        System.out.println("in this program we recive the data of data of bank member"+"\n");
        System.out.println("first we get data from database");
        try {
            Thread.currentThread().sleep(3000);
        }catch (InterruptedException e){logger.error(e);}
        BankAccountDataBase dataBase=new BankAccountDataBase();
        for (Customer customer:dataBase.getCustomers()){
            for (Account account:dataBase.getAccounts()){
                if (customer.getCustomer_Id()==account.getAccount_Customer_id()){
                    outPutFileModels.add(new OutPutFileModel(
                            customer.getCustomer_Id(),
                            customer.getCustomer_Name(),
                            customer.getCustomer_Surname(),
                            customer.getCustomer_National_ID(),
                            account.getAccount_Number(),
                            account.getAccount_Open_Date(),
                            account.getAccount_Balance()
                    ));
                }
            }
        }


        System.out.println("data received"+"\n");
        System.out.println("now we are make the final file for output accounts ........");
        try {
            Thread.currentThread().sleep(2000);
        }catch (InterruptedException e){logger.error(e);}
        BankDataJsonParser json_parser=new BankDataJsonParser(outPutFileModels);
        json_parser.MakeFinalJsonFile();
        System.out.println("json file is created"+"\n");
        System.out.println("we are now create the xml file");
        BankDataXMLParser xmlParser=new BankDataXMLParser(outPutFileModels);
        xmlParser.MakeFinalXmlFile();
        System.out.println("xml file is created");

    }
}
