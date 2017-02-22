package com.smith.facts.resources;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue.ValueType;

@SuppressWarnings("all")
public class JSONParser {

	private static final Set<Class> WRAPPER_TYPES = new HashSet(Arrays.asList(
			Boolean.class, Character.class, Byte.class, Short.class,
			Integer.class, Long.class, Float.class, Double.class, Void.class,
			String.class));

	private static boolean isWrapperType(Class clazz) throws Exception {
		return WRAPPER_TYPES.contains(clazz);
	}

	private static String toJsonFromList(List list) throws Exception {
		String JSONString = "[";
		for (Object item : list) {
			if (isWrapperType(item.getClass()))
				if (item.getClass().getName().equals("java.lang.String")
						|| item.getClass().getName()
						.equals("java.lang.Character"))
					JSONString += "\"" + item.toString() + "\"";
				else
					JSONString += item.toString();
				else if (item.getClass().getName().equals("java.util.ArrayList")
					|| item.getClass().getName().equals("java.util.List")) {
				JSONString += toJsonFromList((List) item);
			}  else {
				JSONString += toJson(item);
			}
			JSONString += ",";
		}
		JSONString = JSONString.substring(0, JSONString.length() - 1);
		JSONString += "]";
		return JSONString;
	}

	
	public static String toJson(Object obj) throws Exception {
		String JSONString = "{";
		if (obj.getClass().getName().equals("java.util.ArrayList")
				|| obj.getClass().getName().equals("java.util.List"))
			return toJsonFromList((List) obj);
		
	  else {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			for (PropertyDescriptor propertyDesc : beanInfo
					.getPropertyDescriptors()) {
			if (propertyDesc.getReadMethod().invoke(obj) != null
						&& !(propertyDesc.getName().equals("class"))) {
					JSONString += "\"" + propertyDesc.getName() + "\"";
					JSONString += ":";
					if (propertyDesc.getReadMethod().invoke(obj).getClass()
							.toString().contains("bean")) {
						JSONString += toJson(propertyDesc.getReadMethod()
								.invoke(obj));
						JSONString += ",";
					} else if (propertyDesc.getPropertyType().toString()
							.equals("class java.lang.String")
							|| propertyDesc.getPropertyType().toString()
							.equals("class java.lang.Character")) {
						JSONString += "\""
								+ propertyDesc.getReadMethod().invoke(obj)
								+ "\"";
						JSONString += ",";
					} 
				}
			}
			JSONString = JSONString.substring(0, JSONString.length() - 1);
		}
		JSONString += "}";
		return JSONString;
	}

}