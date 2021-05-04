package com.kh.semi.entrance.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.entrance.model.vo.Entrance;
import com.kh.semi.entrance.model.vo.EntranceDogInfo;
import com.kh.semi.parcelout.model.vo.ParcelOut;
import com.kh.semi.parcelout.model.vo.ParcelOutResult;
import com.kh.semi.support.money.model.vo.MoneySup;
import com.kh.semi.user.model.vo.User;

public class EntranceDao {
	private Properties prop = new Properties();

	public EntranceDao() {
		String fileName =
				EntranceDao.class.getResource("/sql/entrance/entrance-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertEntranceApp(Connection con, Entrance et) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertEntranceApp");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, et.getUserNo());
			pstmt.setString(2, et.getSelHopeDt());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectEntranceAppCurr(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectEntranceAppCurr");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	public int insertEntranceDogInfo(Connection con, EntranceDogInfo dogInfo, int appCurrval) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertEntranceDogInfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dogInfo.getDogNm());
			pstmt.setString(2, dogInfo.getDogAge());
			pstmt.setString(3, dogInfo.getDogGender());
			pstmt.setString(4, dogInfo.getDogKind());
			pstmt.setInt(5, dogInfo.getDogWeight());
			pstmt.setInt(6, dogInfo.getDogHeight());
			pstmt.setString(7, dogInfo.getInoYn());
			pstmt.setString(8, dogInfo.getDisYn());
			pstmt.setString(9, dogInfo.getOperYn());
			pstmt.setString(10, dogInfo.getAllegy());
			pstmt.setString(11, dogInfo.getDogHobby());
			pstmt.setString(12, dogInfo.getDogBark());
			pstmt.setString(13, dogInfo.getDogBowel());
			pstmt.setString(14, dogInfo.getDogAct());
			pstmt.setString(15, dogInfo.getSeperate());
			pstmt.setString(16, dogInfo.getFurColor());
			pstmt.setString(17, dogInfo.getObYn());
			pstmt.setString(18, dogInfo.getRegYn());
			pstmt.setString(19, dogInfo.getDogChar());
			pstmt.setInt(20, appCurrval);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectEntranceDogInfoCurr(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectEntranceDogInfoCurr");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return result;
	}

	public int insertEntranceDogDetail(Connection con, EntranceDogInfo dogInfo, int dogCurrval) {
		PreparedStatement pstmt = null;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int result = 0;

		if(dogInfo.getT1() != null) {
			for(int i = 0; i < dogInfo.getT1().length; i++) {
				String query = prop.getProperty("insertEntranceDogDetailIno");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, dogCurrval);
					pstmt.setString(2, dogInfo.getT1()[i]);

					num1 = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(num1 > 0) {
				result += 1;
			}
		}

		if(dogInfo.getTt1() != null) {
			for(int i = 0; i < dogInfo.getTt1().length; i++) {
				String query = prop.getProperty("insertEntranceDogDetailDis");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, dogInfo.getTt1()[i]);
					pstmt.setInt(2, dogCurrval);

					num2 = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(num2 > 0) {
				result += 1;
			}
		}

		if(dogInfo.getTtt1() != null) {
			for(int i = 0; i < dogInfo.getTtt1().length; i++) {
				String query = prop.getProperty("insertEntranceDogDetailOper");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, dogInfo.getTtt1()[i]);
					pstmt.setInt(2, dogCurrval);

					num3 = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(num3 > 0) {
				result += 1;
			}
		}

		return result;
	}

	public int getMyEntranceAllListCount(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getMyEntranceAllListCount");

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

	public int getMyParceloutAllListCount(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		int listCount2 = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getMyParceloutAllListCount");

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

	public ArrayList<Entrance> selectAllentranceApply(Connection con, int userNo, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Entrance> entranceList = null;

		String query = prop.getProperty("selectAllentranceApply");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			entranceList = new ArrayList<Entrance>();

			while(rset.next()) {
				Entrance et = new Entrance();
				et.setEntAppNo(rset.getInt("ENT_APP_NO"));
				et.setUserNo(rset.getInt("USER_NO"));
				et.setWriteDt(rset.getDate("WRITE_DT"));
				et.setSelHopeDt(rset.getString("SEL_HOPE_DT"));
				et.setAppSit(rset.getString("APP_SIT"));
				et.setCompanionRs(rset.getString("COMPANION_RS"));

				entranceList.add(et);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entranceList;
	}

	public ArrayList<ParcelOut> selectAllparceloutApply(Connection con, int userNo, int currentPage2, int limit2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ParcelOut> parcleList = null;

		String query = prop.getProperty("selectAllparceloutApply");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage2 - 1) * limit2 + 1;
			int endRow = startRow + limit2 - 1;
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			parcleList = new ArrayList<ParcelOut>();

			while(rset.next()) {
				ParcelOut po = new ParcelOut();
				po.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				po.setUserNo(rset.getInt("USER_NO"));
				po.setAnsDt(rset.getDate("ANS_DT"));
				po.setSelAppDt(rset.getString("SEL_APP_DT"));
				po.setPcoSit(rset.getString("PCO_SIT"));
				po.setCompanionRs(rset.getString("COMPANION_RS"));

				parcleList.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parcleList;
	}

	public int getMyEntranceAllUserListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getMyEntranceAllUserListCount");

		try {
			pstmt = con.prepareStatement(query);

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

	public int getMyParceloutAllUserListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getMyParceloutAllUserListCount");

		try {
			pstmt = con.prepareStatement(query);

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

	public ArrayList<Entrance> selectAllUserEntranceApply(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Entrance> entranceList = null;

		String query = prop.getProperty("selectAllUserEntranceApply");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			entranceList = new ArrayList<Entrance>();

			while(rset.next()) {
				Entrance et = new Entrance();
				et.setEntAppNo(rset.getInt("ENT_APP_NO"));
				et.setUserNo(rset.getInt("USER_NO"));
				et.setUserNm(rset.getString("USER_NM"));
				et.setWriteDt(rset.getDate("WRITE_DT"));
				et.setSelHopeDt(rset.getString("SEL_HOPE_DT"));
				et.setAppSit(rset.getString("APP_SIT"));

				entranceList.add(et);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return entranceList;
	}

	public ArrayList<ParcelOut> selectAllUserParceloutApply(Connection con, int currentPage2, int limit2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ParcelOut> parcleList = null;

		String query = prop.getProperty("selectAllUserParceloutApply");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage2 - 1) * limit2 + 1;
			int endRow = startRow + limit2 - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			parcleList = new ArrayList<ParcelOut>();

			while(rset.next()) {
				ParcelOut po = new ParcelOut();
				po.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				po.setUserNo(rset.getInt("USER_NO"));
				po.setUserNm(rset.getString("USER_NM"));
				po.setAnsDt(rset.getDate("ANS_DT"));
				po.setSelAppDt(rset.getString("SEL_APP_DT"));
				po.setPcoSit(rset.getString("PCO_SIT"));

				parcleList.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		System.out.println("dao 분양 : " + parcleList);

		return parcleList;
	}

	public int okEntranceApply(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okEntranceApply");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int noEntranceApply(Connection con, int entAppNo, String reason) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("noEntranceApply");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reason);
			pstmt.setInt(2, entAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int okEntrance(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okEntrance");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int noEntrance(Connection con, int entAppNo, String reason) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("noEntrance");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reason);
			pstmt.setInt(2, entAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public EntranceDogInfo selectDogInfo(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EntranceDogInfo dogInfo = null;

		String query = prop.getProperty("selectDogInfo");

		try {
			pstmt = con.prepareStatement(query);;
			pstmt.setInt(1, entAppNo);

			rset = pstmt.executeQuery();
			if(rset.next()) {
				dogInfo = new EntranceDogInfo();
				dogInfo.setDogNm(rset.getString("DOG_NM"));
				dogInfo.setDogAge(rset.getString("DOG_AGE"));
				dogInfo.setDogGender(rset.getString("DOG_GENDER"));
				dogInfo.setDogKind(rset.getString("DOG_KIND"));
				dogInfo.setDogWeight(rset.getInt("DOG_WEIGHT"));
				dogInfo.setDogHeight(rset.getInt("DOG_HEIGHT"));
				dogInfo.setInoYn(rset.getString("INO_YN"));
				dogInfo.setDisYn(rset.getString("DIS_YN"));
				dogInfo.setOperYn(rset.getString("OPER_YN"));
				dogInfo.setAllegy(rset.getString("ALLEGY"));
				dogInfo.setDogHobby(rset.getString("DOG_HOBBY"));
				dogInfo.setDogBark(rset.getString("DOG_BARK"));
				dogInfo.setDogBowel(rset.getString("DOG_BOWEL"));
				dogInfo.setDogAct(rset.getString("DOG_ACT"));
				dogInfo.setSeperate(rset.getString("SEPERATE"));
				dogInfo.setFurColor(rset.getString("FUR_COLOR"));
				dogInfo.setObYn(rset.getString("OB_YN"));
				dogInfo.setRegYn(rset.getString("REG_YN"));
				dogInfo.setDogChar(rset.getString("DOG_CHAR"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return dogInfo;
	}

	public int okParceloutApply(Connection con, int pcoAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okParceloutApply");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int noParceloutApply(Connection con, int pcoAppNo, String reason) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("noParceloutApply");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reason);
			pstmt.setInt(2, pcoAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int okParcelout(Connection con, int pcoAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okParcelout");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int noParcelout(Connection con, int pcoAppNo, String reason) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("noParcelout");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reason);
			pstmt.setInt(2, pcoAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public String getSelHopeDate(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String selHopeDate = null;

		String query = prop.getProperty("getSelHopeDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				selHopeDate = rset.getString("SEL_HOPE_DT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selHopeDate;
	}

	public int insertSelDate(Connection con, int entAppNo, String selHopeDate) {
		PreparedStatement pstmt = null;
		int num = 0;

		String query = prop.getProperty("insertSelDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);
			pstmt.setString(2, selHopeDate);

			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}



		return num;
	}

	public int updateDogEntranceSit(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateDogEntranceSit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "입소반려");
			pstmt.setInt(2, entAppNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}

	public String getSelHopeDateParcle(Connection con, int pcoAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String selHopeDate = null;

		String query = prop.getProperty("getSelHopeDateParcle");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				selHopeDate = rset.getString("SEL_APP_DT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return selHopeDate;
	}

	public int insertSelDateParcel(Connection con, int pcoAppNo, String selHopeDate) {
		PreparedStatement pstmt = null;
		int num = 0;

		String query = prop.getProperty("insertSelDateParcel");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);
			pstmt.setString(2, selHopeDate);

			num = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}



		return num;
	}

	public String selectNoEntranceApplyReason(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String reason = null;

		String query = prop.getProperty("selectNoEntranceApplyReason");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				reason = rset.getString("COMPANION_RS");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reason;
	}

	public String selectEntranceSElDate(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null;

		String query = prop.getProperty("selectEntranceSElDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getString("SEL_DT");
				System.out.println("오호라 : " + result);
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

	public int getMyEntranceDogListCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getMyEntranceDogListCount");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt("CON");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<EntranceDogInfo> selectAllEntranceDog(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EntranceDogInfo> list = null;

		String query = prop.getProperty("selectAllEntranceDog");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<EntranceDogInfo>();

			while(rset.next()) {
				EntranceDogInfo dog = new EntranceDogInfo();
				dog.setEntNo(rset.getInt("ENT_NO"));
				dog.setDogNm(rset.getString("DOG_NM"));
				dog.setDogGender(rset.getString("DOG_GENDER"));
				dog.setDogKind(rset.getString("DOG_KIND"));
				dog.setDogSit(rset.getString("DOG_SIT"));
				dog.setEntAppNo(rset.getInt("ENT_APP_NO"));

				list.add(dog);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public int updateDogInfoSit(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateDogInfoSit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "입소반려");
			pstmt.setInt(2, entAppNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
	}

	public int updateDogInfoOk(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateDogInfoOk");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "분양대기");
			pstmt.setInt(2, entAppNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<ParcelOutResult> selectAllParcelOutResult(Connection con, int currentPage2, int limit2) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ParcelOutResult> list = null;

		String query = prop.getProperty("selectAllParcelOutResult");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage2 - 1) * limit2 + 1;
			int endRow = startRow + limit2 - 1;
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<ParcelOutResult>();

			while(rset.next()) {
				ParcelOutResult pr = new ParcelOutResult();
				pr.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				pr.setPcoDt(rset.getDate("PCO_DT"));
				pr.setEntNo(rset.getInt("ENT_NO"));
				pr.setUserNm(rset.getString("USER_NM"));
				pr.setDogNm(rset.getString("DOG_NM"));

				list.add(pr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int updateFinalSit(Connection con, int entNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateFinalSit");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "분양완료");
			pstmt.setInt(2, entNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectParceloutApply(Connection con, int entNo, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("selectParceloutApply");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getInt("ENT_APP_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int updateParcleoutApply(Connection con, int entNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;


		System.out.println("과연이숫자는 ? " + userNo);
		String query = prop.getProperty("updateParcleoutApply");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public int updateParcelOut(Connection con, int entNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateParcelOut");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, entNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

public Entrance entranceInfo(Connection con, int entAppNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Entrance et = null;
		
		String query = prop.getProperty("entInfo");
		System.out.println("쿼리1 : " + query);

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				et = new Entrance();
				et.setEntAppNo(rset.getInt("ENT_APP_NO"));
				et.setUserNo(rset.getInt("USER_NO"));
				et.setWriteDt(rset.getDate("WRITE_DT"));
				et.setSelHopeDt(rset.getString("SEL_HOPE_DT"));
				et.setAppSit(rset.getString("APP_SIT"));
				et.setCompanionRs(rset.getString("COMPANION_RS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return et;
	}

	public int noEntranceDoginfo(Connection con, int entAppNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("noEntranceDoginfo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public String selectNoParcelApplyReason(Connection con, int pcoAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String reason = null;

		String query = prop.getProperty("selectNoParcelApplyReason");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				reason = rset.getString("COMPANION_RS");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return reason;
	}

	public String selectParcelSElDate(Connection con, int pcoAppNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null;

		String query = prop.getProperty("selectParcelSElDate");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = rset.getString("SEL_DT");
				System.out.println("오호라 : " + result);
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

public EntranceDogInfo dogInfo(Connection con, int entAppNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EntranceDogInfo dogInfo = null;
		
		String query = prop.getProperty("dogInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, entAppNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				dogInfo = new EntranceDogInfo();
				dogInfo.setEntNo(rset.getInt("ENT_NO"));
				dogInfo.setDogNm(rset.getString("DOG_NM"));
				dogInfo.setDogAge(rset.getString("DOG_AGE"));
				dogInfo.setDogGender(rset.getString("DOG_GENDER"));
				dogInfo.setDogKind(rset.getString("DOG_KIND"));
				dogInfo.setDogWeight(rset.getInt("DOG_WEIGHT"));
				dogInfo.setDogHeight(rset.getInt("DOG_HEIGHT"));
				dogInfo.setInoYn(rset.getString("INO_YN"));
				dogInfo.setDisYn(rset.getString("DIS_YN"));
				dogInfo.setOperYn(rset.getString("OPER_YN"));
				dogInfo.setAllegy(rset.getString("ALLEGY"));
				dogInfo.setDogHobby(rset.getString("DOG_HOBBY"));
				dogInfo.setDogBark(rset.getString("DOG_BARK"));
				dogInfo.setDogBowel(rset.getString("DOG_BOWEL"));
				dogInfo.setDogAct(rset.getString("DOG_ACT"));
				dogInfo.setSeperate(rset.getString("SEPERATE"));
				dogInfo.setFurColor(rset.getString("FUR_COLOR"));
				dogInfo.setObYn(rset.getString("OB_YN"));
				dogInfo.setRegYn(rset.getString("REG_YN"));
				dogInfo.setDogChar(rset.getString("DOG_CHAR"));
				dogInfo.setEntAppNo(rset.getInt("ENT_APP_NO"));
				dogInfo.setDogSit(rset.getString("DOG_SIT"));		
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return dogInfo;
	}



}
