package bo;

import model.Product;

import java.util.List;

public interface IProductBO {
    List<Product> selectAllProduct();

    void insertProduct(Product product);

    boolean deleteProduct(int id);

    List<Product> searchByName(String name);
}
