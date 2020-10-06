package dao;

import model.ContractDetail;

import java.util.List;

public interface IContractDetailDAO {

    List<ContractDetail> selectAllContractDetail();

    void insertContractDetail(ContractDetail contractDetail);

}
