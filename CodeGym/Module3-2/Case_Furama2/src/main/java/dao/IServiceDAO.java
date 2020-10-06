package dao;



import model.Service;

import java.util.List;

public interface IServiceDAO {
    List<Service> selectAllService();
    void insertService(Service service);
}
