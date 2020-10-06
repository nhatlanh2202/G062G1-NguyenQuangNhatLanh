package bo;

import dao.ServiceDAO;
import model.Service;

import java.util.List;

public class ServiceBO implements IServiceBO {
    private ServiceDAO serviceDAO = new ServiceDAO();

    @Override
    public List<Service> selectAllService() {
        return serviceDAO.selectAllService();
    }

    @Override
    public void insertService(Service Service) {
        serviceDAO.insertService(Service);
    }
}
