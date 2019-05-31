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
            List<Engineer> engineers = engineerDao.getAll();
            model.put("engineers", engineers);
            List<Sites> sites = siteDao.getAll();
            model.put("sites",sites);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
