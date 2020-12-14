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

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.zachard.spring.boot.hello.model.BatchPerson;
import com.zachard.spring.boot.hello.processor.SpringBatchPersonItemProcessor;

/**
 * 创建Spring Batch批处理的作业
 * 
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
public class SpringBatchHelloWorldJobConfig {

    @Bean
    public Job helloWorlJob(JobBuilderFactory jobBuilders, StepBuilderFactory stepBuilders) {
        return jobBuilders.get("helloWorldJob")
                .start(helloWorldStep(stepBuilders))
                .build();
    }

    @Bean
    public Step helloWorldStep(StepBuilderFactory stepBuilders) {
        return stepBuilders.get("helloWorldStep")
                .<BatchPerson, String>chunk(10).reader(reader()).processor(processor())
                .writer(writer()).build();
    }

    @Bean
    public FlatFileItemReader<BatchPerson> reader() {
        return new FlatFileItemReaderBuilder<BatchPerson>()
                .name("personItemReader")
                .resource(new ClassPathResource("csv/persons.csv"))
                .delimited()
                .names(new String[] { "firstName", "lastName" })
                .targetType(BatchPerson.class)
                .build();
    }

    @Bean
    public SpringBatchPersonItemProcessor processor() {
        return new SpringBatchPersonItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<String> writer() {
        return new FlatFileItemWriterBuilder<String>().name("greetingItemWriter")
                .resource(new FileSystemResource("target/test-outputs/greetings.txt"))
                .lineAggregator(new PassThroughLineAggregator<>()).build();
    }

}
