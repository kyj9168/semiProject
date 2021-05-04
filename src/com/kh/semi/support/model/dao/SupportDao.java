package com.kh.semi.support.model.dao;

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

import com.kh.semi.support.money.model.vo.MoneySup;
import com.kh.semi.support.product.model.vo.ProductSup;

public class SupportDao {

	private Properties prop = new Properties();

	public SupportDao() {
		String fileName =
				SupportDao.class.getResource("/sql/support/Support-qeury.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public ArrayList<MoneySup> selectAllMoneySupport(Connection con, int userNo, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MoneySup> moneyList = null;

		String query = prop.getProperty("selectAllMoneySupport");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			moneyList = new ArrayList<MoneySup>();

			while(rset.next()) {
				MoneySup ms = new MoneySup();
				ms.setSupAppNo(rset.getInt("SUP_APP_NO"));
				ms.setSupPc(rset.getInt("SUP_PC"));
				ms.setSupDt(rset.getDate("SUP_DT"));
				ms.setSupKind(rset.getString("SUP_KIND"));
				ms.setStatus(rset.getString("STATUS"));

				moneyList.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return moneyList;

	}

	public ArrayList<ProductSup> selectAllProduntSupport(Connection con, int userNo, int currentPage2, int limit2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductSup> productList = null;

		String query = prop.getProperty("selectAllProduntSupport");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage2 - 1) * limit2 + 1;
			int endRow = startRow + limit2 - 1;
			System.out.println("시작값 : "  + startRow);
			System.out.println("끝값 : " + endRow);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			productList = new ArrayList<ProductSup>();

			while(rset.next()) {
				ProductSup ps = new ProductSup();
				ps.setSupPdNo(rset.getInt("SUP_PD_NO"));
				ps.setCtgCd(rset.getString("CTG_CD"));
				ps.setPdNm(rset.getString("PD_NM"));
				ps.setSupDt(rset.getDate("SUP_DT"));
				ps.setUserNo(rset.getInt("USER_NO"));
				ps.setStatus(rset.getString("STATUS"));

				productList.add(ps);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public int getSupportMoneyAllListCount(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getSupportAllListCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}


		return listCount;
	}



	public int getSupportProductAllListCount(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		int listCount2 = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getSupportProductAllListCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount2 = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}


		return listCount2;
	}



	public int getSupportMoneyAllUserListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;

		String query = prop.getProperty("getSupportAllUserListCount");

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



	public int getSupportProductAllUserListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount2 = 0;

		String query = prop.getProperty("getSupportProductAllUSerListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount2 = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount2;
	}



	public ArrayList<MoneySup> selectAllUserMoneySupport(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MoneySup> moneyList = null;

		String query = prop.getProperty("selectAllUserMoneySupport");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			moneyList = new ArrayList<MoneySup>();

			while(rset.next()) {
				MoneySup ms = new MoneySup();
				ms.setSupAppNo(rset.getInt("SUP_APP_NO"));
				ms.setSupPc(rset.getInt("SUP_PC"));
				ms.setSupDt(rset.getDate("SUP_DT"));
				ms.setSupKind(rset.getString("SUP_KIND"));
				ms.setStatus(rset.getString("STATUS"));
				ms.setUserNo(rset.getInt("USER_NO"));
				ms.setUserNm(rset.getString("USER_NM"));
				ms.setNickNm(rset.getString("NICK_NM"));

				moneyList.add(ms);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return moneyList;
	}



	public ArrayList<ProductSup> selectAllUserProduntSupport(Connection con, int currentPage2, int limit2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductSup> productList = null;

		String query = prop.getProperty("selectAllUserProduntSupport");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage2 - 1) * limit2 + 1;
			int endRow = startRow + limit2 - 1;
			System.out.println("시작값 : "  + startRow);
			System.out.println("끝값 : " + endRow);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			productList = new ArrayList<ProductSup>();

			while(rset.next()) {
				ProductSup ps = new ProductSup();
				ps.setSupPdNo(rset.getInt("SUP_PD_NO"));
				ps.setCtgCd(rset.getString("CTG_CD"));
				ps.setPdNm(rset.getString("PD_NM"));
				ps.setSupDt(rset.getDate("SUP_DT"));
				ps.setUserNo(rset.getInt("USER_NO"));
				ps.setStatus(rset.getString("STATUS"));
				ps.setUserNm(rset.getString("USER_NM"));
				ps.setNickNm(rset.getString("NICK_NM"));

				productList.add(ps);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}



	public String selectUserBillingKey(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String billingkey = null;

		String query = prop.getProperty("selectUserBillingKey");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				billingkey = rset.getString("BILL_KEY");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return billingkey;
	}



	public String selectUserOrderId(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String order_id = null;

		String query = prop.getProperty("selectUserOrderId");

		System.out.println("내역번호 : " + monSupNo);

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				order_id = rset.getString("ORDER_ID");
				System.out.println("dao order_id : " + order_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return order_id;
	}



	public int updateReceipt_id(Connection con, String receipt_id, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateReceipt_id");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, receipt_id);
			pstmt.setInt(2, monSupNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}



	public String selectUserEmail(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String email = null;

		String query = prop.getProperty("selectUserEmail");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				email = rset.getString("EMAIL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return email;
	}



	public String selectUserSupportDay(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String supportDay = null;

		String query = prop.getProperty("selectUserSupportDay");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				supportDay = rset.getString("SUP_DT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return supportDay;
	}

}
