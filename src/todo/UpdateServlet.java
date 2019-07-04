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

import todo.forms.UpdateForm;
import todo.services.Service;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");


		Service service = new Service();
		UpdateForm form = service.upselect(req.getParameter("number"));

		req.setAttribute("form", form);


		this.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");


		String number = req.getParameter("number");
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String priority = req.getParameter("priority");
		String deadline = req.getParameter("deadline");

		UpdateForm form = new UpdateForm(number, title, detail, priority, deadline);

		//バリデーションチェック
		List<String> error = validate(form);

		//エラー時はupdate.jspの再表示
		if (error.size() != 0 ) {

			req.setAttribute("error", error);
			req.setAttribute("form",form );
			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
			return;
		}

		//アップデート
		Service service = new Service();
		service.update(form);

		resp.sendRedirect("index.html");
	}

		private List<String> validate(UpdateForm form) {

			List<String> e = new ArrayList<>();

			String number = form.getNumber();
			String title = form.getTitle();
			String priority = form.getPriority();
			String deadline = form.getDeadline();

			Pattern p = Pattern.compile("^[0-9]{4}/[0-9]{2}/[0-9]{2}$");
			Matcher m = p.matcher(deadline);

			//number入力チェック
			if(number.equals("")) {
				e.add("IDは必須入力です。");
			}
			//題名未入力チェック
			if (title.equals("")) {
				e.add("題名は必須入力です。");
			}
			//題名の文字数チェック(100字)
			if (title.length() > 100) {
				 e.add("題名は100文字以内にして下さい。");
			}
			//重要度チェック
			if (priority.length() > 3 || priority.length() == 0) {
				 e.add("重要度は★～★★★までです。");
			}
			if (!priority.equals("★") && (!priority.equals("★★")) && (!priority.equals("★★★"))) {
				 e.add("重要度は★～★★★で表示されます。");
			}
			//未入力時はエラー起きない
			if (deadline.equals("")) {
				return e;
			}
			//期限書式チェック
			if (m.find() == false) {
				 e.add("期限は「YYYY/MM/DD」形式で入力してください。");
			}
			return  e;

		}



}
