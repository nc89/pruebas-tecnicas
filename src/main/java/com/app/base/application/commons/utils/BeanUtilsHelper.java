package com.app.base.application.commons.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanUtilsHelper {
	private BeanUtilsHelper() {
		throw new UnsupportedOperationException("BeanUtilsHelper :: UnsupportedOperationException.");
	}

	public static void copyNonNullProperties(Object source, Object target, String... ignoreProperties) {
		final Set<String> ignoreSet = new HashSet<>();
		if (ignoreProperties != null && ignoreProperties.length > 0) {
			Collections.addAll(ignoreSet, ignoreProperties);
		}
		final String[] nullProperties = getNullPropertyNames(source);
		Collections.addAll(ignoreSet, nullProperties);
		BeanUtils.copyProperties(source, target, ignoreSet.toArray(new String[0]));
	}

	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
		return Arrays.stream(wrappedSource.getPropertyDescriptors()).map(pd -> pd.getName())
				.filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
	}
}
