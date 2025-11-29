package com.app.base.application.commons.typeadapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public JsonElement serialize(LocalDate localDateTime, Type srcType, JsonSerializationContext context) {

		return new JsonPrimitive(formatter.format(localDateTime));
	}

	@Override
	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			return LocalDate.parse(json.getAsString(), formatter);
		} catch (DateTimeParseException e) {
			throw new JsonParseException("Error al deserializar la fecha: " + json.getAsString(), e);
		}
	}
}
