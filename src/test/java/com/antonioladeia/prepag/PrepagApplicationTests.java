package com.antonioladeia.prepag;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import prepag.PrepagApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrepagApplicationTests {

	@Autowired
	private PrepagApplication context;

	@Test
	public void contextLoads() {
		PrepagApplication.main(new String[] {});
		assertThat(this.context).isNotNull();
	}

}