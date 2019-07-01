package todo;

import java.io.IOException;

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


		//DBにインサート
		Service service = new Service();
		service.insert(form);


		//処理完了後index.htmｌへ遷移
		resp.sendRedirect("index.html");

	}

}
