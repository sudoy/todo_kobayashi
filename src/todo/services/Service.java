package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.forms.EntryForm;
import todo.forms.IndexForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class Service {

	//データの取り出し
	public List<IndexForm> select() {

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

	//入力したデータのインサート
	public void insert(EntryForm form) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;


		try {
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "insert into todo (detail, title, priority, deadline) values (?,?,?,?)";

			//INSERT命令の準備
			ps = con.prepareStatement(sql);

			//INERT命令にポストデータの内容をセット
			ps.setString(1, form.getDetail());
			ps.setString(2, form.getTitle());
			ps.setString(3, form.getPriority());
			ps.setString(4, form.getDeadline());

			System.out.println(ps);

			//INSERT命令の実行
			ps.executeUpdate();

//		System.out.println(form.getNumber());

		System.out.println(ps);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, null);
		}

	}


}
