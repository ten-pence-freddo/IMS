package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import org.junit.Test;

public class DomainTest {

    @Mock
    Utils utils;

    @Test
    public void testGetDescription() {
        Mockito.when(utils.getString()).thenReturn("CUSTOMER");
        assertEquals("Information about customers", Domain.CUSTOMER.getDescription());
        Mockito.when(utils.getString()).thenReturn("ITEM");
        assertEquals("Individual Items", Domain.ITEM.getDescription());
        Mockito.when(utils.getString()).thenReturn("ORDER");
        assertEquals("Purchases of items", Domain.ORDER.getDescription());
        Mockito.when(utils.getString()).thenReturn("STOP");
        assertEquals("To close the application", Domain.STOP.getDescription());
    }

   /*  @Test
    public void testPrintDomains() {
        Logger logger = LogManager.getLogger();
        Mockito.when(utils.getString()).thenReturn("CUSTOMER");
        Domain.printDomains();
        assertEquals(1, logger.getLogRecords().size());
        Mockito.when(utils.getString()).thenReturn("ITEM");
        Domain.printDomains();
        assertEquals(2, logger.getLogRecords().size());
        Mockito.when(utils.getString()).thenReturn("ORDER");
        Domain.printDomains();
        assertEquals(3, logger.getLogRecords().size());
        Mockito.when(utils.getString()).thenReturn("STOP");
        Domain.printDomains();
        assertEquals(4, logger.getLogRecords().size());
    }*/

    @Test
    public void testGetDomain() {
        //assertEquals(Domain.CUSTOMER, Domain.getDomain(utils));
        Mockito.when(utils.getString()).thenReturn("ITEM");
        assertEquals(Domain.ITEM, Domain.getDomain(utils));
        Mockito.when(utils.getString()).thenReturn("ORDER");
        assertEquals(Domain.ORDER, Domain.getDomain(utils));
        Mockito.when(utils.getString()).thenReturn("STOP");
        assertEquals(Domain.STOP, Domain.getDomain(utils));
    }
}