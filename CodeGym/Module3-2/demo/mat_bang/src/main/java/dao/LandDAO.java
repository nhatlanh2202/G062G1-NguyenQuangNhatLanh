package dao;

import model.Land;
import model.LandStatus;
import model.LandType;

import java.util.List;

public interface LandDAO {
    List<Land> findAllLand();

    Land findByID(String id);

    List<Land> findByFloor(String floor);

    List<Land> findByArea(String area);

    List<Land> findByFloorAndArea(String floor, String area);

    String save(Land land);

    String update(Land land);

    void delete(String id);

    List<LandType> findAllLandType();

    List<LandStatus> findAllLandStatus();

    List<String> findAllIDLand();
}
