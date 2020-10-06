package dao;

import common.DBConnection;
import model.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailDAO implements IContractDetailDAO {
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select*from contract_detail;";
    private static final String INSERT_NEW_CONTRACT_DETAIL = "insert into contract_detail(contract_detail_id,contract_id,attach_service_id,quanlity) values (?,?,?,?)";
    DBConnection dBConnection = new DBConnection();
    @Override
    public List<ContractDetail> selectAllContractDetail() {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ContractDetail> contractDetailList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
                resultSet = statement.executeQuery();
                ContractDetail contractDetail = null;
                while (resultSet.next()) {
                    contractDetail = new ContractDetail();
                    contractDetail.setContractDetailId(resultSet.getInt("contract_detail_id"));
                    contractDetail.setContractId(resultSet.getString("contract_id"));
                    contractDetail.setAttachServiceId(resultSet.getInt("attach_service_id"));
                    contractDetail.setQuanlity(resultSet.getInt("quanlity"));
                    contractDetailList.add(contractDetail);
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
        return contractDetailList;
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        Connection connection = dBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_CONTRACT_DETAIL);
                statement.setInt(1, contractDetail.getContractDetailId());
                statement.setString(2, contractDetail.getContractId());
                statement.setInt(3, contractDetail.getAttachServiceId());
                statement.setInt(4, contractDetail.getQuanlity());
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
