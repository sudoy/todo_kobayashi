package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.forms.IndexForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class Service {

	public List<IndexForm> select() {//データの取り出し

		Connection con = null;
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

			List<IndexForm> list = new ArrayList<>();

			//結果セットの内容を出力
			while (rs.next()) {

				String number = rs.getString("number");
				String title = rs.getString("title");
				String priority = rs.getString("priority");
				String deadline = rs.getString("deadline");

				deadline = HTMLUtils.format(deadline);


				IndexForm index = new IndexForm(number, title, priority, deadline);
				list.add(index);

			}

			return list;


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;

	}


}
