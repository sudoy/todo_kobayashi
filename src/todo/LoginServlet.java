package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String password = req.getParameter("password");






		resp.sendRedirect("index.html");


	}


}

/*	private List<String> check(LoginForm form) {

		List<String> e = new ArrayList<>();

		String email = form.getEmail();
		String password = form.getPassword();


		//メールアドレスチェック


		//パスワードチェック


		return  e;

		//DBからデータ取り出し
		LoginService service = new LoginService();
		LoginForm form = service.loginselect(email);


		if(email.equals(form.getEmail())) {

		}

		if(password.equals(form.getPassword())) {
			resp.sendRedirect("index.html");
			return;
		}

*/
