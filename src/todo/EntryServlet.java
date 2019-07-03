package todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.EntryForm;
import todo.services.Service;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");





		this.getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String priority = req.getParameter("priority");
		String deadline = req.getParameter("deadline");

		EntryForm form = new EntryForm(title, detail, priority, deadline);

		//バリデーションチェック
		List<String> error = validate(form);

		//エラー時はentry.jspの再表示
		if (error.size() != 0 ) {

			req.setAttribute("error", error);
			req.setAttribute("form",form );
			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
			return;
		}

		//DBにインサート
		Service service = new Service();
		service.insert(form);

		//処理完了後index.htmlへ遷移
		resp.sendRedirect("index.html");

	}

	private List<String> validate(EntryForm form) {

		List<String> e = new ArrayList<>();


		String title = form.getTitle();
		String priority = form.getPriority();
		String deadline = form.getDeadline();

		Pattern p = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2}$");
		Matcher m = p.matcher(deadline);

		//題名未入力チェック
		if (title.equals("")) {
//			error += "題名は必須入力です。";
			e.add("題名は必須入力です。");
		}
		//題名の文字数チェック(100字)
		if (title.length() > 100) {
//			 error += "題名は100文字以内にして下さい。";
			 e.add("題名は100文字以内にして下さい。");
		}
		//重要度チェック
		if (priority.length() > 3 || priority.length() == 0) {
//			 error += "重要度は★～★★★までです。";
			 e.add("重要度は★～★★★までです。");
		}
		if (!priority.equals("★") && (!priority.equals("★★")) && (!priority.equals("★★★"))) {
//			 error += "重要度は★～★★★で表示されます。";
			 e.add("重要度は★～★★★で表示されます。");
		}

		//未入力時はエラー起きない
		if (deadline.equals("")) {
			return e;
		}
		//期限書式チェック
		if (m.find() == false) {
//			error += "期限は「YYYY/MM/DD」形式で入力してください。";
			 e.add("期限は「YYYY/MM/DD」形式で入力してください。");
		}
		return  e;

	}

}
