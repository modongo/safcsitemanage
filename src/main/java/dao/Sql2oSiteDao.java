package dao;
import models.Sites;
import models.Engineer;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oSiteDao implements SiteDao{

    private final Sql2o sql2o;

    public Sql2oSiteDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Sites sites) {
        String sql = "INSERT INTO sites (sitename ,eng_id ) VALUES (:sitename ,:id)";
        try(Connection con = DB.sql2o.open()){
            con.createQuery(sql) //make a new variable
                    .bind(sites)
                    .executeUpdate(); //run it all
        } catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
    @Override
    public List<Sites> getAll(){
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM sites").executeAndFetch(Sites.class);

        }

    }

}
