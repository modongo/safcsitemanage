package models;

public class Sites extends  Account{

    private int id;
    private String sitename;
    private int eng_id;
    private int siteid;


    public Sites( String sitename, int id) {
        this.id = id;
        this.sitename = sitename;
        this.eng_id = eng_id;
        this.siteid = siteid;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public int getEng_id() {
        return eng_id;
    }

    public void setEng_id(int eng_id) {
        this.eng_id = eng_id;
    }

    public int getSiteid() {
        return siteid;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }
}
