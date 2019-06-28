package todo.utils;

public class HTMLUtils {

	public static String format(String deadline) {

		System.out.println(deadline);

		if(deadline == null) {
			return "";
		}

		String format = deadline.replace("-","/");



		return format;






	}



}
