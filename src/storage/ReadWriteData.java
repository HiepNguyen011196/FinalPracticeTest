package storage;
import model.Product;
import java.util.List;
public interface ReadWriteData {
    List<Product> readData(String path);
    void writeData(List<Product> productsList, String path);
}
