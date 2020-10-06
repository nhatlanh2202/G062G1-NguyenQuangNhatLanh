package dao;

import common.DBConnection;
import model.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO implements IContractDAO {
    DBConnection dBConnection = new DBConnection();
    private static final String SELECT_ALL_CONTRACT = "select*from contract;";
    private static final String INSERT_NEW_CONTRACT = "insert into contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) values (?,?,?,?,?,?,?,?)";
    @Override
    public List<Contract> selectAllContract() {

        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Contract> contractList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                resultSet = statement.executeQuery();
                Contract contract = null;
                while (resultSet.next()) {
                    contract = new Contract();
                    contract.setContractId(resultSet.getString("contract_id"));
                    contract.setContractStartDate(resultSet.getString("contract_start_date"));
                    contract.setContractEndDate(resultSet.getString("contract_end_date"));
                    contract.setContractDeposit(resultSet.getDouble("contract_deposit"));
                    contract.setContractTotalMoney(resultSet.getInt("contract_total_money"));
                    contract.setEmployeeId(resultSet.getInt("employee_id"));
                    contract.setCustomerId(resultSet.getString("customer_id"));
                    contract.setServiceId(resultSet.getString("service_id"));
                    contractList.add(contract);
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
        return contractList;
    }

    @Override
    public void insertContract(Contract contract) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_CONTRACT);
                statement.setString(1, contract.getContractId());
                statement.setString(2, contract.getContractStartDate());
                statement.setString(3, contract.getContractEndDate());
                statement.setDouble(4, contract.getContractDeposit());
                statement.setDouble(5, contract.getContractTotalMoney());
                statement.setInt(6, contract.getEmployeeId());
                statement.setString(7, contract.getCustomerId());
                statement.setString(8, contract.getServiceId());
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
