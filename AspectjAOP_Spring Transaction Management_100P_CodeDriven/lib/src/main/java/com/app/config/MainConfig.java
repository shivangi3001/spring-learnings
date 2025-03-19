package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PersistenceConfig.class, ServiceConfig.class, AOPConfig.class})
public class MainConfig {

}
