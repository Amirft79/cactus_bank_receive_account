package ir.cactus.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ir.cactus.util.OutPutFileModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.ArrayList;



public class BankDataXMLParser {
    private ArrayList<OutPutFileModel> outPutFileModels;

    public BankDataXMLParser(ArrayList<OutPutFileModel> outPutFileModels){
        this.outPutFileModels=outPutFileModels;
    }

    public void MakeFinalXmlFile(){
        try (FileOutputStream fos=new FileOutputStream("./OutPut.xml")){

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document=builder.newDocument();
            Element Root_Element=document.createElement("Accounts");
            document.appendChild(Root_Element);

            for (OutPutFileModel model:outPutFileModels) {
                Element account=document.createElement("account");
                Root_Element.appendChild(account);
                Element Customer_Id=document.createElement("Customer_Id");
                account.appendChild(Customer_Id);
                Customer_Id.setTextContent(String.valueOf(model.getCustomer_Id()));
                Element Customer_Name=document.createElement("Customer_Name");
                account.appendChild(Customer_Name);
                Customer_Name.setTextContent(model.getCustomer_Name());
                Element Customer_SurName=document.createElement("Customer_SurName");
                account.appendChild(Customer_SurName);

                Customer_SurName.setTextContent(model.getCustomer_SurName());
                Element National_Id=document.createElement("National_Id");
                account.appendChild(National_Id);

                National_Id.setTextContent(model.getNational_Id());
                Element Account_Number=document.createElement("Account_Number");
                account.appendChild(Account_Number);

                Account_Number.setTextContent(model.getAccount_Number());
                Element Account_Open_Date=document.createElement("Account_Open_Date");
                account.appendChild(Account_Open_Date);

                Account_Open_Date.setTextContent(model.getAccount_Open_Date());
                Element Account_Balance=document.createElement("Account_Balance");
                account.appendChild(Account_Balance);

                Account_Balance.setTextContent(String.valueOf(model.getAccount_Balance()));

            }
            writeXml(document,fos);


        }catch (Exception e){
            e.printStackTrace();
        }





    }

    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.transform(source, result);

    }





}
