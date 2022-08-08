package storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileBinary implements ReadWriteData{

    @Override
    public List<Product> readData(String path) {
        List<Product> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void writeData(List<Product> productsList, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productsList);
            oos.close();
            fos.close();
        } catch (IOException o) {
            o.printStackTrace();
        }
    }
}
