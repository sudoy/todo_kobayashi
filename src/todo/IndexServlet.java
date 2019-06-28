package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.utils.DBUtils;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try {
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "select number, title, detail, priority, deadline "
					+ "from todo"
					+ "order by number";

			//SELECT命令の準備
			ps = con.prepareStatement(sql);

			//SELECT命令の実行
			rs = ps.executeQuery(sql);

			List<String> numberlist = new ArrayList<>();
			List<String> titlelist = new ArrayList<>();
			List<String> detaillist = new ArrayList<>();
			List<String> prioritylist = new ArrayList<>();
			List<String> deadlinelist = new ArrayList<>();

			//結果セットの内容を出力
			while (rs.next()) {

				String number = rs.getString("number");
				String title = rs.getString("title");
				String detail = rs.getString("detail");
				String priority = rs.getString("priority");
				String deadline = rs.getString("deadline");

				numberlist.add(number);
				titlelist.add(title);
				detaillist.add(detail);
				prioritylist.add(priority);
				deadlinelist.add(deadline);

			}

			req.setAttribute("number",numberlist);
			req.setAttribute("title",titlelist);
			req.setAttribute("detail",detaillist);
			req.setAttribute("priority",prioritylist);
			req.setAttribute("deadline",deadlinelist);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

}
