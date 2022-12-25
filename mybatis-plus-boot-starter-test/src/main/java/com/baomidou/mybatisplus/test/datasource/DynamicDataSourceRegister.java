package com.baomidou.mybatisplus.test.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author vanchan
 * @Date 2022/12/23 13:15
 * @Version 1.0
 * <p>
 * description：
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceRegister.class);

    // 如配置文件中未指定数据源类型，使用该默认值
    private static final Object DATASOURCE_TYPE_DEFAULT = "com.alibaba.druid.pool.DruidDataSource";

    // 数据源
    private DataSource defaultDataSource;
    private Map<String, DataSource> customDataSources = new HashMap<>();

    private static String DB_NAME = "names";
    private static String DB_DEFAULT_VALUE = "spring.datasource";


    /**
     * 加载多数据源配置
     */
    @Override
    public void setEnvironment(Environment env) {
        initDefaultDataSource(env);
        initCustomDataSources(env);
    }


    /**
     * 2.0.4 初始化主数据源
     */
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", env.getProperty(DB_DEFAULT_VALUE + "." + "type"));
        dsMap.put("driver-class-name", env.getProperty(DB_DEFAULT_VALUE + "." + "driver-class-name"));
        dsMap.put("url", env.getProperty(DB_DEFAULT_VALUE + "." + "url"));
        dsMap.put("username", env.getProperty(DB_DEFAULT_VALUE + "." + "username"));
        dsMap.put("password", env.getProperty(DB_DEFAULT_VALUE + "." + "password"));
        defaultDataSource = buildDataSource(dsMap);
    }

    // 初始化更多数据源
    private void initCustomDataSources(Environment env) {
        // 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
        String dsPrefixs = env.getProperty(DB_DEFAULT_VALUE + "." + DB_NAME);
        // 多个数据源
        for (String dsPrefix : dsPrefixs.split(",")) {
            Map<String, Object> dsMap = new HashMap<>();

            dsMap.put("type", env.getProperty(DB_DEFAULT_VALUE + "." +  dsPrefix + ".type"));
            dsMap.put("driver-class-name", env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + ".driver-class-name"));
            dsMap.put("url", env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + ".url"));
            dsMap.put("username", env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + ".username"));
            dsMap.put("password", env.getProperty(DB_DEFAULT_VALUE + "."  +  dsPrefix + ".password"));

            DataSource ds = buildDataSource(dsMap);
            customDataSources.put(dsPrefix, ds);
        }
    }



    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }

        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);

        logger.info("Dynamic DataSource Registry");
    }

    // 创建DataSource
    @SuppressWarnings("unchecked")
    public DataSource buildDataSource(Map<String, Object> dsMap) {
        try {
            Object type = dsMap.get("type");
            if (type == null) {
                // 默认DataSource
                type = DATASOURCE_TYPE_DEFAULT;
            }

            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

            String driverClassName = dsMap.get("driver-class-name").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();

            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

