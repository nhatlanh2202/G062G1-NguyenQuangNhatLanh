package dao;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    DBConnection dBConnection = new DBConnection();
    private static final String SELECT_ALL_PRODUCT = "select*from product;";
    private static final String INSERT_NEW_PRODUCT = "insert into product(id, name, price, quantity, color,description, category) value (?,?,?,?,?,?,?);";
    private static final String UPDATE_PRODUCT = "update product set id = ?, name = ?, price = ?, quantity = ?, color = ?, description = ?, category = ?;";
    private static final String DELETE_PRODUCT = "delete from product where id = ?;";
    private static final String SEARCH_PRODUCT_BY_NAME = "select * from product where name like ?";
    @Override
    public List<Product> selectAllProduct() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet = statement.executeQuery();
                Product product = null;
                while (resultSet.next()) {
                    product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setColor(resultSet.getString("color"));
                    product.setDescription(resultSet.getString("description"));
                    product.setCategory(resultSet.getString("category"));
                    productList.add(product);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return productList;
    }

    @Override
    public void insertProduct(Product product) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_PRODUCT);
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setInt(4, product.getQuantity());
                statement.setString(5, product.getColor());
                statement.setString(6, product.getDescription());
                statement.setString(7, product.getCategory());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowUpdate = false;
        if (connection != null){
            try {
                statement = connection.prepareStatement(UPDATE_PRODUCT);
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setInt(4, product.getQuantity());
                statement.setString(5, product.getColor());
                statement.setString(6, product.getDescription());
                statement.setString(7, product.getCategory());
                rowUpdate = statement.executeUpdate() > 0;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteProduct(int id) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        boolean rowDeleted = false;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_PRODUCT);
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }

    @Override
    public List<Product> searchByName(String name) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_PRODUCT_BY_NAME);
                statement.setString(1, "%" + name + "%");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    product.setColor(resultSet.getString("color"));
                    product.setDescription(resultSet.getString("description"));
                    product.setCategory(resultSet.getString("category"));
                    productList.add(product);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dBConnection.close();
            }
        }
        return productList;
    }
}
