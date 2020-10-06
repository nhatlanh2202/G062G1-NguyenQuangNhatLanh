package bo;

import dao.ContractDetailDAO;
import dao.IContractDetailDAO;
import model.ContractDetail;

import java.util.List;

public class ContractDetailBO implements IContractDetailDAO {
    ContractDetailDAO contractDetailDAO = new ContractDetailDAO();

    @Override
    public List<ContractDetail> selectAllContractDetail() {
        return contractDetailDAO.selectAllContractDetail();
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        contractDetailDAO.insertContractDetail(contractDetail);
    }
}
