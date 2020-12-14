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

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Batch的配置类
 * <p>
 *   {@link Configuration} 表示将这个Spring Batch的配置类注册为Bean.
 *   {@link EnableBatchProcessing} 表示开启Spring Batch特性, 并提供设置批处理作业的基本配置.  
 *   继承{@link DefaultBatchConfigurer} 并且覆写{@link DefaultBatchConfigurer#setDataSource(javax.sql.DataSource)}
 *   方法不设置相应的数据源, 表示Spring Batch自动配置为一个基于{@link Map}的{@link JobRepository}
 * </p>
 *
 * @author zachard
 * @version 1.0.0
 */
@Configuration
@EnableBatchProcessing
public class OverrideSpringBatchConfiguration extends DefaultBatchConfigurer {
    
    /**
     * 覆写此方法并不做任何操作, 将Spring Batch配置为一个基于Map的JobRepository
     */
    @Override
    public void setDataSource(DataSource dataSource) {
        //
    }

}
