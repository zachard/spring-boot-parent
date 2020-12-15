package com.zachard.spring.boot.hello;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.zachard.spring.boot.hello.configuration.OverrideSpringBatchConfiguration;
import com.zachard.spring.boot.hello.configuration.SpringBatchHelloWorldJobConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBatchHelloWorldTest.SpringBatchTestConfig.class})
public class SpringBatchHelloWorldTest {
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void testHelloWorldBatch() throws Exception {
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		System.err.println(jobExecution.getExitStatus().getExitCode());
	}
	
	@Configuration
	@Import({OverrideSpringBatchConfiguration.class, SpringBatchHelloWorldJobConfig.class})
	static class SpringBatchTestConfig {
		
		@Autowired
		private Job helloWorldJob;
		
		@Bean
		JobLauncherTestUtils jobLauncherTestUtils() throws NoSuchJobException {
			JobLauncherTestUtils jobLauncherTestUtils = 
					new JobLauncherTestUtils();
			jobLauncherTestUtils.setJob(helloWorldJob);
			
			return jobLauncherTestUtils;
		}
	}

}
