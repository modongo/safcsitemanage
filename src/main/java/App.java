import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Sites;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import dao.DB;
import dao.Sql2oEngineerDao;
import dao.EngineerDao;
import dao.SiteDao;
import dao.Sql2oSiteDao;
import models.Engineer;
import models.Account;

public class App {

    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if(process.environment().get("PORT") != null ){
            port = Integer.parseInt(process.environment().get("PORT"));

        }else {
            port = 4567;
        }
        port(port);

     staticFileLocation("/public");
     Sql2oSiteDao siteDao = new Sql2oSiteDao(DB.sql2o);
     Sql2oEngineerDao engineerDao = new Sql2oEngineerDao(DB.sql2o);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/engineerlist",(req,res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = engineerDao.getAll();
            model.put("engineers", engineers);
            List<Sites> sites = siteDao.getAll();
            model.put("sites",sites);
            return new ModelAndView(model,"engineer-details.hbs");
        },new HandlebarsTemplateEngine());

        get("/engineernew",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"engineer-form.hbs");
        },new HandlebarsTemplateEngine());

        post("/engineernew",(req,res)->{
            String firstname = req.queryParams("firstname");
            String secondname = req.queryParams("secondname");
            String ekno = req.queryParams("ekno");
            Engineer newEngineer = new Engineer(firstname,secondname,ekno);
            engineerDao.add(newEngineer);
            res.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        get("/siteform",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = engineerDao.getAll();
            model.put("engineers", engineers);
            return new ModelAndView(model,"site-form.hbs");
        },new HandlebarsTemplateEngine());

        get("/:id",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params("id"));
            Engineer foundEngineer = engineerDao.findById(id);
            model.put("engineers", foundEngineer);
            List<Sites> sites = engineerDao.getAllSitesByEngineer(id);
            model.put("sites",sites);
            return new ModelAndView(model,"site-details.hbs");
        },new HandlebarsTemplateEngine());

        post("/sitenew",(req,res)->{
            String sitename = req.queryParams("sitename");
            int engId = Integer.parseInt(req.queryParams("id"));
//            int siteId = Integer.parseInt(req.queryParams("siteId"));
            System.out.println("*******"+engId+"************");
            Sites newSite = new Sites(sitename,engId);
            siteDao.add(newSite);
            res.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

    }


}
