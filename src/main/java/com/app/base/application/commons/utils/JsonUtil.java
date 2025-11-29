package com.app.base.application.commons.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import com.app.base.application.commons.typeadapter.LocalDateTimeTypeAdapter;
import com.app.base.application.commons.typeadapter.LocalDateTypeAdapter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Slf4j
public final class JsonUtil {

	private JsonUtil() {
		throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
	}
	
	public static final Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
			.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
			.create();

	public static String toJsonString(Object object) {
		if (Objects.isNull(object)) {
			return "";
		}
		return gson.toJson(object);
	}

	public static String toJsonStringWithExclusions(Object object) {
		if (Objects.isNull(object)) {
			return "";
		}
		return new GsonBuilder()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
				.create().toJson(object);
	}

	@SuppressWarnings("unchecked")
	public static <T> T toObjectFromJsonString(String jsonString) {
		TypeReference<Map<String, Object>> typeReference = new TypeReference<>() {
        };
		try {
			return (T) new ObjectMapper().readValue(jsonString, typeReference);
		} catch (JsonProcessingException e) {
			log.error("Error processing JSON string: {}", e.getMessage(), e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(String jsonString)
			throws JsonProcessingException {
		return new ObjectMapper().readValue(jsonString, Map.class);
	}

	public static <T> Object toObject(Object source, Class<T> clazz) {
		return new ObjectMapper().convertValue(source, clazz);
	}

	/**
	 * Retorna un objeto de tipo LinkedHashMap donde las llaves corresponden a los
	 * atributos de la clase generica.
     */
	public static <T> Object toObject(String jsonString)
			throws JsonProcessingException {
		TypeReference<T> typeReference = new TypeReference<>() {
        };
		return new ObjectMapper().readValue(jsonString, typeReference);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMapObject(Object object) {
		return new ObjectMapper().convertValue(object, Map.class);
	}

}
