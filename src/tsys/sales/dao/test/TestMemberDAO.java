package tsys.sales.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import tsys.sales.dao.ConnectionManager;
import tsys.sales.dao.MemberDAO;
import tsys.sales.entity.Member;

public class TestMemberDAO {

	public static void main(String[] args) {

		Connection con = null;

		try{
			con = ConnectionManager.getConnection();
			MemberDAO mdao = new MemberDAO(con);
			Member member = null;
			String memberCode = "CM0001";
			String password = "pass";
			member = mdao.getMember(memberCode,password);

			if(member == null){
				System.out.println("メンバーコードとパスワードが一致していません");
			}else{
				System.out.println("memberCode : " + member.getMemberCode());
				System.out.println("memberName : " + member.getMemberName());
				System.out.println("password : " + member.getPassword());
				System.out.println("role :" + member.getRole());
				System.out.println("role :" + member.getMail());
				System.out.println("role :" + member.getPrefecture());
				System.out.println("role :" + member.getAddress());
				System.out.println("role :" + member.getTel());
				System.out.println("-----------------------------");
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

	}

}
