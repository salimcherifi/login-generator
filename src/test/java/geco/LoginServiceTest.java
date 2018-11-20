package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {
    LoginService log;
    @Before
    public void init(){
        String[] logins = {"coucou"};
        log = new LoginService(logins);


    }

    @Test
    public void loginExists() {
        assertTrue(log.loginExists("coucou"));
    }

    @Test
    public void addLogin() {
    }

    @Test
    public void findAllLoginsStartingWith() {
    }

    @Test
    public void findAllLogins() {
    }
}