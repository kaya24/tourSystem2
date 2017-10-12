package tsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import tsys.sales.dao.MemberDAO;
import tsys.sales.entity.Member;
import tsys.sales.dao.ConnectionManager;

public class MemberManagerLogic {


	public Member loginMember(String memberCode, String password) throws SalesBusinessException{

		Connection con = null;
		Member member = null;
		try {
			con = ConnectionManager.getConnection();
			MemberDAO mdao = new MemberDAO(con);
			member = mdao.getMember(memberCode, password);
			if(member == null){
				throw new SalesBusinessException();
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return member;
	}
}
