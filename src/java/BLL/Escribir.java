package BLL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
 
public class Escribir {
    public static void escribir(String msg) {
        FileWriter flwriter = null;
        try 
        {
            flwriter = new FileWriter("C:\\Users\\HPpavilion\\Documents\\NetBeansProjects\\SUDpage\\text.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            bfwriter.newLine();
            bfwriter.write(new Date() +": "+ msg + "\n");
            bfwriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }	
}