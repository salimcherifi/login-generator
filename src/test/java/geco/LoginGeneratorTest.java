package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginGenerator log;
    @Before
    public void init(){
        LoginService logService = new LoginService(new String[] {"JROL",
                "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        log = new LoginGenerator(logService);
    }
    @Test
    public void generateLoginForNomAndPrenom() {
        assertEquals("PDUR",log.generateLoginForNomAndPrenom("Durandd","Paul"));
    }

    @Test
    public void generateLogin2(){
        assertEquals("JRAL2",log.generateLoginForNomAndPrenom("Ralling","John"));
    }

    @Test
    public void generateLogin3(){
        assertEquals("JROL1",log.generateLoginForNomAndPrenom("Rolling","Jean"));
        assertEquals("PDUR",log.generateLoginForNomAndPrenom("Dùrand","Paul"));
    }


}