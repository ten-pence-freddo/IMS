package com.qa.ims.controllers;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;
import com.qa.ims.controller.Action;
import com.qa.ims.utils.Utils;

public class ActionTest {

    @Mock
    private Utils utils;

    @Test
    public void testGetDescription() {
        Action action = Action.CREATE;
        assertEquals("CREATE: To save a new entity into the database", action.getDescription());
    }

    @Test
    public void testPrintActions() {
        Action[] actions = Action.values();
        for (Action action : actions) {
            if(action == Action.CREATE)
				assertEquals("CREATE: To save a new entity into the database", action.getDescription());
        }

        Action.printActions();

    }

    @Test
    public void testGetAction() {
        Mockito.when(utils.getString()).thenReturn("CREATE");
        assertEquals(Action.CREATE, Action.getAction(utils));

        Mockito.verify(utils, Mockito.times(1)).getString();
    }

    @Test
    public void testGetActionInvalidInput() {
        Mockito.when(utils.getString()).thenReturn("INVALID");
        assertEquals(null, Action.getAction(utils));
    }
}

