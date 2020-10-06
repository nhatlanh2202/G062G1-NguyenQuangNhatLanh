package dao;

import common.DBConnection;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO implements IServiceDAO {
    DBConnection dBConnection = new DBConnection();
    private static final String SELECT_ALL_SERVICE = "select*from service;";
    private static final String INSERT_NEW_SERVICE = "insert into service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenionce, pool_area, number_of_floors) values (?,?,?,?,?,?,?,?,?,?,?);";
    @Override
    public List<Service> selectAllService() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = statement.executeQuery();
                Service service = null;
                while (resultSet.next()) {
                    service = new Service();
                    service.setServiceId(resultSet.getString("service_id"));
                    service.setServiceName(resultSet.getString("service_name"));
                    service.setServiceArea(resultSet.getInt("service_area"));
                    service.setServiceCost(resultSet.getDouble("service_cost"));
                    service.setServiceMaxPeople(resultSet.getInt("service_max_people"));
                    service.setRentTypeId(resultSet.getInt("rent_type_id"));
                    service.setServiceTypeId(resultSet.getInt("service_type_id"));
                    service.setStandardRoom(resultSet.getString("standard_room"));
                    service.setDescriptionOtherConvenionce(resultSet.getString("description_other_convenionce"));
                    service.setPoolArea(resultSet.getInt("pool_area"));
                    service.setNumberOfFloors(resultSet.getInt("number_of_floors"));
                    serviceList.add(service);
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
        return serviceList;
    }

    @Override
    public void insertService(Service service) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_SERVICE);
                statement.setString(1, service.getServiceId());
                statement.setString(2, service.getServiceName());
                statement.setInt(3, service.getServiceArea());
                statement.setDouble(4, service.getServiceCost());
                statement.setInt(5, service.getServiceMaxPeople());
                statement.setInt(6, service.getRentTypeId());
                statement.setInt(7, service.getServiceTypeId());
                statement.setString(8, service.getStandardRoom());
                statement.setString(9, service.getDescriptionOtherConvenionce());
                statement.setDouble(10, service.getPoolArea());
                statement.setInt(11, service.getNumberOfFloors());
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
}
