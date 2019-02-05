/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.common.service.main.models.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author dwin
 */
public class CreateContractTest {

    // cut
    private CreateContract classUnderTest;
    
    //mockdata
    private AccountForm form;
    
    @Before
    public void setUp() {
        classUnderTest = new CreateContract();                
    }
    
    @After
    public void tearDown() {
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void happyPath_noErrors() {        
        // valid arguments
        form = new AccountForm();
        form.setBalance(1000);
        form.setUserName("Bruce Wayne");
        form.setDisplayName("Batman");
        form.setCreateUser("Ron");
        form.setUpdateUser("Evan");

        // tested act
        classUnderTest.validate(form);
        
        // no assertion, test is that error isn't thrown
    }
    
    @Test
    public void formMissing_errors() {
        // valid arguments
        form = null;
        // expectations
        exception.expect(ResourceNotFoundException.class);
        exception.expectMessage("AccountForm Missing");

        // tested act
        classUnderTest.validate(form);               
    }
    
    @Test
    public void missingBalance_errors() {
        // valid arguments
        form = new AccountForm();
        form.setUserName("Bruce Wayne");
        form.setDisplayName("Batman");
        form.setCreateUser("Ron");
        form.setUpdateUser("Evan");

        // expectations
        exception.expect(ResourceNotFoundException.class);
        exception.expectMessage("Starting Balance Missing");

        // tested act
        classUnderTest.validate(form);               
    }
    
    @Test
    public void missingUserName_errors() {
        // valid arguments
        form = new AccountForm();
        form.setBalance(1000);
        form.setDisplayName("Batman");
        form.setCreateUser("Ron");
        form.setUpdateUser("Evan");

        // expectations
        exception.expect(ResourceNotFoundException.class);
        exception.expectMessage("UserName Missing");

        // tested act
        classUnderTest.validate(form);               
    }
    
    @Test
    public void missingDisplayName_errors() {
        // valid arguments
        form = new AccountForm();
        form.setBalance(1000);
        form.setUserName("Bruce Wayne");
        form.setCreateUser("Ron");
        form.setUpdateUser("Evan");

        // expectations
        exception.expect(ResourceNotFoundException.class);
        exception.expectMessage("DisplayName Missing");

        // tested act
        classUnderTest.validate(form);               
    }
    
    @Test
    public void missingCreateUser_errors() {
        // valid arguments
        form = new AccountForm();
        form.setBalance(1000);
        form.setUserName("Bruce Wayne");
        form.setDisplayName("Batman");
        form.setUpdateUser("Evan");

        // expectations
        exception.expect(ResourceNotFoundException.class);
        exception.expectMessage("CreateUser Missing");

        // tested act
        classUnderTest.validate(form);               
    }
    
    @Test
    public void missingUpdateUser_errors() {
        // valid arguments
        form = new AccountForm();
        form.setBalance(1000);
        form.setUserName("Bruce Wayne");
        form.setDisplayName("Batman");
        form.setCreateUser("Ron");

        // expectations
        exception.expect(ResourceNotFoundException.class);
        exception.expectMessage("UpdateUser Missing");

        // tested act
        classUnderTest.validate(form);               
    }
    
}
