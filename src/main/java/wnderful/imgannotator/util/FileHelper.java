package wnderful.imgannotator.util;

import java.io.*;

public class FileHelper {
    public Boolean write(String name,String content){
        try{
            PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/static/data/"+name+".txt"));
            out.write(content);
            out.close();
            return  true;
        }catch(IOException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public String read(String name){
        String content = "";
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/static/data/"+name+".txt")));
            String str = "";
            while ((str=in.readLine())!=null){
                content = content + str;
            }
            in.close();
            return content;
        }catch(IOException ex){
            ex.printStackTrace();
            return "";
        }
    }

    public String delete(String name){
        try{
            File file = new File("src/main/resources/static/data/"+name+".txt");
            file.delete();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "done";
    }
}
