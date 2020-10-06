package bo;

import dao.ContractDAO;
import model.Contract;

import java.util.List;

public class ContractBO implements IContractBO {
    ContractDAO contractDAO = new ContractDAO();
    @Override
    public List<Contract> selectAllContract() {
        return contractDAO.selectAllContract();
    }

    @Override
    public void insertContract(Contract contract) {
        contractDAO.insertContract(contract);
    }
}
