package bo;

import model.Contract;

import java.util.List;

public interface IContractBO {
    List<Contract> selectAllContract();

    void insertContract(Contract contract);

}
