package models;

import java.util.Objects;

public class Engineer extends Account{
    private String firstName;
    private String secondName;
    private String EkNo;
    private int assignedSiteId;


    public Engineer(String firstName, String secondName, String ekNo) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.EkNo = ekNo;
        this.assignedSiteId = assignedSiteId;
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engineer)) return false;
        if (!super.equals(o)) return false;
        Engineer engineer = (Engineer) o;
        return
                firstName.equals(engineer.firstName) &&
                secondName.equals(engineer.secondName) &&
                EkNo.equals(engineer.EkNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, secondName, EkNo);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), firstName, secondName, EkNo, assignedSiteId);
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEkNo() {
        return EkNo;
    }

    public void setEkNo(String ekNo) {
        EkNo = ekNo;
    }

    public int getAssignedSiteId() {
        return assignedSiteId;
    }

    public void setAssignedSiteId(int assignedSiteId) {
        this.assignedSiteId = assignedSiteId;
    }
    public int getId(){ return id;}
    public void setId(int id){ this.id = id;}
}
