package com.app.base.infrastructure.adapters.out.persistence.commons;

import lombok.experimental.UtilityClass;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;

@UtilityClass
public class BaseSpecification {

	public <V, T> void addEqualIfNotNull(CriteriaBuilder cb, Root<T> root, List<Predicate> predicates, String field,
			V value) {
		if (value != null) {
			predicates.add(cb.equal(root.get(field), value));
		}
	}

	public <V> void addEqualIfNotNull(CriteriaBuilder cb, Path<?> path, List<Predicate> predicates, String field,
			V value) {
		if (value != null) {
			predicates.add(cb.equal(path.get(field), value));
		}
	}

	public <T> void addLikeIfNotNull(CriteriaBuilder cb, Root<T> root, List<Predicate> predicates, String field,
			String value) {
		if (value != null) {
			predicates.add(cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%"));
		}
	}

	public <T> void addLikeIfNotBlank(CriteriaBuilder cb, Path<T> path, List<Predicate> predicates, String field,
			String value) {
		if (value != null && !value.isBlank()) {
			predicates.add(cb.like(cb.lower(path.get(field)), "%" + value.toLowerCase() + "%"));
		}
	}
	
	public <T> void addEqualIgnoreCaseIfNotBlank(CriteriaBuilder cb, Path<T> path, List<Predicate> predicates, String field, 
			String value) {
	    if (value != null && !value.isBlank()) {
	        predicates.add(cb.equal(cb.lower(path.get(field)), value.toLowerCase()));
	    }
	}
	
	public <T> void addEqualIfNotNull(CriteriaBuilder cb, Path<T> path, List<Predicate> predicates, T value) {
		if (value != null) {
			predicates.add(cb.equal(path, value));
		}
	}
	
	public <V extends Comparable<? super V>, T> void addGreaterThanOrEqualIfNotNull(
	        CriteriaBuilder cb, Root<T> root, List<Predicate> predicates, String field, V value) {
	    if (value != null) {
	        predicates.add(cb.greaterThanOrEqualTo(root.get(field), value));
	    }
	}
	
	public <V extends Comparable<? super V>, T> void addLessThanOrEqualIfNotNull(
	        CriteriaBuilder cb, Root<T> root, List<Predicate> predicates, String field, V value) {
	    if (value != null) {
	        predicates.add(cb.lessThanOrEqualTo(root.get(field), value));
	    }
	}
	
	public <V> void addNotEqualIfNotNull(CriteriaBuilder cb, Path<?> path, List<Predicate> predicates, String field, V value) {
	    if (value != null) {
	        predicates.add(cb.notEqual(path.get(field), value));
	    }
	}
}
