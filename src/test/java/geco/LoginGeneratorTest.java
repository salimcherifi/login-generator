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
}