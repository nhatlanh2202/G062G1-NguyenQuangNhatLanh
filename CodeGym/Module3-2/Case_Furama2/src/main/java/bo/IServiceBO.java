package bo;

import model.Service;

import java.util.List;

public interface IServiceBO {
    List<Service> selectAllService();

    void insertService(Service Service);
}
