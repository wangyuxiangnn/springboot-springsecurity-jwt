package com.kyle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo2ApplicationTests {

	@Test
	public void contextLoads() {
		long refreshPeriodTime = 36000L;  //seconds为单位,10 hours
		System.out.println(refreshPeriodTime >> 1);
	}

}
