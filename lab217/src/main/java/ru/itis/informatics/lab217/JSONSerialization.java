package ru.itis.informatics.lab217;

import ru.itis.informatics.lab217.data.Certificate;
import ru.itis.informatics.lab217.data.Student;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class JSONSerialization {
	public static String serialize(Object object) {
		StringBuilder json = new StringBuilder();
		json.append("{");

		Field[] fields = object.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.setAccessible(true);
			String name = getFieldName(field);
			Object value;
			try {
				value = field.get(object);
			} catch (IllegalAccessException e) {
				value = null;
			}

			json.append("\"").append(name).append("\":");

			if (value == null) {
				json.append("null");
			} else if (value instanceof String) {
				json.append("\"").append(value).append("\"");
			} else if (value.getClass().isArray()) {
				json.append(serializeArray(value));
			} else if (value instanceof List) {
				json.append(serializeList((List<?>) value));
			} else {
				json.append(serialize(value));
			}

			if (i < fields.length - 1) {
				json.append(",");
			}
		}
		json.append("}");
		return json.toString();
	}

	private static String getFieldName(Field field) {
		JSONField jsonField = field.getAnnotation(JSONField.class);

		if (jsonField != null && !jsonField.value().isBlank() && !jsonField.value().isEmpty()) {
			return jsonField.value();
		}

		return field.getName();
	}

	private static String serializeArray(Object array) {
		StringBuilder json = new StringBuilder();
		json.append("[");

		int length = java.lang.reflect.Array.getLength(array);
		for (int i = 0; i < length; i++) {
			Object element = java.lang.reflect.Array.get(array, i);

			if (element == null) {
				json.append("null");
			} else if (element instanceof String) {
				json.append("\"").append(element).append("\"");
			} else if (element.getClass().isArray()) {
				json.append(serializeArray(element));
			} else if (element instanceof List) {
				json.append(serializeList((List<?>) element));
			} else {
				json.append(element);
			}

			if (i < length - 1) {
				json.append(",");
			}
		}

		json.append("]");
		return json.toString();
	}

	private static String serializeList(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");

		for (int i = 0; i < list.size(); i++) {
			Object element = list.get(i);

			if (element == null) {
				json.append("null");
			} else if (element instanceof String) {
				json.append("\"").append(element).append("\"");
			} else if (element.getClass().isArray()) {
				json.append(serializeArray(element));
			} else if (element instanceof List) {
				json.append(serializeList((List<?>) element));
			} else {
				json.append(serialize(element));
			}

			if (i < list.size() - 1) {
				json.append(",");
			}
		}

		json.append("]");
		return json.toString();
	}

	public static void main(String[] args) {
		Certificate certificate = new Certificate("2022", "2026");
		Student student = new Student(
						"Bagat",
						"Bagatov",
						"11-205",
						certificate,
						List.of("Linear Algebra / Analytical Geometry", "Discrete Math", "Mathematical Analysis", "Computer Science", "Algorithms and Data Structures"),
						new int[]{100, 100, 100, 100, 100}
//						new String[]{"Linear Algebra / Analytical Geometry", "Discrete Math", "Mathematical Analysis", "Computer Science", "Algorithms and Data Structures"}
		);

		String json = serialize(student);
		System.out.println(json);
	}
}


