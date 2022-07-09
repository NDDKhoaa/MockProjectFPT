package fa.mockproject.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Converter {
	
	public static <E, T> List<T> convertList(List<E> list, Function<E, T> convertFunction) {
		if (list == null || convertFunction == null) {
			return new ArrayList<>();
		}
		return (List<T>) list.stream().map(convertFunction).collect(Collectors.toList());
	}
	
	public static <E, T> List<T> convertList(List<E> list, Function<E, T> convertFunction, Predicate<T> filterFunction) {
		if (list == null || convertFunction == null || filterFunction == null) {
			return new ArrayList<>();
		}
		return (List<T>) list.stream().map(convertFunction).filter(filterFunction).collect(Collectors.toList());
	}
}
