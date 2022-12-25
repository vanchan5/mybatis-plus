package com.baomidou.mybatisplus.test.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author vanchan
 * @Date 2022/12/23 13:10
 * @Version 1.0
 * <p>
 * description：
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
