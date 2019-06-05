package dao;

import models.Engineer;
import models.Sites;
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
        String sql = "INSERT INTO engineers (firstname,secondname,EkNo)" +
                " VALUES (:firstName, :secondName, :ekNo)";
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

    }@Override
    public Engineer findById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM engineers WHERE id = :id")
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Engineer.class);
        }
    }


    @Override
    public List<Sites> getAllSitesByEngineer(int engineerId) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("select sites.sitename from sites inner join engineers on sites.eng_id=engineers.id where sites.id=:engineerid")
                    .addParameter("engineerid", engineerId)
                    .executeAndFetch(Sites.class);
        }
    }



}
