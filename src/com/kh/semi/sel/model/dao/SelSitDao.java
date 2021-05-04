package com.kh.semi.sel.model.dao;

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

import com.kh.semi.sel.model.vo.SelSit;

public class SelSitDao {
	private Properties prop = new Properties();

	public SelSitDao() {
		String fileName =
				SelSitDao.class.getResource("/sql/selsit/selsit-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> selectSelDayforDate(Connection con, String result) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<String>();

		String query = prop.getProperty("selectSelDayforDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, result);

			rset = pstmt.executeQuery();


			while(rset.next()) {
				String day = rset.getString("SEL_DT");

				list.add(day);
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

	public ArrayList<String> selectSelDayforDatePco(Connection con, String result) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<String>();

		String query = prop.getProperty("selectSelDayforDatePco");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, result);

			rset = pstmt.executeQuery();


			while(rset.next()) {
				String day = rset.getString("SEL_DT");

				list.add(day);
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

	public ArrayList<SelSit> selectAllSelEntranceDate(Connection con, String result) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SelSit> list = null;

		String query = prop.getProperty("selectAllSelEntranceDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, result);
			rset = pstmt.executeQuery();

			list = new ArrayList<SelSit>();
			while(rset.next()) {
				SelSit ss = new SelSit();
				ss.setDay(rset.getString("SEL_DT"));
				ss.setEntAppNo(rset.getInt("ENT_APP_NO"));
				ss.setAppDiv(rset.getString("APP_DIV"));
				ss.setUserNo(rset.getInt("USER_NO"));
				ss.setUserNm(rset.getString("USER_NM"));
				ss.setSelSit(rset.getString("SEL_SIT"));
				ss.setSelNo(rset.getString("SEL_NO"));

				list.add(ss);
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

	public ArrayList<SelSit> selectAllSelParceloutDate(Connection con, String result) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SelSit> list = null;

		String query = prop.getProperty("selectAllSelParceloutDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, result);
			rset = pstmt.executeQuery();

			list = new ArrayList<SelSit>();
			while(rset.next()) {
				SelSit ss = new SelSit();
				ss.setDay(rset.getString("SEL_DT"));
				ss.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				ss.setAppDiv(rset.getString("APP_DIV"));
				ss.setUserNo(rset.getInt("USER_NO"));
				ss.setUserNm(rset.getString("USER_NM"));
				ss.setSelSit(rset.getString("SEL_SIT"));
				ss.setSelNo(rset.getString("SEL_NO"));

				list.add(ss);
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

	public ArrayList<SelSit> selectTodaySelEntranceHistory(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<SelSit> list = new ArrayList<SelSit>();

		String query = prop.getProperty("selectTodaySelEntranceHistory");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);
			while(rset.next()) {
				SelSit ss = new SelSit();
				ss.setDay(rset.getString("SEL_DT"));
				ss.setEntAppNo(rset.getInt("ENT_APP_NO"));
				ss.setAppDiv(rset.getString("APP_DIV"));
				ss.setUserNo(rset.getInt("USER_NO"));
				ss.setUserNm(rset.getString("USER_NM"));
				ss.setSelSit(rset.getString("SEL_SIT"));
				ss.setSelNo(rset.getString("SEL_NO"));

				list.add(ss);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public ArrayList<SelSit> selectTodaySelParcelHistory(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<SelSit> list = new ArrayList<SelSit>();

		String query = prop.getProperty("selectTodaySelParcelHistory");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);
			while(rset.next()) {
				SelSit ss = new SelSit();
				ss.setDay(rset.getString("SEL_DT"));
				ss.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				ss.setAppDiv(rset.getString("APP_DIV"));
				ss.setUserNo(rset.getInt("USER_NO"));
				ss.setUserNm(rset.getString("USER_NM"));
				ss.setSelSit(rset.getString("SEL_SIT"));
				ss.setSelNo(rset.getString("SEL_NO"));

				list.add(ss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int updateSelSitPco(Connection con, String selNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateSelSitPco");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상담완료");
			pstmt.setString(2, selNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectPcoNo(Connection con, String selNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectPcoNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, selNo);

			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("PCO_APP_NO");
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

	public int updateAppSitPco(Connection con, int num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateAppSitPco");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num2);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int updateSelSitPco2(Connection con, String selNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateSelSitPco2");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상담취소");
			pstmt.setString(2, selNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateEntSelSit(Connection con, String selNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateEntSelSit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상담완료");
			pstmt.setString(2, selNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectEntNo(Connection con, String selNoString) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectEntNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, selNoString);

			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("ENT_APP_NO");
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

	public int updateEntApplySit(Connection con, int num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateEntApplySit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num2);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateEntDogInfoSit(Connection con, int num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateEntDogInfoSit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "분양대기");
			pstmt.setInt(2, num2);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}

	public int updateEntSelSitNo(Connection con, String selNoString) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateEntSelSitNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상담취소");
			pstmt.setString(2, selNoString);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateEntApplySitNo(Connection con, int num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateEntApplySitNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상담취소로 인한 입소반려");
			pstmt.setInt(2, num2);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateEntDogInfoSitNo(Connection con, int num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateEntDogInfoSit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "입소반려");
			pstmt.setInt(2, num2);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}

	public int updateAppSitPcoNo(Connection con, int num2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateAppSitPcoNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "상담취소로 인한 분양반려");
			pstmt.setInt(2, num2);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
