package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Category;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAllProduct() {
        return this.productDAO.findAllProduct();
    }

    @Override
    public Product findByID(String id) {
        return this.productDAO.findByID(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productDAO.findByName(name);
    }

    @Override
    public String save(Product product) {
        return this.productDAO.save(product);
    }

    @Override
    public String update(Product product) {
        return this.productDAO.update(product);
    }

    @Override
    public void delete(String id) {
        this.productDAO.delete(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return this.productDAO.findAllCategory();
    }
}
