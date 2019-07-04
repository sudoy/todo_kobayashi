package todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.DeleteForm;
import todo.services.Service;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");



		String number = req.getParameter("number");

		DeleteForm form = new DeleteForm(number);

		//バリデーションチェック
		List<String> error = validate(form);

		//エラー時はindex.jspの再表示
		if (error.size() != 0 ) {

			req.setAttribute("error", error);
			req.setAttribute("form",form );
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
			return;
		}

		//デリート
		Service service = new Service();
		service.delete(form);

		resp.sendRedirect("index.html");
	}

		private List<String> validate(DeleteForm form) {

			List<String> e = new ArrayList<>();

			String number = form.getNumber();


			//number入力チェック
			if(number.equals("")) {
				e.add("IDは必須入力です。");
			}
			return  e;

		}


}
