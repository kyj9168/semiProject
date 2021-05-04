package com.kh.semi.board.free.model.dao;

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


import static com.kh.semi.common.JDBCTemplate.*;

import com.kh.semi.board.free.model.vo.Commentub;
import com.kh.semi.board.free.model.vo.Recub;
import com.kh.semi.board.free.model.vo.UserBoard;
import com.kh.semi.board.free.model.vo.UserBoardAttachment;
import com.kh.semi.board.parcelout.model.vo.Report;


public class UserBoardDao {
	private Properties prop = new Properties();


	public UserBoardDao() {
		String fileName =
				UserBoardDao.class.getResource("/sql/board/free/board-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	


	
	
	
	
	


	//게시물 전체 조회
	public ArrayList<UserBoard> selectList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<UserBoard> list = null;

		String query = prop.getProperty("selectList");

		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<UserBoard>();

			while(rset.next()) {
				UserBoard ub = new UserBoard();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("CNT"));
				ub.setsGrade(rset.getInt("STAR_GRADE"));
				ub.setbUserNick(rset.getString("NICK_NM"));
				ub.setStatus(rset.getString("STATUS"));



				System.out.println(ub);



				list.add(ub);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}





	

	


	


	


	public ArrayList<UserBoard> selectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserBoard> list = null;
		
		String query = prop.getProperty("selectListWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<UserBoard>();
			
			while(rset.next()) {
				UserBoard ub = new UserBoard();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("CNT"));
				ub.setsGrade(rset.getInt("STAR_GRADE"));
				ub.setbUserNick(rset.getString("NICK_NM"));
				ub.setStatus(rset.getString("STATUS"));



				System.out.println(ub);



				list.add(ub);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}

	public ArrayList<UserBoard> selectList(Connection con, int currentPage, int limit, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserBoard> list = null;
		
		String query = prop.getProperty("selectListCateWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<UserBoard>();
			
			while(rset.next()) {
				UserBoard ub = new UserBoard();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("CNT"));
				ub.setsGrade(rset.getInt("STAR_GRADE"));
				ub.setbUserNick(rset.getString("NICK_NM"));
				ub.setStatus(rset.getString("STATUS"));



				System.out.println(ub);



				list.add(ub);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}
	

	

	public int getListCount(Connection con, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;

		
		String query = prop.getProperty("selectListCategoryCount");
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, category);
			
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
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}

	


	


	


	


	


	


	


	


	public int getListCountad(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListCountad");
		
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}


	public ArrayList<UserBoard> selectListad(Connection con,int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserBoard> list = null;
		
		String query = prop.getProperty("selectListadWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<UserBoard>();
			
			while(rset.next()) {
				UserBoard ub = new UserBoard();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("CNT"));
				ub.setsGrade(rset.getInt("STAR_GRADE"));
				ub.setbUserNick(rset.getString("NICK_NM"));
				ub.setStatus(rset.getString("STATUS"));



				System.out.println(ub);



				list.add(ub);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}

	
	

	






	

	

	

	

	public int insertComment(Connection con, Commentub comment) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertCommnet");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, comment.getCommentCon());
			pstmt.setInt(2, comment.getUserNo());
			pstmt.setInt(3, comment.getBoardNo());
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		return result;
	}

	public ArrayList<Commentub> selectListComment(Connection con, int thisBoardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Commentub> commentList = null;

		String query = prop.getProperty("selectListComment");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, thisBoardNo);

			rset = pstmt.executeQuery();
			
			commentList = new ArrayList<Commentub>();

			while(rset.next()) {
				Commentub comment = new Commentub();

				
				comment.setBoardNo(rset.getInt("BOARD_NO"));
				comment.setCommentCon(rset.getString("COM_CON"));
				comment.setCommentNo(rset.getInt("COM_NO"));
				comment.setUserNo(rset.getInt("USER_NO"));
				comment.setNickNm(rset.getString("NICK_NM"));
				comment.setWriteDay(rset.getDate("WRITE_DT"));
			



				System.out.println(comment);



				commentList.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return commentList;
	}

	public int commentUserBoard(Connection con, int thisCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteCommentub");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, thisCommentNo);
			
			

			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			close(pstmt);
		}


		return result;
	}

	public int updateCommentub(Connection con, int thisCommentNo, String comcon) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateCommentub");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, comcon);
			pstmt.setInt(2, thisCommentNo);
	

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
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

	public int getmyComListCount(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;

		
		String query = prop.getProperty("selectmyComListCount");
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			
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

	public ArrayList<Commentub> myComselectList(Connection con, int currentPage, int limit, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Commentub> list = null;
		
		String query = prop.getProperty("selectmyComListWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Commentub>();
			
			while(rset.next()) {
				Commentub com = new Commentub();

				
				com.setBoardNo(rset.getInt("BOARD_NO"));
				com.setBoardNm(rset.getString("BOARD_NM"));
				com.setBoardKind(rset.getString("BOARD_KIND"));
				com.setCommentCon(rset.getString("COM_CON"));
				com.setWriteDay(rset.getDate("WRITE_DT"));
			



				System.out.println(com);



				list.add(com);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}
/////////////////////////////////
	public int updateUserBoard(Connection con, UserBoard ub, int bNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateUserBoard");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ub.getbNm());
			pstmt.setString(2, ub.getbKind());
			pstmt.setString(3, ub.getbCon());
			pstmt.setInt(4, bNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}


		return result;
	}
	
	public UserBoard selectOneub(Connection con, int num) {
		System.out.println("num : " + num);
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserBoard ub = null;

		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			System.out.println("다오 넘 : " + num);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				ub = new UserBoard();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("CNT"));
				ub.setbUserNick(rset.getString("NICK_NM"));

			}
			
			System.out.println(ub);


		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return ub;
	}
	
	//조회수 증가
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
	
			public int uprecommendUserBoard(Connection con, int thisBoardNo, int nowLoginUser) {

				
				PreparedStatement pstmt = null;
				int result = 0;
				System.out.println("다오" + thisBoardNo);
				System.out.println("다오"+nowLoginUser);
				String query = prop.getProperty("insertRecommend");

				try {
					pstmt = con.prepareStatement(query);

					pstmt.setInt(1, nowLoginUser);
					pstmt.setInt(2, thisBoardNo);
					

					result = pstmt.executeUpdate();
					System.out.println("최종 결과" + result);
				} catch (SQLException e) {

					e.printStackTrace();

				}finally {
					close(pstmt);
				}


				return result;
			}
	
	
			public HashMap<String, Object> selectOne(Connection con, int num) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				HashMap<String, Object> hmap = null;
				UserBoard ub = null;
				UserBoardAttachment at = null;
				ArrayList<UserBoardAttachment> list = null;
				String query = prop.getProperty("selectOne");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, num);

					rset = pstmt.executeQuery();

					list = new ArrayList<UserBoardAttachment>();
					if(rset.next()) {
						ub = new UserBoard();
						ub.setbNo(rset.getInt("BOARD_NO"));
						ub.setbKind(rset.getString("BOARD_KIND"));
						ub.setbNm(rset.getString("BOARD_NM"));
						ub.setbDate(rset.getDate("BOARD_DT"));
						ub.setbCon(rset.getString("BOARD_CON"));
						ub.setInqCon(rset.getInt("INQ_COUNT"));
						ub.setbUserNick(rset.getString("NICK_NM"));
						ub.setuNo(rset.getInt("USER_NO"));
						
						at = new UserBoardAttachment();
						at.setFileKind(rset.getString("FILE_KIND"));
						at.setAttachmentNo(rset.getInt("ATTACHMENT_NO"));
						at.setOriginNm(rset.getString("ORIGIN_NM"));
						at.setChangeNm(rset.getString("CHANGE_NM"));
						at.setFilePath(rset.getString("FILE_PATH"));
						at.setUploadDt(rset.getDate("UPLOAD_DT"));
						at.setAdBoardno(rset.getInt("AD_BOARD_NO"));
						at.setBoardNo(rset.getInt("BOARD_NO"));
						at.setEntNo(rset.getInt("ENT_NO"));
						at.setFileLevel(rset.getString("FILE_LEVEL"));
						
						list.add(at);
					}
					
					hmap = new HashMap<String, Object>();
					hmap.put("board", ub);
					hmap.put("attachment", list);


				} catch (SQLException e) {

					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}

				return hmap;
			}
	
			public ArrayList<UserBoard> allselectList(Connection con, int currentPage, int limit, String alignment) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> list = null;
				
				String query = null;
				
				if(alignment.equals("date") ) {
					query = prop.getProperty("alldateselectListWithPaging");
				}else if(alignment.equals("recommend") ) {
					query = prop.getProperty("allrecommendselectListWithPaging");
				}else if(alignment.equals("inquiry") ) {
					query = prop.getProperty("allinquiryselectListWithPaging");
				}
				
				try {
					pstmt = con.prepareStatement(query);

					//조회를 시작할 행 번호와 마지막 행 번호 계산
					int startRow = (currentPage - 1) * limit + 1;
					int endRow = startRow + limit - 1;
				
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<UserBoard>();
					
					while(rset.next()) {
						UserBoard ub = new UserBoard();

						ub.setbNo(rset.getInt("BOARD_NO"));
						ub.setbKind(rset.getString("BOARD_KIND"));
						ub.setbNm(rset.getString("BOARD_NM"));
						ub.setbDate(rset.getDate("BOARD_DT"));
						ub.setbCon(rset.getString("BOARD_CON"));
						ub.setInqCon(rset.getInt("INQ_COUNT"));
						ub.setRecCon(rset.getInt("CNT"));
						ub.setsGrade(rset.getInt("STAR_GRADE"));
						ub.setbUserNick(rset.getString("NICK_NM"));
						ub.setStatus(rset.getString("STATUS"));



						System.out.println(ub);



						list.add(ub);

					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				
				
				
				return list;
			}

			public ArrayList<UserBoard> cateselectList(Connection con, int currentPage, int limit, String category,
					String alignment) {
				
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> list = null;
				
				String query = null;
				
				if(alignment.equals("date") ) {
					if(category.equals("bragging")) {
						category = "자랑";
					}else if(category.equals("tip")) {
						category = "꿀팁";
					}else if(category.equals("chat")) {
						category = "잡담";
					}
					query = prop.getProperty("catedateselectListWithPaging");
					
				}else if(alignment.equals("recommend") ) {
					if(category.equals("bragging")) {
						category = "자랑";
					}else if(category.equals("tip")) {
						category = "꿀팁";
					}else if(category.equals("chat")) {
						category = "잡담";
					}
					query = prop.getProperty("caterecommendselectListWithPaging");
				}else if(alignment.equals("inquiry") ) {
					if(category.equals("bragging")) {
						category = "자랑";
					}else if(category.equals("tip")) {
						category = "꿀팁";
					}else if(category.equals("chat")) {
						category = "잡담";
					}
					query = prop.getProperty("cateinquiryselectListWithPaging");
				}
				
				try {
					pstmt = con.prepareStatement(query);

					//조회를 시작할 행 번호와 마지막 행 번호 계산
					int startRow = (currentPage - 1) * limit + 1;
					int endRow = startRow + limit - 1;
				
					pstmt.setString(1, category);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<UserBoard>();
					
					while(rset.next()) {
						UserBoard ub = new UserBoard();

						ub.setbNo(rset.getInt("BOARD_NO"));
						ub.setbKind(rset.getString("BOARD_KIND"));
						ub.setbNm(rset.getString("BOARD_NM"));
						ub.setbDate(rset.getDate("BOARD_DT"));
						ub.setbCon(rset.getString("BOARD_CON"));
						ub.setInqCon(rset.getInt("INQ_COUNT"));
						ub.setRecCon(rset.getInt("CNT"));
						ub.setsGrade(rset.getInt("STAR_GRADE"));
						ub.setbUserNick(rset.getString("NICK_NM"));
						ub.setStatus(rset.getString("STATUS"));



						System.out.println(ub);



						list.add(ub);

					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				
				
				
				return list;
			}
			
			public ArrayList<UserBoard> allsearchselectList(Connection con, int currentPage, int limit, String what, String search,
					String alignment) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> list = null;
				
				String query = null;
				
				if(alignment.equals("date") ) {
					if(what.equals("writer")) {
						query = prop.getProperty("alldatesearchwriterselectListWithPaging");
					}else if(what.equals("title")){
						query = prop.getProperty("alldatesearchtitleselectListWithPaging");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("alldatesearchticonselectListWithPaging");
					}
					
				}else if(alignment.equals("recommend") ) {
					if(what.equals("writer")) {
						query = prop.getProperty("allrecommendsearchwriterselectListWithPaging");
					}else if(what.equals("title")){
						query = prop.getProperty("allrecommendsearchtitleselectListWithPaging");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("allrecommendsearchticonselectListWithPaging");
					}
					
				}else if(alignment.equals("inquiry") ) {
					if(what.equals("writer")) {
						query = prop.getProperty("allinquirysearchwriterselectListWithPaging");
					}else if(what.equals("title")){
						query = prop.getProperty("allinquirysearchtitlerselectListWithPaging");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("allinquirysearchticonrselectListWithPaging");
					}
					
				}
				
				try {
					pstmt = con.prepareStatement(query);

					//조회를 시작할 행 번호와 마지막 행 번호 계산
					int startRow = (currentPage - 1) * limit + 1;
					int endRow = startRow + limit - 1;
				
					
					if(what.equals("ticon")) {
						pstmt.setString(1, search);
						pstmt.setString(2, search);
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
					}else {
						pstmt.setString(1, search);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
					}
				
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<UserBoard>();
					
					while(rset.next()) {
						UserBoard ub = new UserBoard();

						ub.setbNo(rset.getInt("BOARD_NO"));
						ub.setbKind(rset.getString("BOARD_KIND"));
						ub.setbNm(rset.getString("BOARD_NM"));
						ub.setbDate(rset.getDate("BOARD_DT"));
						ub.setbCon(rset.getString("BOARD_CON"));
						ub.setInqCon(rset.getInt("INQ_COUNT"));
						ub.setRecCon(rset.getInt("CNT"));
						ub.setsGrade(rset.getInt("STAR_GRADE"));
						ub.setbUserNick(rset.getString("NICK_NM"));
						ub.setStatus(rset.getString("STATUS"));



						System.out.println(ub);



						list.add(ub);

					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				
				
				
				return list;
			}
			
			public ArrayList<UserBoard> catesearchselectList(Connection con, int currentPage, int limit, String what, String search,
					String category, String alignment) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> list = null;
				
				String query = null;
				if(category.equals("bragging")) {
					category = "자랑";
				}else if(category.equals("tip")) {
					category = "꿀팁";
				}else if(category.equals("chat")) {
					category = "잡담";
				}
				
				if(alignment.equals("date")) {
					if(what.equals("writer")) {
						query = prop.getProperty("datesearchwriterselectListWithPaging");
					}else if(what.equals("title")){
						query = prop.getProperty("datesearchtitleselectListWithPaging");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("datesearchticonselectListWithPaging");
					}	
				}else if(alignment.equals("recommend")) {
					if(what.equals("writer")) {
						query = prop.getProperty("recommendsearchwriterselectListWithPaging");
					}else if(what.equals("title")){
						query = prop.getProperty("recommendsearchtitleselectListWithPaging");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("recommendsearchticonselectListWithPaging");
					}	
				}else if(alignment.equals("inquiry") ) {
					if(what.equals("writer")) {
						query = prop.getProperty("inquirysearchwriterselectListWithPaging");
					}else if(what.equals("title")){
						query = prop.getProperty("inquirysearchtitleselectListWithPaging");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("inquirysearchticonselectListWithPaging");
					}
				}
				
				try {
					pstmt = con.prepareStatement(query);

					//조회를 시작할 행 번호와 마지막 행 번호 계산
					int startRow = (currentPage - 1) * limit + 1;
					int endRow = startRow + limit - 1;
				
					
					if(what.equals("ticon")) {
						pstmt.setString(1, search);
						pstmt.setString(2, search);
						pstmt.setString(3, category);
						pstmt.setInt(4, startRow);
						pstmt.setInt(5, endRow);
					}else {
						pstmt.setString(1, search);
						pstmt.setString(2, category);
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
					}
					
					
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<UserBoard>();
					
					while(rset.next()) {
						UserBoard ub = new UserBoard();

						ub.setbNo(rset.getInt("BOARD_NO"));
						ub.setbKind(rset.getString("BOARD_KIND"));
						ub.setbNm(rset.getString("BOARD_NM"));
						ub.setbDate(rset.getDate("BOARD_DT"));
						ub.setbCon(rset.getString("BOARD_CON"));
						ub.setInqCon(rset.getInt("INQ_COUNT"));
						ub.setRecCon(rset.getInt("CNT"));
						ub.setsGrade(rset.getInt("STAR_GRADE"));
						ub.setbUserNick(rset.getString("NICK_NM"));
						ub.setStatus(rset.getString("STATUS"));



						System.out.println(ub);



						list.add(ub);

					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				
				
				
				return list;
			}
			
			public int getListCount(Connection con, String category, String alignment) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int listCount = 0;
				String query = null;
				
				if(category.equals("all") ) {
						query = prop.getProperty("allselectListCount");
				}else if(category.equals("bragging")) {
						query = prop.getProperty("braggingselectListCount");
				}else if(category.equals("tip")) {
						query = prop.getProperty("tipselectListCount");
				}else if(category.equals("chat")) {
						query = prop.getProperty("chatselectListCount");
				}
				
				
			
				
				
				
				
				try {
					pstmt = con.prepareStatement(query);
					
					
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
			
			public int getListCount(Connection con, String category, String what, String search, String alignment) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int listCount = 0;
				String query = null;
				System.out.println("다오 카운트 category : " + category);
				if(category.equals("all") ) {
					if(what.equals("writer")) {
						query = prop.getProperty("allwritersearchselectListCount");
					}else if(what.equals("title")){
						query = prop.getProperty("alltitlesearchselectListCount");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("allticonsearchselectListCount");
					}
						
				}else if(category.equals("bragging")) {
					if(what.equals("writer")) {
						query = prop.getProperty("braggingwritersearchselectListCount3");
					}else if(what.equals("title")){
						query = prop.getProperty("braggingtitlesearchselectListCount");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("braggingticonsearchselectListCount");
					}
				}else if(category.equals("tip")) {
					if(what.equals("writer")) {
						query = prop.getProperty("tipwritersearchselectListCount");
					}else if(what.equals("title")){
						query = prop.getProperty("tiptitlesearchselectListCount");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("tipticonsearchselectListCount");
					}
				}else if(category.equals("chat")) {
					if(what.equals("writer")) {
						query = prop.getProperty("chatwritersearchselectListCount");
					}else if(what.equals("title")){
						query = prop.getProperty("chattitlesearchselectListCount");
					}else if(what.equals("ticon")) {
						query = prop.getProperty("chatticonsearchselectListCount");
					}
				}
				
				
				
				try {
					pstmt = con.prepareStatement(query);
					
					pstmt.setString(1, search);
					
					if(what.equals("ticon")) {
						pstmt.setString(2, search);
					}
					
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
			
			public ArrayList<UserBoard> selectListBest(Connection con) {
				Statement stmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> best = null;

				String query = prop.getProperty("selectBestList");

				try {
					stmt = con.createStatement();

					rset = stmt.executeQuery(query);

					best = new ArrayList<UserBoard>();

					while(rset.next()) {
						UserBoard ubbest = new UserBoard();

						ubbest.setbNo(rset.getInt("BOARD_NO"));
						ubbest.setbKind(rset.getString("BOARD_KIND"));
						ubbest.setbNm(rset.getString("BOARD_NM"));
						ubbest.setbDate(rset.getDate("BOARD_DT"));
						ubbest.setbCon(rset.getString("BOARD_CON"));
						ubbest.setInqCon(rset.getInt("INQ_COUNT"));
						ubbest.setRecCon(rset.getInt("CNT"));
						ubbest.setsGrade(rset.getInt("STAR_GRADE"));
						ubbest.setbUserNick(rset.getString("NICK_NM"));
						ubbest.setStatus(rset.getString("STATUS"));



						System.out.println(ubbest);



						best.add(ubbest);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rset);
					close(stmt);
				}

				return best;
			}

			public ArrayList<UserBoard> selectList(Connection con, int currentPage, int limit, String search,
					String what) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> list = null;
				
				String query = null;
				if(what.equals("writer")) {
					query = prop.getProperty("selectListWriterWithPaging");
					try {
						pstmt = con.prepareStatement(query);

						//조회를 시작할 행 번호와 마지막 행 번호 계산
						int startRow = (currentPage - 1) * limit + 1;
						int endRow = startRow + limit - 1;
						
						pstmt.setString(1, search);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						
						rset = pstmt.executeQuery();
						
						list = new ArrayList<UserBoard>();
						
						while(rset.next()) {
							UserBoard ub = new UserBoard();

							ub.setbNo(rset.getInt("BOARD_NO"));
							ub.setbKind(rset.getString("BOARD_KIND"));
							ub.setbNm(rset.getString("BOARD_NM"));
							ub.setbDate(rset.getDate("BOARD_DT"));
							ub.setbCon(rset.getString("BOARD_CON"));
							ub.setInqCon(rset.getInt("INQ_COUNT"));
							ub.setRecCon(rset.getInt("CNT"));
							ub.setsGrade(rset.getInt("STAR_GRADE"));
							ub.setbUserNick(rset.getString("NICK_NM"));
							ub.setStatus(rset.getString("STATUS"));



							System.out.println(ub);



							list.add(ub);

							
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						close(pstmt);
						close(rset);
					}
				}else if(what.equals("title")) {
					query = prop.getProperty("selectListTitleWithPaging");
					try {
						pstmt = con.prepareStatement(query);

						//조회를 시작할 행 번호와 마지막 행 번호 계산
						int startRow = (currentPage - 1) * limit + 1;
						int endRow = startRow + limit - 1;
						
						pstmt.setString(1, search);
						pstmt.setInt(2, startRow);
						pstmt.setInt(3, endRow);
						
						
						rset = pstmt.executeQuery();
						
						list = new ArrayList<UserBoard>();
						
						while(rset.next()) {
							UserBoard ub = new UserBoard();

							ub.setbNo(rset.getInt("BOARD_NO"));
							ub.setbKind(rset.getString("BOARD_KIND"));
							ub.setbNm(rset.getString("BOARD_NM"));
							ub.setbDate(rset.getDate("BOARD_DT"));
							ub.setbCon(rset.getString("BOARD_CON"));
							ub.setInqCon(rset.getInt("INQ_COUNT"));
							ub.setRecCon(rset.getInt("CNT"));
							ub.setsGrade(rset.getInt("STAR_GRADE"));
							ub.setbUserNick(rset.getString("NICK_NM"));
							ub.setStatus(rset.getString("STATUS"));



							System.out.println(ub);



							list.add(ub);

							
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						close(pstmt);
						close(rset);
					}
					
				}else {
					query = prop.getProperty("selectListTiconWithPaging");
					
					try {
						pstmt = con.prepareStatement(query);

						//조회를 시작할 행 번호와 마지막 행 번호 계산
						int startRow = (currentPage - 1) * limit + 1;
						int endRow = startRow + limit - 1;
						
						pstmt.setString(1, search);
						pstmt.setString(2, search);
						pstmt.setInt(3, startRow);
						pstmt.setInt(4, endRow);
						
						rset = pstmt.executeQuery();
						
						list = new ArrayList<UserBoard>();
						
						while(rset.next()) {
							UserBoard ub = new UserBoard();

							ub.setbNo(rset.getInt("BOARD_NO"));
							ub.setbKind(rset.getString("BOARD_KIND"));
							ub.setbNm(rset.getString("BOARD_NM"));
							ub.setbDate(rset.getDate("BOARD_DT"));
							ub.setbCon(rset.getString("BOARD_CON"));
							ub.setInqCon(rset.getInt("INQ_COUNT"));
							ub.setRecCon(rset.getInt("CNT"));
							ub.setsGrade(rset.getInt("STAR_GRADE"));
							ub.setbUserNick(rset.getString("NICK_NM"));
							ub.setStatus(rset.getString("STATUS"));



							System.out.println(ub);



							list.add(ub);

							
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						close(pstmt);
						close(rset);
					}
				}
						
				
				
				
				
				
				return list;
			}
	
			public int getsearchListCount(Connection con, String what, String search) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int listCount = 0;
				
				String query = null;
				if(what.equals("writer")) {
					query = prop.getProperty("getsearchListCountWriter");
					try {
						pstmt = con.prepareStatement(query);
						
						pstmt.setString(1, search);
						
						
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
				}else if(what.equals("title")) {
					query = prop.getProperty("getsearchListCountTitle");
					try {
						pstmt = con.prepareStatement(query);
						
						pstmt.setString(1, search);
						
						
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
				}else {
					query = prop.getProperty("getsearchListCountTicon");
					try {
						pstmt = con.prepareStatement(query);
						
						pstmt.setString(1, search);
						pstmt.setString(2, search);
						
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
				}
				
				
				
				
				
				return listCount;
			}
			
			public ArrayList<UserBoard> myselectList(Connection con, int currentPage, int limit, int userNo) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<UserBoard> list = null;
				
				String query = prop.getProperty("selectmyListWithPaging");
				
				try {
					pstmt = con.prepareStatement(query);

					//조회를 시작할 행 번호와 마지막 행 번호 계산
					int startRow = (currentPage - 1) * limit + 1;
					int endRow = startRow + limit - 1;
					
					pstmt.setInt(1, userNo);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					
					rset = pstmt.executeQuery();
					
					list = new ArrayList<UserBoard>();
					
					while(rset.next()) {
						UserBoard ub = new UserBoard();

						ub.setbNo(rset.getInt("BOARD_NO"));
						ub.setbKind(rset.getString("BOARD_KIND"));
						ub.setbNm(rset.getString("BOARD_NM"));
						ub.setbDate(rset.getDate("BOARD_DT"));
						ub.setbCon(rset.getString("BOARD_CON"));
						ub.setInqCon(rset.getInt("INQ_COUNT"));
						ub.setRecCon(rset.getInt("CNT"));
						ub.setsGrade(rset.getInt("STAR_GRADE"));
						ub.setbUserNick(rset.getString("NICK_NM"));
						ub.setStatus(rset.getString("STATUS"));



						System.out.println(ub);



						list.add(ub);

					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				
				
				
				return list;
			}
			
			public int getmyListCount(Connection con, int userNo) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int listCount = 0;

				
				String query = prop.getProperty("selectmyListCount");
				
				
				try {
					pstmt = con.prepareStatement(query);
					
					pstmt.setInt(1, userNo);
					
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
			
			public int getUserNo(Connection con, String commentNickNm) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int userNo = 0;
				System.out.println("다오에서 닉네임" + commentNickNm);
				
				String query = prop.getProperty("getUserNo");


				try {
					pstmt = con.prepareStatement(query);

					pstmt.setString(1, commentNickNm);

					rset = pstmt.executeQuery();


					if(rset.next()) {

						userNo = rset.getInt("USER_NO");


					}


				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				System.out.println("다오마지막에서" + userNo);
				
				return userNo;
			}
			
			//게시물 작성용 메소드
			public int insertBoard(Connection con, UserBoard ub) {
				PreparedStatement pstmt = null;
				int result = 0;

				String query = prop.getProperty("insertBoard");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, ub.getbKind());
					pstmt.setString(2, ub.getbNm());
					pstmt.setString(3, ub.getbCon());
					pstmt.setInt(4, ub.getuNo());
					//여긴 필요한 값 각자 알아서

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
				
				String query = prop.getProperty("selectCurrval");
				
				try {
					stmt = con.createStatement();
					rset = stmt.executeQuery(query);
					
					if(rset.next()) {
						bid = rset.getInt("currval");
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(stmt);
					close(rset);
				}
				
				return bid;
			}
			
			public int insertAttachment(Connection con, ArrayList<UserBoardAttachment> fileList) {
				PreparedStatement pstmt = null;
				int result = 0;
				
				String query = prop.getProperty("insertAttachment");
				
				try {
					for(int i = 0; i < fileList.size(); i++) {
						pstmt = con.prepareStatement(query);
						
						pstmt.setString(1, fileList.get(i).getOriginNm());
						pstmt.setString(2, fileList.get(i).getChangeNm());
						pstmt.setString(3, fileList.get(i).getFilePath());
						pstmt.setString(4,"자유");
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
			
			public int deleteUserBoard(Connection con, int nno) {
				PreparedStatement pstmt = null;
				int result = 0;

				String query = prop.getProperty("deleteUserBoard");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, nno);

					result = pstmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}


				return result;
			}
			
			public int derecommendUserBoard(Connection con, int thisBoardNo, int nowLoginUser) {
				PreparedStatement pstmt = null;
				int result = 0;
				
				System.out.println("다오" + thisBoardNo);
				System.out.println("다오"+nowLoginUser);
				String query = prop.getProperty("deleteRecommend");

				try {
					pstmt = con.prepareStatement(query);

					pstmt.setInt(1, nowLoginUser);
					pstmt.setInt(2, thisBoardNo);
					

					result = pstmt.executeUpdate();
				} catch (SQLException e) {

					e.printStackTrace();

				}finally {
					close(pstmt);
				}


				return result;
			}
			
			public Recub selectRec(Connection con, int num, int logUno) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				Recub rec = null;
				
				String query = prop.getProperty("selectRecub");
				System.out.println("다오에서 " + logUno);
				System.out.println("다오에서 " + num);
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, logUno);
					pstmt.setInt(2, num);
					
					rset = pstmt.executeQuery();
				
					if(rset.next()) {
						rec = new Recub();
						
						rec.setbNo(rset.getInt("BOARD_NO"));
						rec.setuNo(rset.getInt("USER_NO"));
						
						
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				System.out.println("다오에서 rec" + rec);
				return rec;
			}
			
			public int selectRecCount(Connection con, int num) {
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				int recCount = 0;
				
				String query = prop.getProperty("selectRecCountub");
				
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, num);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						recCount = rset.getInt(1);
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
					close(rset);
				}
				
				return recCount;
			}
			
			public int selectRecCountmain(Connection con, int thisBoardNo) {
				PreparedStatement pstmt = null;
				int result = 0;

				String query = prop.getProperty("updaterecom");

				try {
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, thisBoardNo);
					pstmt.setInt(2, thisBoardNo);
					

					result = pstmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}


				return result;
			}
}









