package com.kh.semi.adminboard.model.dao;

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

import com.kh.semi.adminboard.model.vo.AdminBoard;
import com.kh.semi.adminboard.model.vo.AdminComment;
import com.kh.semi.adminboard.model.vo.AdminStatic;
import com.kh.semi.adminboard.model.vo.AdminUserBoard;
import com.kh.semi.adminboard.model.vo.NoticeAttachment;
import com.kh.semi.board.free.model.vo.UserBoard;
import com.kh.semi.board.free.model.vo.UserBoardAttachment;
import com.kh.semi.board.parcelout.model.vo.Attachment;

public class AdminBoardDao {
	private Properties prop = new Properties();

	public AdminBoardDao() {
		String fileName =
				AdminBoardDao.class.getResource("/sql/adminBoard/adminBoard-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("selectListCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "공지");

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

	public ArrayList<AdminBoard> selectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AdminBoard> list = null;

		String query = prop.getProperty("selectListWithPageing");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setString(1, "공지");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<AdminBoard>();

			while(rset.next()) {
				AdminBoard ab = new AdminBoard();
				ab.setAdBoardNo(rset.getInt("AD_BOARD_NO"));
				ab.setTitle(rset.getString("TITLE"));
				ab.setAdBoardCon(rset.getString("AD_BOARD_CON"));
				ab.setWriteDt(rset.getDate("WRITE_DT"));
				ab.setBoardDiv(rset.getString("BOARD_DIV"));
				ab.setAdNo(rset.getInt("AD_NO"));
				ab.setStatus(rset.getString("STATUS"));
				ab.setNickNm(rset.getString("NICK_NM"));
				ab.setViewCount(rset.getInt("VIEW_COUNT"));

				list.add(ab);
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

	public int insertBoard(Connection con, AdminBoard ab) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertBoard");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ab.getTitle());
			pstmt.setString(2, ab.getAdBoardCon());
			pstmt.setString(3, "공지");
			pstmt.setInt(4, ab.getAdNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public HashMap<String, Object> selectOne(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		AdminBoard ab = null;
		NoticeAttachment at = null;
		ArrayList<NoticeAttachment> list = null;
		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);

			rset = pstmt.executeQuery();

			list = new ArrayList<NoticeAttachment>();
			if(rset.next()) {
				ab = new AdminBoard();
				ab.setAdBoardNo(rset.getInt("AD_BOARD_NO"));
				ab.setTitle(rset.getString("TITLE"));
				ab.setAdBoardCon(rset.getString("AD_BOARD_CON"));
				ab.setWriteDt(rset.getDate("WRITE_DT"));
				ab.setBoardDiv(rset.getString("BOARD_DIV"));
				ab.setAdNo(rset.getInt("AD_NO"));
				ab.setStatus(rset.getString("STATUS"));
				ab.setViewCount(rset.getInt("VIEW_COUNT"));


				at = new NoticeAttachment();
				at.setFileKind(rset.getString("FILE_KIND"));
				at.setAttachmentNo(rset.getInt("ATTACHMENT_NO"));
				at.setOriginNm(rset.getString("ORIGIN_NM"));
				at.setChangeNm(rset.getString("CHANGE_NM"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setUploadDt(rset.getDate("UPLOAD_DT"));
				at.setAdBoardNo(rset.getInt("AD_BOARD_NO"));
				at.setBoardNo(rset.getInt("BOARD_NO"));
				at.setEntNo(rset.getInt("ENT_NO"));
				at.setFileLevel(rset.getString("FILE_LEVEL"));

				list.add(at);
			}

			hmap = new HashMap<String, Object>();
			hmap.put("board", ab);
			hmap.put("attachment", list);


		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return hmap;



	}

	public int insertThumbnailSupportContent(Connection con, AdminBoard ab) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertsupportBoard");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ab.getTitle());
			pstmt.setString(2, ab.getAdBoardCon());
			pstmt.setString(3, "후원");
			pstmt.setString(4, "금전후원");
			pstmt.setInt(5, ab.getAdNo());
			pstmt.setString(6, ab.getSup_Mon());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		String query = prop.getProperty("selectsupportCurrval");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()) {
				bid = rset.getInt("currval");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return bid;
	}

	public int insertSupportAttachment(Connection con, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertSupportAttachment");

		System.out.println("FILE LIST ? " + fileList);

			try {
				for(int i = 0; i < fileList.size(); i++) {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, fileList.get(i).getOriginNm());
					pstmt.setString(2, fileList.get(i).getChangeNm());
					pstmt.setString(3, fileList.get(i).getFilePath());
					pstmt.setInt(4, fileList.get(i).getAdBoardno());
					pstmt.setString(5, "후원");

					result += pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(pstmt);
			}

		return result;
	}

	public AdminBoard selectSupportList(Connection con, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AdminBoard ab = null;

		String query = prop.getProperty("selectSupportList");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "후원");
			pstmt.setString(2, "금전후원");
			pstmt.setString(3, String.valueOf(currentPage).toString());
			rset = pstmt.executeQuery();

			if(rset.next()) {
				ab = new AdminBoard();
				ab.setAdBoardNo(rset.getInt("AD_BOARD_NO"));
				ab.setTitle(rset.getString("TITLE"));
				ab.setAdBoardCon(rset.getString("AD_BOARD_CON"));
				ab.setWriteDt(rset.getDate("WRITE_DT"));
				ab.setAdNo(rset.getInt("AD_NO"));
				ab.setRecCount(rset.getInt("REC_COUNT"));
				ab.setViewCount(rset.getInt("VIEW_COUNT"));
				ab.setNickNm(rset.getString("NICK_NM"));

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}


		return ab;
	}

	public Attachment selectSupportAttachment(Connection con, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment ac = null;

		String query = prop.getProperty("selectSupportAttachment");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, String.valueOf(currentPage).toString());

			rset = pstmt.executeQuery();

			if(rset.next()) {
				ac = new Attachment();
				ac.setAttachmentNo(rset.getInt("ATTACHMENT_NO"));
				ac.setOriginNm(rset.getString("ORIGIN_NM"));
				ac.setChangeNm(rset.getString("CHANGE_NM"));
				ac.setFilePath(rset.getString("FILE_PATH"));
				ac.setUploadDt(rset.getDate("UPLOAD_DT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}



		return ac;
	}

	public int getListCountad(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getListCountad");



		try {
			stmt = con.createStatement();



			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}




		return result;
	}
	public int getListCountad2(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getListCountad2");



		try {
			stmt = con.createStatement();



			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}




		return result;
	}

	public ArrayList<AdminUserBoard> selectListad(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectListad");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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
	public ArrayList<AdminUserBoard> selectListad2(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectListad2");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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

	public ArrayList<Integer> reportCount(Connection con, ArrayList<AdminUserBoard> list2) {
		PreparedStatement pstmt = null;
		ArrayList<Integer> reportCount = null;
		ResultSet rset = null;
		int rseult = 0;

		String query = prop.getProperty("reportCount");

		try {
			reportCount = new ArrayList<Integer>();

			for(int i = 0; i < list2.size(); i++) {

				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, list2.get(i).getBoardNo());


				rset = pstmt.executeQuery();

				if(rset.next()) {

					 rseult = rset.getInt("COUNT");

					reportCount.add(rseult);

				}

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

		}




		return reportCount;
	}

	public ArrayList<AdminUserBoard> selectAll(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectListad");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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

	public int getfreeCount(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getfreeCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "잡담");
			pstmt.setString(2, "자랑");
			pstmt.setString(3, "꿀팁");


			rset = pstmt.executeQuery();

			if(rset.next()) {

				result = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}

	public ArrayList<AdminUserBoard> selectfree(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectfree");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "잡담");
			pstmt.setString(2, "꿀팁");
			pstmt.setString(3, "자랑");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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

	public int getparceloutCount(Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;

		String query = prop.getProperty("getparceloutCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");

			rset = pstmt.executeQuery();

			if(rset.next()) {

				result = rset.getInt("COUNT");

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}

	public ArrayList<AdminUserBoard> selectparcelout(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectparcelout");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "분양후기");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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

	public int deleteNotice(Connection con, int adBoardNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("deleteNotice");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, adBoardNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection con, AdminBoard ab) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateNotice");

		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, ab.getTitle());
			pstmt.setString(2, ab.getAdBoardCon());
			pstmt.setInt(3, ab.getAdBoardNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}


	public int getListCounted(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getListCountad");



		try {
			stmt = con.createStatement();



			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}




		return result;
	}

	public ArrayList<AdminComment> selectListed(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminComment> list = null;
		ResultSet rset = null;
		AdminComment ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectListed");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminComment>();
			while(rset.next()) {
				ub = new AdminComment();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));

				ub.setbUserNick(rset.getString("NICK_NM"));
				ub.setcCon(rset.getString("COM_CON"));
				ub.setcNo(rset.getInt("USER_NO"));

				list.add(ub);
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

	public int getListCounted2(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;

		String query = prop.getProperty("getListCounted2");



		try {
			stmt = con.createStatement();



			rset = stmt.executeQuery(query);

			if(rset.next()) {
				result = rset.getInt(1);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}




		return result;
	}

	public ArrayList<AdminComment> selectListed2(Connection con, int currentPage2, int limit2) {
		PreparedStatement pstmt = null;
		ArrayList<AdminComment> list = null;
		ResultSet rset = null;
		AdminComment ub = null;


		int startRow = (currentPage2 - 1) * limit2 + 1;
		int endRow = startRow + limit2 - 1;

		String query = prop.getProperty("selectListed2");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminComment>();
			while(rset.next()) {
				ub = new AdminComment();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));
				ub.setcCon(rset.getString("COM_CON"));
				ub.setRe(rset.getInt("REPORT_USER"));
				ub.setcNo(rset.getInt("COM_NO"));


				list.add(ub);
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

	public ArrayList<Integer> CoreportCount(Connection con, ArrayList<AdminComment> list2) {
		PreparedStatement pstmt = null;
		ArrayList<Integer> reportCount = null;
		ResultSet rset = null;
		int rseult = 0;

		String query = prop.getProperty("reportCount2");

		try {
			reportCount = new ArrayList<Integer>();

			for(int i = 0; i < list2.size(); i++) {
				System.out.println("코멘트 넘버 : " + list2.get(i).getcNo());
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, list2.get(i).getcNo());


				rset = pstmt.executeQuery();

				if(rset.next()) {

					 rseult = rset.getInt("COUNT");

					reportCount.add(rseult);

				}

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

		}




		return reportCount;
	}

	public ArrayList<Integer> recCount(Connection con, ArrayList<AdminUserBoard> list) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		ArrayList<Integer> recCount = null;

		String query = prop.getProperty("recCount");

		try {
				recCount = new ArrayList<Integer>();
			for(int i = 0; i < list.size(); i++) {
				pstmt = con.prepareStatement(query);


				pstmt.setInt(1, list.get(i).getBoardNo());

				rset = pstmt.executeQuery();

				if(rset.next()) {
					result = rset.getInt("COUNT");

					recCount.add(result);
				}


			}



		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}




		return recCount;
	}
	public int getmssingCount(Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("getmssingCount");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");


			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}

	public ArrayList<AdminUserBoard> selectmissing(Connection con, int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectmissing");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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

	public int getmssingCount2(Connection con) {

		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("getmssingCount2");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");


			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;

	}

	public ArrayList<AdminUserBoard> selectmissing2(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<AdminUserBoard> list = null;
		ResultSet rset = null;
		AdminUserBoard ub = null;


		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		String query = prop.getProperty("selectmissing");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();


			 list = new ArrayList<AdminUserBoard>();
			while(rset.next()) {
				ub = new AdminUserBoard();

				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setbUserNick(rset.getString("NICK_NM"));


				list.add(ub);
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


	public ArrayList<HashMap<String, Object>> statics(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;
			System.out.println("다오");
		String query = prop.getProperty("statics");//회원탈퇴이유

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("reason1", rset.getString("L1"));
				hmap.put("reason2", rset.getString("L2"));
				hmap.put("reason3", rset.getString("L3"));
				hmap.put("reason4", rset.getString("L4"));
				hmap.put("reason5", rset.getString("L5"));

				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	public ArrayList<HashMap<String, Object>> statics2(Connection con) {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;
			System.out.println("다오");
		String query = prop.getProperty("statics2"); //분양강아지 종류

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "말티즈");
			pstmt.setString(2, "코카스파니엘");
			pstmt.setString(3, "믹스");
			pstmt.setString(4, "푸들");
			pstmt.setString(5, "요크셔테리어");
			pstmt.setString(6, "웰시코기");
			pstmt.setString(7, "포메라니안");
			pstmt.setString(8, "스피치");
			pstmt.setString(9, "닥스훈트");
			pstmt.setString(10, "사모예드");
			pstmt.setString(11, "골든리트리버");
			pstmt.setString(12, "허스키");
			pstmt.setString(13, "쉐퍼드");


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("dog_kind1", rset.getString("D1"));
				hmap.put("dog_kind2", rset.getString("D2"));
				hmap.put("dog_kind3", rset.getString("D3"));
				hmap.put("dog_kind4", rset.getString("D4"));
				hmap.put("dog_kind5", rset.getString("D5"));
				hmap.put("dog_kind6", rset.getString("D6"));
				hmap.put("dog_kind7", rset.getString("D7"));
				hmap.put("dog_kind8", rset.getString("D8"));
				hmap.put("dog_kind9", rset.getString("D9"));
				hmap.put("dog_kind10", rset.getString("D10"));
				hmap.put("dog_kind11", rset.getString("D11"));
				hmap.put("dog_kind12", rset.getString("D12"));
				hmap.put("dog_kind13", rset.getString("D13"));



				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	//회원가입 경로
	public ArrayList<HashMap<String, Object>> statics3(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;
			System.out.println("다오");
		String query = prop.getProperty("statics3");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("root1", rset.getString("L1"));
				hmap.put("root2", rset.getString("L2"));
				hmap.put("root3", rset.getString("L3"));
				hmap.put("root4", rset.getString("L4"));
				hmap.put("root5", rset.getString("L5"));

				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	//후원취소 이유
	public ArrayList<HashMap<String, Object>> statics4(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;
			System.out.println("다오");
		String query = prop.getProperty("statics4");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("can1", rset.getString("L1"));
				System.out.println(rset.getString("L1"));

				hmap.put("can2", rset.getString("L2"));
				hmap.put("can3", rset.getString("L3"));
				hmap.put("can4", rset.getString("L4"));


				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	public ArrayList<Object> sortlow(Connection con, int currentPage, int limit, String data) {
			ArrayList<Object> list = null;
			AdminUserBoard ub = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;


			String query = null;

			if(data.equals("sortlow")) {

				query = prop.getProperty("sortlow");
			}else {

				query = prop.getProperty("sorthigh");
			}


			try {
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);

				rset = pstmt.executeQuery();

					list = new ArrayList<Object>();
				while(rset.next()) {
					ub = new AdminUserBoard();

					ub.setuNo(rset.getInt("USER_NO"));
					ub.setBoardNo(rset.getInt("BOARD_NO"));
					ub.setbKind(rset.getString("BOARD_KIND"));
					ub.setbNm(rset.getString("BOARD_NM"));
					ub.setbCon(rset.getString("BOARD_CON"));
					ub.setbUserNick(rset.getString("NICK_NM"));

					list.add(ub);
				}


			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}



		return list;
	}

	public int getSortlistCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;

		String query = prop.getProperty("sortlist");

		try {
			stmt = con.createStatement();


			rset = stmt.executeQuery(query);

			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}





		return listCount;
	}

	public ArrayList<Integer> reportCount2(Connection con,ArrayList<Object> list) {
		PreparedStatement pstmt = null;
		ArrayList<Integer> list2 = null;
		ResultSet rset = null;
		int result = 0;



		String query = prop.getProperty("reportCount");

		try {
			list2 = new ArrayList<Integer>();

			AdminUserBoard ub = null;

			for(int i = 0; i < list.size(); i++) {
				ub = (AdminUserBoard) list.get(i);



				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, ub.getBoardNo());


				rset = pstmt.executeQuery();

				if(rset.next()) {

					 result = rset.getInt("COUNT");

					list2.add(result);

				}

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}




		return list2;
	}

	public int insertThumbnailContent(Connection con, AdminBoard ab) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertThumb");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ab.getTitle());
			pstmt.setString(2, ab.getAdBoardCon());
			pstmt.setInt(3, Integer.parseInt(ab.getNickNm()));

			result  = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}



	public ArrayList<HashMap<String, Object>> selectThumbnailList(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object>hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectThumbnailMap");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String, Object>();

				hmap.put("nno", rset.getInt("BNO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}

	public int insertAttachment(Connection con, ArrayList<NoticeAttachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAttachment");

		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, fileList.get(i).getOriginNm());
				pstmt.setString(2, fileList.get(i).getChangeNm());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setString(4,"공지");
				pstmt.setString(5,"0");

				int level = 0;
				if(i == 0) {
					level = 0;
				}else {
					level = 1;
				}

				pstmt.setInt(5, level);

				result += pstmt.executeUpdate();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<HashMap<String, Object>> statics5(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;

		String query = prop.getProperty("statics5");
		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("enroll1", rset.getString("1M"));
				hmap.put("enroll2", rset.getString("2M"));
				hmap.put("enroll3", rset.getString("3M"));
				hmap.put("enroll4", rset.getString("4M"));
				hmap.put("enroll5", rset.getString("5M"));
				hmap.put("enroll6", rset.getString("6M"));
				hmap.put("enroll7", rset.getString("7M"));
				hmap.put("enroll8", rset.getString("8M"));
				hmap.put("enroll9", rset.getString("9M"));
				hmap.put("enroll10", rset.getString("10M"));
				hmap.put("enroll11", rset.getString("11M"));
				hmap.put("enroll12", rset.getString("12M"));

				list.add(hmap);

			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	public ArrayList<HashMap<String, Object>> statics6(Connection con) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;

		String query = prop.getProperty("statics6");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "0개월~6개월");
			pstmt.setString(2, "분양완료");
			pstmt.setString(3, "6개월~1년");
			pstmt.setString(4, "분양완료");
			pstmt.setString(5, "1년~5년");
			pstmt.setString(6, "분양완료");
			pstmt.setString(7, "5년~10년");
			pstmt.setString(8, "분양완료");
			pstmt.setString(9, "10년이상");
			pstmt.setString(10, "분양완료");


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("dogAge1", rset.getString("1"));
				hmap.put("dogAge2", rset.getString("2"));
				hmap.put("dogAge3", rset.getString("3"));
				hmap.put("dogAge4", rset.getString("4"));
				hmap.put("dogAge5", rset.getString("5"));


				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return list;
	}

	public ArrayList<HashMap<String, Object>> statics7(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;

		String query = prop.getProperty("statics7");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("sup1", rset.getString("1M"));
				hmap.put("sup2", rset.getString("2M"));
				hmap.put("sup3", rset.getString("3M"));
				hmap.put("sup4", rset.getString("4M"));
				hmap.put("sup5", rset.getString("5M"));
				hmap.put("sup6", rset.getString("6M"));
				hmap.put("sup7", rset.getString("7M"));
				hmap.put("sup8", rset.getString("8M"));
				hmap.put("sup9", rset.getString("9M"));
				hmap.put("sup10", rset.getString("10M"));
				hmap.put("sup11", rset.getString("11M"));
				hmap.put("sup12", rset.getString("12M"));

				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}


		return list;
	}

	public int getListCountedd(Connection con) {
		Statement stmt = null;
	      ResultSet rset = null;
	      int result = 0;

	      String query = prop.getProperty("getListCounted");



	      try {
	         stmt = con.createStatement();



	         rset = stmt.executeQuery(query);

	         if(rset.next()) {
	            result = rset.getInt(1);
	         }


	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(stmt);
	         close(rset);
	      }




	      return result;
	}

	public int getListCounteabc(Connection con, String boardsearch) {
		PreparedStatement pstmt = null;
		int result =0;
		ResultSet rset = null;
		
		String query = prop.getProperty("boardsearch");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, boardsearch);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}

	public ArrayList<AdminBoard> selectListabc(Connection con, int currentPage, int limit, String boardsearch) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AdminBoard> list = null;

		String query = prop.getProperty("selectListabc");

		try {
			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			pstmt.setString(1, "공지");
			pstmt.setString(2, boardsearch);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);

			rset = pstmt.executeQuery();

			list = new ArrayList<AdminBoard>();

			while(rset.next()) {
				AdminBoard ab = new AdminBoard();
				ab.setAdBoardNo(rset.getInt("AD_BOARD_NO"));
				ab.setTitle(rset.getString("TITLE"));
				ab.setAdBoardCon(rset.getString("AD_BOARD_CON"));
				ab.setWriteDt(rset.getDate("WRITE_DT"));
				ab.setBoardDiv(rset.getString("BOARD_DIV"));
				ab.setAdNo(rset.getInt("AD_NO"));
				ab.setStatus(rset.getString("STATUS"));
				ab.setNickNm(rset.getString("NICK_NM"));

				list.add(ab);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	public ArrayList<HashMap<String, Object>> statics8(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;

		ResultSet rset = null;

		String query = prop.getProperty("statics8");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("C1", rset.getString("C1"));
				hmap.put("C2", rset.getString("C2"));
				hmap.put("C3", rset.getString("C3"));
				hmap.put("C4", rset.getString("C4"));

				list.add(hmap);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}


}

