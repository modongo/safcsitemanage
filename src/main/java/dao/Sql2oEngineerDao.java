package dao;

import models.Engineer;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.sql.SQLOutput;
import java.util.List;

public class Sql2oEngineerDao implements  EngineerDao{
    private final Sql2o sql2o;

    public Sql2oEngineerDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Engineer engineer){
        String sql = "INSERT INTO engineers (firstName,secondName,EkNo,assignedSiteId)" +
                " VALUES (:firstName, :secondName, :EkNo, :assignedSiteId)";
        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .bind(engineer)
                     .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
    @Override
    public List<Engineer> getAll(){
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM engineers").executeAndFetch(Engineer.class);

        }

    }



}
