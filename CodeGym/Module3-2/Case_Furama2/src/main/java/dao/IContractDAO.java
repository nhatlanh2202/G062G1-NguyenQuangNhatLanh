package dao;

import model.Contract;

import java.util.List;

public interface IContractDAO {

    List<Contract> selectAllContract();

    void insertContract(Contract contract);
}
