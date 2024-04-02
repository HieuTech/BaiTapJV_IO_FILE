package BaiTap.baitap5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/suongtran/Desktop/JavaLearn/Session18_IO_FILE/src/BaiTap/baitap5/countries.csv";
        List<String> strList =   readFile(filePath);

        for (String element: strList){
            String[] obj = element.split(",");
            Country country = new Country();
            country.setId(Integer.parseInt(obj[0]));
            country.setCode(obj[1]);
            country.setName(obj[2]);
            System.out.println(country);
        }
    }

    public static List<String> readFile(String filePath){
        File inputFile = new File(filePath);
        if(!inputFile.exists()){
            throw new RuntimeException("File ko ton tai");
        }
        BufferedReader bfr = null;
        List<String> list = new ArrayList<>();
        try{
            bfr = new BufferedReader(new FileReader(filePath));
            String c ;
            while ((c = bfr.readLine()) != null){
              list.add(c);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
            // neu throw thi ko the return dc
        } finally {

            if(bfr != null){
                try {
                    bfr.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

}


