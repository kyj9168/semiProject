package com.kh.semi.board.parcelout.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.semi.board.parcelout.model.vo.Attachment;
import com.kh.semi.board.parcelout.model.vo.Coment;
import com.kh.semi.board.parcelout.model.vo.Rec;
import com.kh.semi.board.parcelout.model.vo.Report;
import com.kh.semi.board.parcelout.model.vo.UserBoard;
import com.kh.semi.user.model.vo.User;

public class UserBoardDao {
	private Properties prop = new Properties();


	public UserBoardDao() {
		String fileName =
				UserBoardDao.class.getResource("/sql/parcelout/parcelout-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int updateCount(Connection con, int num) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCount");

		try {
			pstmt = con.prepareStatement(query);


			pstmt.setInt(1 , num);
			pstmt.setInt(2 , num);


			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);


		}




	return result;
}

	public int getoutListCount(Connection con) {

		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectoutlist");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;


	}


	public int insertOutuploadFiles(Connection con, UserBoard b) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertparceloutUpload");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "분양후기");
			pstmt.setString(2, b.getbNm());
			pstmt.setString(3, b.getbCon());
			pstmt.setInt(4, b.getStarRev());
			pstmt.setInt(5, b.getuNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int bid = 0;

		String query = prop.getProperty("selectOutUploadCurrval");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			if(rset.next()) {
				bid = rset.getInt("CURRVAL");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return bid;

	}


	public int insertAttachment(Connection con, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("OutAttachment");

			try {
				for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);



				System.out.println("게시글 번호 : " + fileList.get(i).getAttachmentNo());

				pstmt.setString(1, fileList.get(i).getOriginNm());
				pstmt.setString(2, fileList.get(i).getChangeNm());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setInt(4, fileList.get(i).getAttachmentNo());
				pstmt.setString(5, "분양");

				int level = 0;
				if(i == 0) {

					level = 0;

				}else {

					level = 1;

				}

				pstmt.setInt(6, level);

				result += pstmt.executeUpdate();


				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);

			}




		return result;
	}


	public ArrayList<HashMap<String, Object>> selectOutList(Connection con, int currentPage, int limit) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<HashMap<String,Object>> list = null;
			HashMap<String,Object> hmap = null;

			String query = prop.getProperty("selectoutlist2");

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			try {
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, "분양후기");
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);


				rset = pstmt.executeQuery();

				list = new ArrayList<HashMap<String,Object>>();

				while(rset.next()) {
					hmap = new HashMap<String,Object>();

					hmap.put("boardNo", rset.getInt("BOARD_NO"));
					hmap.put("boardKind", rset.getString("BOARD_KIND"));
					hmap.put("boardNm", rset.getString("BOARD_NM"));
					hmap.put("boardDt", rset.getDate("BOARD_DT"));
					hmap.put("boardCon", rset.getString("BOARD_CON"));
					hmap.put("inqCount", rset.getInt("INQ_COUNT"));
					hmap.put("recCount", rset.getInt("REC_COUNT"));
					hmap.put("nickNm", rset.getString("NICK_NM"));
					hmap.put("filePath", rset.getString("FILE_PATH"));
					hmap.put("changeNm", rset.getString("CHANGE_NM"));

					list.add(hmap);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);

			}


		return list;
	}


	public HashMap<String, Object> selectParceloutOne(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String,Object> hmap = null;
		UserBoard ub = null;
		ArrayList<Object> list = null;
		Attachment at = null;
		User us = null;

		System.out.println("num 의 값 : " + num);

		String query = prop.getProperty("selectParceloutOne");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);

			rset = pstmt.executeQuery();

			list = new ArrayList<Object>();

			while(rset.next()) {
				ub = new UserBoard();

				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setuNo(rset.getInt("USER_NO"));

				us = new User();

				us.setNickNm(rset.getString("NICK_NM"));
				us.setUserNo(rset.getInt("USER_NO"));

				at = new Attachment();

				at.setChangeNm(rset.getString("CHANGE_NM"));
				at.setFilePath(rset.getString("FILE_PATH"));





				list.add(at);
			}

			hmap = new HashMap<String, Object>();
			hmap.put("ParceloutBoard", ub);
			hmap.put("attachment", list);
			hmap.put("User", us);




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return hmap;
	}


	public int updateRec(Connection con, Rec re) {
			PreparedStatement pstmt = null;
			int result = 0;

			String query = prop.getProperty("updateRec");

			try {
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, re.getuNo());
				pstmt.setInt(2, re.getbNo());


				result = pstmt.executeUpdate();


			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}





		return result;
	}


	public UserBoard selectModified(Connection con, int num) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserBoard ub = null;

		String query = prop.getProperty("selectModified");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);



			rset = pstmt.executeQuery();

			if(rset.next()) {
				ub = new UserBoard();

				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbNo(rset.getInt("BOARD_NO"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}




		return ub;
	}


	public int updateOutcon(Connection con, UserBoard ub) {
			PreparedStatement pstmt = null;
			int result = 0;

			String query = prop.getProperty("updateOutcon");

			try {
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, ub.getbNm());
				pstmt.setString(2, ub.getbCon());
				pstmt.setInt(3, ub.getbNo());


				result = pstmt.executeUpdate();



			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}




		return result;
	}


	public int deleteParcelout(Connection con, int num) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("deleteParcelout");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);


			result = pstmt.executeUpdate();



		} catch (SQLException e) {


			e.printStackTrace();
		}finally {
			close(pstmt);
		}


		return result;
	}


	public ArrayList<HashMap<String, Object>> selectOutList2(Connection con, int i, int j) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("selectoutlist3");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");
			pstmt.setInt(2, i);
			pstmt.setInt(3, j);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo2", rset.getInt("BOARD_NO"));
				hmap.put("boardKind2", rset.getString("BOARD_KIND"));
				hmap.put("boardNm2", rset.getString("BOARD_NM"));
				hmap.put("boardDt2", rset.getDate("BOARD_DT"));
				hmap.put("boardCon2", rset.getString("BOARD_CON"));
				hmap.put("inqCount2", rset.getInt("INQ_COUNT"));
				hmap.put("recCount2", rset.getInt("REC_COUNT"));
				hmap.put("nickNm2", rset.getString("NICK_NM"));
				hmap.put("filePath2", rset.getString("FILE_PATH"));
				hmap.put("changeNm2", rset.getString("CHANGE_NM"));

				list.add(hmap);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);

		}


	return list;

	}


	public ArrayList<HashMap<String, Object>> outselectConUno(Connection con, String outselect, String selectinput, String currentPage4, int currentPage3, int limit) {
		 	PreparedStatement pstmt = null;
		 	ResultSet rset = null;
		 	ArrayList<HashMap<String,Object>> list = null ;
		 	HashMap<String,Object> hmap = null;
		 	String test = "";
		 	String query = "";


		 	int startRow = (currentPage3 - 1) * limit + 1;
			int endRow = startRow + limit - 1;


		 	if(outselect != null) {

		 		if(outselect.equals("NICK_NM")) {

		 		query = prop.getProperty("outselectConUno");


		 		}else {

		 		query = prop.getProperty("outselectBnm");



		 		}
		 	}else if(currentPage4 != null ) {

		 		if(currentPage4.equals("NICK_NM")) {

		 			query = prop.getProperty("outselectConUno");


		 		}else {

		 			query = prop.getProperty("outselectBnm");


		 		}
		 	}


		 	try {
				pstmt = con.prepareStatement(query);

				if(outselect != null) {

					pstmt.setString(1, selectinput);
					pstmt.setString(2, "분양후기");

				}else {

					pstmt.setString(1, selectinput);
					pstmt.setString(2, "분양후기");

				}


				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);


				rset = pstmt.executeQuery();

				list = new ArrayList<HashMap<String,Object>>();

				while(rset.next()) {

					hmap = new HashMap<String,Object>();

					hmap.put("boardNo", rset.getInt("BOARD_NO"));
					hmap.put("boardKind", rset.getString("BOARD_KIND"));
					hmap.put("boardNm", rset.getString("BOARD_NM"));
					hmap.put("boardDt", rset.getDate("BOARD_DT"));
					hmap.put("boardCon", rset.getString("BOARD_CON"));
					hmap.put("inqCount", rset.getInt("INQ_COUNT"));
					hmap.put("recCount", rset.getInt("REC_COUNT"));
					hmap.put("nickNm", rset.getString("NICK_NM"));
					hmap.put("filePath", rset.getString("FILE_PATH"));
					hmap.put("changeNm", rset.getString("CHANGE_NM"));
					test = rset.getString("NICK_NM");

					list.add(hmap);



				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}

		 	System.out.println("넘기기전에 test 값 :" + test);

		return list;
	}


	public ArrayList<HashMap<String, Object>> selectOutList3(Connection con, int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("selectoutlist4");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("boardKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("boardDt", rset.getDate("BOARD_DT"));
				hmap.put("boardCon", rset.getString("BOARD_CON"));
				hmap.put("inqCount", rset.getInt("INQ_COUNT"));
				hmap.put("recCount", rset.getInt("REC_COUNT"));
				hmap.put("nickNm", rset.getString("NICK_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));

				list.add(hmap);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);

		}


	return list;



	}


	public ArrayList<HashMap<String, Object>> selectOutList4(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("selectoutlist5");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("boardKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("boardDt", rset.getDate("BOARD_DT"));
				hmap.put("boardCon", rset.getString("BOARD_CON"));
				hmap.put("inqCount", rset.getInt("INQ_COUNT"));
				hmap.put("recCount", rset.getInt("REC_COUNT"));
				hmap.put("nickNm", rset.getString("NICK_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));

				list.add(hmap);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);

		}


	return list;
	}
	public int report(Connection con, Report re) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("report");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, re.getReportin());
			pstmt.setString(2, re.getReason());
			pstmt.setInt(3, re.getBoardNo());
			pstmt.setInt(4, re.getReportout());





			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}


	public int insertcoment(Connection con, Coment cm) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("parceloutComent");

		try {

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, cm.getComent());
			pstmt.setInt(2, cm.getuNo());
			pstmt.setInt(3, cm.getbNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}


	public ArrayList<Coment> selectcoment(Connection con, int bNo) {
		PreparedStatement pstmt = null;
		ArrayList<Coment> list = null;
		ResultSet rset = null;
		Coment cm = null;

		String query = prop.getProperty("selectcoment");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, bNo);




			rset = pstmt.executeQuery();

			list = new ArrayList<Coment>();
			while(rset.next()) {
				cm = new Coment();

				cm.setComent(rset.getString("COM_CON"));
				cm.setConNo(rset.getInt("COM_NO"));
				cm.setuNo(rset.getInt("USER_NO"));
				cm.setbNo(rset.getInt("BOARD_NO"));
				cm.setNickNm(rset.getString("NICK_NM"));

				list.add(cm);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return list;
	}


	public int Selectwrite(Connection con, UserBoard ub) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectwrite");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, ub.getuNo());
			pstmt.setString(2, "X");


			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		System.out.println("넘어가는 리절트값 : " + result);


		return result;
	}


	public int deletRec(Connection con, Rec re) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deletRec");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, re.getuNo());
			pstmt.setInt(2, re.getbNo());

			result = pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}


	public ArrayList<Integer> selectRec(Connection con, int num, int uNo) {
		PreparedStatement pstmt = null;
		ArrayList<Integer> list2 = null;
		ResultSet rset = null;
		System.out.println("게시글 번호 : " +num);
		System.out.println("유저 번호 : " + uNo);

		String query = prop.getProperty("selectRec");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, uNo);
			pstmt.setInt(2, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				list2 = new ArrayList<Integer>();

				list2.add(1);
			}else {
				list2 = new ArrayList<Integer>();

				list2.add(0);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return list2;
	}


	public ArrayList<Integer> selectRecCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		ArrayList<Integer> list3 = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectRecCount");

		try {
			list3 = new ArrayList<Integer>();

			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				list3.add(rset.getInt("COUNT")) ;

				System.out.println("count 의 값 :" + rset.getInt("COUNT") );
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list3;
	}


	public int selectRecajax(Connection con, Rec re) {
			PreparedStatement pstmt = null;
			int result = 0;
			ResultSet rset = null;

			String query = prop.getProperty("selectRecCount");

			try {
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, re.getbNo());

				rset = pstmt.executeQuery();

				if(rset.next()) {
					result = rset.getInt("COUNT") ;
				}


			} catch (SQLException e) {
				e.printStackTrace();
			}


		return result;
	}


	public int getListoutCount2(Connection con, String selectinput) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		System.out.println("혹시 모르니 selectinput 값 확인  : " + selectinput);

		String query = prop.getProperty("selectoutlist10");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");
			pstmt.setString(2, selectinput);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;


	}

	public int getListoutCount3(Connection con, String selectinput) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		System.out.println("혹시 모르니 selectinput 값 확인  : " + selectinput);

		String query = prop.getProperty("selectoutlist11");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");
			pstmt.setString(2, selectinput);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				listCount = rset.getInt(1);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;


	}


	public ArrayList selectRec10(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList list = null;
		int result = 0;

		String query = prop.getProperty("selectRec10");

		try {
			stmt = con.createStatement();


			rset = stmt.executeQuery(query);

			list = new ArrayList();
			while(rset.next()) {


				result = rset.getInt("BOARD_NO");


				list.add(result);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}


	public int selectRec11(Connection con, ArrayList list) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("selectRec11");

		try {
			for(int i = 0;  i < list.size(); i++) {
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, (int) list.get(i));
				pstmt.setInt(2, (int) list.get(i));

				result = pstmt.executeUpdate();

			}






		} catch (SQLException e) {
			e.printStackTrace();
		}


		return result;
	}


	public int selectRec12(Connection con, ArrayList list) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("selectRec12");

		try {

			for(int i = 0; i < list.size(); i++) {

				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, (int) list.get(i));


				result = pstmt.executeUpdate();
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}


		return result;
	}


	public ArrayList selectRec13(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList list = null;
		int result = 0;

		String query = prop.getProperty("selectRec13");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");

			rset = pstmt.executeQuery();

			list = new ArrayList();

			while(rset.next()) {

			result = rset.getInt("BOARD_NO");

				list.add(result);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}





		return list;
	}


	public int reportCon(Connection con, Report re) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("reportCon");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, re.getBoardNo());
			pstmt.setInt(2, re.getReportin());
			pstmt.setInt(3, re.getReportout());
			pstmt.setString(4, re.getReason());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			close(pstmt);
		}


		return result;
	}


	public int deletcom(Connection con, Coment cm) {
			PreparedStatement pstmt = null;
			int result = 0;

			String query = prop.getProperty("deletcom");

			try {
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, cm.getConNo());

				result = pstmt.executeUpdate();


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}



		return result;
	}


	public int updateComment(Connection con, Coment cm) {
		PreparedStatement pstmt = null;
		int result = 0;


		String query = prop.getProperty("updateComment");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, cm.getComent());
			pstmt.setInt(2, cm.getConNo());



			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}


		return result;
	}






}








