package dao;

import models.Engineer;
import models.Sites;

import java.util.List;

public interface EngineerDao {
    //list
    List<Engineer> getAll();

    //create
    void add(Engineer engineer);

    //read
    Engineer findById(int id);
    List<Sites> getAllSitesByEngineer(int engineerId);


    //update

    //delete

}
