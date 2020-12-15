/*
 *  Copyright 2015-2020 zachard, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.zachard.spring.boot.hello.configuration;

import java.nio.charset.Charset;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.zachard.spring.boot.hello.model.BatchPerson;
import com.zachard.spring.boot.hello.processor.SpringBatchPersonItemProcessor;

/**
 * 创建Spring Batch批处理的作业相关配置, 与作业相关的配置
 * 
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
public class SpringBatchHelloWorldJobConfig {

	/**
	 * 通过{@link JobBuilderFactory}来创建作业, 
	 * 而{@link StepBuilderFactory}用于创建作业相关的步骤
	 * 
	 * @param jobBuilders   创建作业对象的工厂
	 * @param stepBuilders  创建作业步骤的工厂
	 * @return              一个创建好的步骤
	 */
    @Bean
    public Job helloWorlJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders) {
        return jobBuilders.get("helloWorldJob")  // get方法创建一个作业(job)创建器, 并进行相应的初始化, JobBuilder用于创建各种类型的作业(job)
                .start(helloWorldStep(stepBuilders))  // 创建一个新的作业创建器, 并用于执行一个步骤或者多个步骤
                .build();  // 通过作业创建器创建一个作业
    }

    /**
     * 通过{@link StepBuilderFactory}工厂来创建相应的步骤
     * 
     * @param stepBuilders
     * @return
     */
    @Bean
    public Step helloWorldStep(StepBuilderFactory stepBuilders) {
        return stepBuilders.get("helloWorldStep")  // 创建一个步骤创建器并初始化相关的信息
                .<BatchPerson, String>chunk(10)  // 通过chunk创建与提供参数处理项目的步骤
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    /**
     * 构建一个可以重启的{@link ItemReader}用于读取相关文件中的行.
     * @return
     */
    @Bean
    public FlatFileItemReader<BatchPerson> reader() {
    	FlatFileItemReader<BatchPerson> csvReader = new FlatFileItemReader<>();
    	csvReader.setResource(new ClassPathResource("csv/batch-persons.csv"));
    	csvReader.setLineMapper(new DefaultLineMapper<BatchPerson>() {{
    		setLineTokenizer(new DelimitedLineTokenizer() {{
    			setNames(new String[] {"firstName", "lastName"});
    		}});
    		setFieldSetMapper(new BeanWrapperFieldSetMapper<BatchPerson>() {{
    			setTargetType(BatchPerson.class);
    		}});
    	}});
    	
    	return csvReader;
    }

    @Bean
    public SpringBatchPersonItemProcessor processor() {
        return new SpringBatchPersonItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<String> writer() {
        FlatFileItemWriter<String> txtItemWrite = new FlatFileItemWriter<String>();
        txtItemWrite.setAppendAllowed(true);
        txtItemWrite.setEncoding("UTF-8");
        txtItemWrite.setResource(new ClassPathResource("csv/batch-data.txt"));
        txtItemWrite.setLineAggregator(new PassThroughLineAggregator<String>());
        
        return txtItemWrite;
    }

}
