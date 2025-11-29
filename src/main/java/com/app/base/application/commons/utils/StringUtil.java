package com.app.base.application.commons.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.app.base.domain.model.EnumValueModel;

public class StringUtil {

	private StringUtil() {
		throw new UnsupportedOperationException("Esta es una clase utilitaria y no debe ser instanciada.");
	}

	/**
	 * Appends a suffix to a string, ensuring that the total length does not exceed
	 * the specified maximum length and truncating the original string if necessary.
	 * 
	 * @param originalString The original string to which the suffix will be
	 *                       appended.
	 * @param suffix         The suffix to append to the original string.
	 * @param maxLength      The maximum allowed length of the resulting string.
	 * @return The original string with the suffix appended, truncated if necessary
	 *         to fit within the maximum length.
	 * @throws IllegalArgumentException if the original string or suffix is null, or
	 *                                  if the maximum length is less than the
	 *                                  length of the suffix.
	 */
	public static String appendSuffixWithMaxLength(String originalString, String suffix, int maxLength) {
		if (originalString == null || suffix == null) {
			throw new IllegalArgumentException("La cadena original y el sufijo no pueden ser nulos.");
		}

		int availableLength = maxLength - suffix.length();

		if (availableLength < 0) {
			throw new IllegalArgumentException("La longitud máxima es menor que la longitud del sufijo.");
		}

		String adjustedString = originalString.length() > availableLength ? originalString.substring(0, availableLength)
				: originalString;

		return adjustedString + suffix;
	}
	
	/**
	 * Validates and adjusts the draw name format based on the provided copy text
	 * and maximum length.
	 * 
	 * @param drawNameFormat The format of the draw name, which may contain a
	 * placeholder for text.
	 * @param copyText The text to replace the placeholder in the draw name format.
	 * @param maxLength The maximum allowed length for the draw name.
	 * @return The adjusted draw name format, which replaces the placeholder with the
	 * copy text, or simply appends the copy text if no placeholder is found.
	 * @throws IllegalArgumentException if the draw name format is null or empty.
	 * If the resulting draw name exceeds the maximum length, it will be replaced with
	 * the copy text.
	 */
	public static String validateAndAdjustDrawNameFormat(String drawNameFormat, String copyText, int maxLength) {
		
		final Pattern TEXT_PATTERN = Pattern.compile("T\\(\"([^\"]*)\"\\)");
		
		if (drawNameFormat == null || drawNameFormat.trim().isEmpty()) {
			throw new IllegalArgumentException("El drawNameFormat no puede ser nulo o vacío.");
		}

		Matcher textMatcher = TEXT_PATTERN.matcher(drawNameFormat);
		if (textMatcher.find()) {
			drawNameFormat = textMatcher.replaceFirst(copyText);
		} else {
			drawNameFormat += copyText;
		}

		if (drawNameFormat.length() > maxLength) {
			drawNameFormat = copyText;
		}

		return drawNameFormat;
	}

	/**
	 * Converts an enum class to a list of EnumValueModel objects.
	 * Each EnumValueModel contains the ordinal value (starting from 1) and the name
	 * of the enum constant.
	 *
	 * @param enumClass The enum class to convert.
	 * @param <E>       The type of the enum.
	 * @return A list of EnumValueModel objects representing the enum constants.
	 */
	public static <E extends Enum<E>> List<EnumValueModel> enumToValueModelList(Class<E> enumClass) {
		E[] values = enumClass.getEnumConstants();
		return IntStream.range(0, values.length)
				.mapToObj(i -> new EnumValueModel(i + 1, values[i].name()))
				.toList();
	}

}
