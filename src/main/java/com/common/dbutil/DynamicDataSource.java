package com.common.dbutil;

import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource  extends AbstractRoutingDataSource {

	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();  
	}


	@Override
	public Logger getParentLogger() {
		// TODO Auto-generated method stub
		return null;
	}

}