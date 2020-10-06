package bo;

import dao.ProductDAO;
import model.Product;

import java.util.List;

public class ProductBO implements IProductBO {
    ProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> selectAllProduct() {
        return productDAO.selectAllProduct();
    }

    @Override
    public void insertProduct(Product product) {
        productDAO.insertProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productDAO.deleteProduct(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDAO.searchByName(name);
    }


}
