package Service;

import Model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> products;

    static {
        products = new TreeMap<>();
        products.put("p01", new Product("p01", "BMW", "10000$", "Nice", "BMW"));
        products.put("p02", new Product("p02", "Hummer", "10000$", "Nice", "Hummer"));
        products.put("p03", new Product("p03", "Lamborghini", "10000$", "Nice", "Lamborghini"));
        products.put("p04", new Product("p04", "Maserati", "10000$", "Nice", "Maserati"));
        products.put("p05", new Product("p05", "Audi", "10000$", "Nice", "Audi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getValue().getName().equals(name)){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void update(String id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(String id) {
        products.remove(id);
    }
}
