package todo.utils;

public class HTMLUtils {

	public static String format(String deadline) {

		if(deadline == null) {
			return "";
		}

		String format = deadline.replace("-","/");

		return format;






	}



}
