package com.kh.semi.support.money.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.adminboard.model.dao.AdminBoardDao;
import com.kh.semi.support.money.model.vo.MoneySup;

public class MoneySupDao {

	private Properties prop = new Properties();

	public MoneySupDao() {
		String fileName =
				AdminBoardDao.class.getResource("/sql/support/MoneySup-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMoneySupApp(Connection con, MoneySup ms) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMoneySupApp");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, ms.getUserNo());
			pstmt.setInt(2, ms.getSupPc());
			pstmt.setString(3, ms.getSupKind());
			pstmt.setString(4, ms.getStatus());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectListCount");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}



		return listCount;
	}

	public ArrayList<MoneySup> selectList(Connection con, int currentPage, int limit, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MoneySup> list = null;

		String query = prop.getProperty("selectListWithSupportPageing");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<MoneySup>();

			while(rset.next()) {
				MoneySup ms = new MoneySup();
				ms.setUserNo(rset.getInt("USER_NO"));
				ms.setUserNm(rset.getString("USER_NM"));
				ms.setNickNm(rset.getString("NICK_NM"));
				ms.setSupAppNo(rset.getInt("SUP_APP_NO"));
				ms.setSupPc(rset.getInt("SUP_PC"));
				ms.setRegSupDate(rset.getString("REG_SUP_DATE"));
				ms.setSupKind(rset.getString("SUP_KIND"));
				ms.setStatus(rset.getString("STATUS"));

				list.add(ms);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int okApplyMoney(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okApplyMoney");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int okConfirmMoney(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okConfirmMoney");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int cancleSupportMoney(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("cancleSupportMoney");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int okCancleSupport(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okCancleSupport");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertMoney(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertMoney");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateCancelResult(Connection con, int monSupNo, String selectCancle) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCancelResult");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, selectCancle);
			pstmt.setInt(2, monSupNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return result;
	}

	public int updateBillingkey(Connection con, int monSupNo, String billing, String order_id) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateBillingkey");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, billing);
			pstmt.setString(2, order_id);
			pstmt.setInt(3, monSupNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public String selectSupportCancleReason(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = "";

		String query = prop.getProperty("selectSupportCancleReason");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getString("CANCLE_RS");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int selectSupportPrice(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int price = 0;

		String query = prop.getProperty("selectSupportPrice");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				price = rset.getInt("SUP_PC");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return price;
	}

}
