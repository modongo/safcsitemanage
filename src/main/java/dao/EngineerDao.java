package dao;

import models.Engineer;

import java.util.List;

public interface EngineerDao {
    //list
    List<Engineer> getAll();

    //create
    void add(Engineer engineer);

    //read
    //Engineer findById(int id);
    //List<Site> getAllSitesByEngineer(int )

    //update

    //delete

}
