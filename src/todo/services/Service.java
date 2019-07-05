package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import todo.forms.DeleteForm;
import todo.forms.EntryForm;
import todo.forms.IndexForm;
import todo.forms.LoginForm;
import todo.forms.UpdateForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class Service {

	//indexのデータ取得
	public List<IndexForm> inselect() {

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
			rs = ps.executeQuery();

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

	//Updateのデータ取得
	public UpdateForm upselect(String num) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try {
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "select number, title, detail, priority, deadline "
					+ "from todo "
					+ "where number = ? "
					+ "order by number";

			//SELECT命令の準備
			ps = con.prepareStatement(sql);

			ps.setString(1, num);

			//SELECT命令の実行
			rs = ps.executeQuery();

			UpdateForm list = null;

			//結果セットの内容を出力
			rs.next();

			String number = rs.getString("number");
			String title = rs.getString("title");
			String detail = rs.getString("detail");
			String priority = rs.getString("priority");
			String deadline = rs.getString("deadline");

			deadline = HTMLUtils.format(deadline);

			UpdateForm update = new UpdateForm(number, title, detail, priority, deadline);

			list = update;

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

			String deadline = form.getDeadline();

			if (deadline.equals("")) {
				deadline = null;
			}

			//INSERT命令にポストデータの内容をセット
			ps.setString(1, form.getDetail());
			ps.setString(2, form.getTitle());
			ps.setString(3, form.getPriority());
			ps.setString(4, deadline);

			//INSERT命令の実行
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, null);
		}

	}

	//データの更新
	public void update(UpdateForm form) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "update todo set title=?, detail=?, priority=?, deadline=? where number = ?";

			//UPDATE命令の準備
			ps = con.prepareStatement(sql);

			String deadline = form.getDeadline();

			if (deadline.equals("")) {
				deadline = null;
			}

			//UPDATE命令にポストデータの内容をセット
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getDetail());
			ps.setString(3, form.getPriority());
			ps.setString(4, deadline);
			ps.setString(5, form.getNumber());

			//UPDATE命令の実行
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, null);
		}

	}

	//データの削除
	public void delete(DeleteForm form) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "delete from todo where number = ?";

			//DELETE命令の準備
			ps = con.prepareStatement(sql);

			//DELETE命令にポストデータの内容をセット
			ps.setString(1, form.getNumber());

			//DELETEE命令の実行
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, null);
		}

	}
	//データを取得
	public LoginForm loginselect(LoginForm form) {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try {
			//データベース接続
			con = DBUtils.getConnection();

			//SQL
			sql = "select number,name from userinfo where email = ? and pass = ?";

			//SELECT命令の準備
			ps = con.prepareStatement(sql);

			ps.setString(1, form.getEmail());
			ps.setString(2, form.getPassword());

			//SELECT命令の実行
			rs = ps.executeQuery();

			LoginForm loginform = null;

			//結果セットの内容を出力
			rs.next();

				String number = rs.getString("number");
				String name = rs.getString("name");

				LoginForm login = new LoginForm( number, name);

				login = loginform;

				return login ;


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}

}
