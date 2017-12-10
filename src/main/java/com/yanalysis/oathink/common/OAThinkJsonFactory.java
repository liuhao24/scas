package com.yanalysis.oathink.common;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OAThinkJsonFactory {
	private static final Logger logger = LogManager.getLogger(OAThinkJsonFactory.class.getName());

	private static final ObjectMapper objMapper = new ObjectMapper();

	public static final <T> T fromJson(String content, Class<T> valueType) {
		try {
			return objMapper.readValue(content, valueType);
		} catch (JsonParseException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
	
	public static final String toJson(Object obj) {
		try {
			return objMapper.writeValueAsString(obj);
		} catch (JsonParseException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}
}
