package service;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product("1", "John", "john@codegym.vn", "Hanoi", "Hanoi"));
        products.put(2, new Product("2", "Bill", "bill@codegym.vn", "Danang","Danang"));
    }

    @Override
    public List findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {

        products.put(Integer.valueOf(product.getProductId()), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
