package uk.co.ashleyfrieze.springcontext.service;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.co.ashleyfrieze.springcontext.configuration.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class CountingServiceTest {

	@Test
	public void contextIsOk() {
		
	}

}
