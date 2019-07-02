package todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.IndexForm;
import todo.services.Service;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");


		Service service = new Service();
		List <IndexForm> form = service.select();


		req.setAttribute("form", form);


		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");




		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

	}

}

/*		Connection con = null;
PreparedStatement ps = null;
String sql = null;
ResultSet rs = null;

try {
	//データベース接続
	con = DBUtils.getConnection();

	//SQL
	sql = "select number, title, priority, deadline "
			+ "from todo "
			+ "order by number";

	//SELECT命令の準備
	ps = con.prepareStatement(sql);


	//SELECT命令の実行
	rs = ps.executeQuery(sql);

	List<String> numberlist = new ArrayList<>();
	List<String> titlelist = new ArrayList<>();
	List<String> prioritylist = new ArrayList<>();
	List<String> deadlinelist = new ArrayList<>();

	//結果セットの内容を出力
	while (rs.next()) {

		String number = rs.getString("number");
		String title = rs.getString("title");
		String priority = rs.getString("priority");
		String deadline = rs.getString("deadline");


		numberlist.add(number);
		titlelist.add(title);
		prioritylist.add(priority);
		deadlinelist.add(deadline);

	}

	req.setAttribute("number",numberlist);
	req.setAttribute("title",titlelist);
	req.setAttribute("priority",prioritylist);
	req.setAttribute("deadline",deadlinelist);


} catch (Exception e) {
	e.printStackTrace();
} finally {
	DBUtils.close(con, ps, rs);
}
*/
