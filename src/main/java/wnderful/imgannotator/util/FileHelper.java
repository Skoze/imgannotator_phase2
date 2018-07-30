package wnderful.imgannotator.util;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {
    public boolean dataExist(String fileName) {
        File file = new File("src/main/resources/static/data/" + fileName+".txt");
        if(file.exists()){
            return true;
        }else {
            return false;
        }
    }

    public boolean write(String pathname, String content) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/static/data/" + pathname + ".txt"));
            out.write(content);
            out.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String read(String name) {
        String content = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/static/data/" + name)));
            String str = "";
            while ((str = in.readLine()) != null) {
                content = content + str;
            }
            in.close();
            return content;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public ArrayList<String> readList(String path){
        File file = new File("src/main/resources/static/data/"+path);
        File[] files = file.listFiles();
        ArrayList<String> list = new ArrayList<>();
        if(files!=null){
            for(File aFile:files){
                String content = read(path+aFile.getName());
                list.add(content);
            }
            return list;
        }else {
            return null;
        }
    }

    public String delete(String name) {
        try {
            File file = new File("src/main/resources/static/data/" + name + ".txt");
            file.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "done";
    }
}
