package de.hftl.FrontEndRestConsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
public class FrontendFunctionalityTest {
	FrontendFunctionality functionality = new FrontendFunctionality();
	
	@Test
	public void functionalityTest() {
		
		Assert.assertEquals(55, functionality.functionalityTesting(10));
	}
}
