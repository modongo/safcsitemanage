package dao;

import models.Engineer;
import models.Sites;

import java.util.List;

public interface SiteDao {

    List<Sites> getAll();

    //create
    void add(Sites sites);
}
