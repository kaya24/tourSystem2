package tsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tsys.sales.entity.Member;

public class MemberDAO {

	Connection con;

	/**
	 * @param con
	 */
	public MemberDAO(Connection con) {
		this.con = con;
	}


	public Member getTelMember(String tel) throws SQLException{
		Member member = new Member();

		return member;
	}

	public Member getMember(String memberCode, String password) throws SQLException{
		String sql = "select membercode, name, password, role, mail, zipcode, prefecture, address, tel from member where membercode=? and password=?";

		PreparedStatement stmt = null;
		ResultSet res = null;
		Member member = null;

		try{
			stmt = con.prepareStatement(sql);
			stmt.setString(1, memberCode);
			stmt.setString(2, password);

			res = stmt.executeQuery();

			if(res.next()){
				member = new Member();
				member.setMemberCode(res.getString("membercode"));
				member.setPassword(res.getString("password"));
				member.setMemberName(res.getString("name"));
				member.setRole(res.getString("role"));
				member.setMail(res.getString("mail"));
				member.setZipCode(res.getString("prefecture"));
				member.setAddress(res.getString("address"));
				member.setTel(res.getString("tel"));
			}

		}finally{
			if(res != null){
				res.close();
			}
			if(stmt != null){
				stmt.close();
			}
		}

		return member;
	}
}
