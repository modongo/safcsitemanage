package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EngineerTest {

    @Test
    public void setEkNo() {
        Engineer newEngineer = new Engineer("John","Alex","Ek2911",3);
        assertEquals(newEngineer.getEkNo(),"Ek2911");
    }
}