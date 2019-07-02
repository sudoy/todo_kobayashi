package todo;

import java.io.IOException;
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
		String error = validate(form);

		//エラー時はentry.jspの再表示
		if (error.equals("")) {
			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
			return;
		}

		//DBにインサート
		Service service = new Service();
		service.insert(form);

		//処理完了後index.htmlへ遷移
		resp.sendRedirect("index.html");

	}

	private String validate(EntryForm form) {

		String error = "1";

		String title = form.getTitle();
		String priority = form.getPriority();
		String deadline = form.getDeadline();

		Pattern p = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2}$");
		Matcher m = p.matcher(deadline);

		//題名未入力
		if (title.equals("")) {
			return error = "";
		}
		//題名の文字数制限(100字)
		if (title.length() > 100) {
			return error = "";
		}
		//重要度チェック
		if (priority.length() > 3 || priority.length() == 0) {
			return error = "";
		}
		if (!priority.equals("★") && (!priority.equals("★★")) && (!priority.equals("★★★"))) {
			return error = "";
		}

		//期限書式チェック、未入力時はそのまま登録
		if (deadline.equals("")) {
			error = "1";
		} else if (m.find() == false) {
			error = "";
		}
		return error;

	}

}
