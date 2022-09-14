package ir.cactus.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.cactus.util.OutPutFileModel;

import java.io.FileWriter;
import java.util.ArrayList;

public class BankDataJsonParser {
    private ArrayList<OutPutFileModel> outPutFileModels;
    public BankDataJsonParser(ArrayList<OutPutFileModel>outPutFileModels){
        this.outPutFileModels=outPutFileModels;
    }

    public void MakeFinalJsonFile(){
        Gson Final_Gson=new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer=new FileWriter("OutPut.json")){
            writer.write("[");
            int i=0;
            for (OutPutFileModel model:this.outPutFileModels){
                if (i!=0){
                    writer.write(",");
                }
                Final_Gson.toJson(model,writer);
                i++;
            }
            writer.write("]");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
