package com.kh.semi.board.missing.model.dao;

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

import com.kh.semi.board.missing.model.vo.Comment;
import com.kh.semi.board.missing.model.vo.Missing;
import com.kh.semi.board.missing.model.vo.MissingAttachment;
import com.kh.semi.board.missing.model.vo.MissingReport;
import com.kh.semi.board.parcelout.model.vo.Coment;

public class MissingDao {
	private Properties prop = new Properties();
	
	
	public MissingDao() {
		String fileName = 
				MissingDao.class.getResource("/sql/board/missing/missing_board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//
	

	//페이징 처리 후 게시물 조회용 메소드
	public ArrayList<Missing> selectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Missing> list = null;
		
		String query = prop.getProperty("selectListWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Missing>();
			
			while(rset.next()) {
				Missing b = new Missing();
				
				b.setbNo(rset.getInt("BOARD_NO"));
				b.setbKind(rset.getString("BOARD_KIND"));
				b.setbNm(rset.getString("BOARD_NM"));
				b.setbDate(rset.getDate("BOARD_DT"));
				b.setbCon(rset.getString("BOARD_CON"));
				b.setInqCon(rset.getInt("INQ_COUNT"));
				b.setRecCon(rset.getInt("REC_COUNT"));
				b.setsGrade(rset.getInt("STAR_GRADE"));
				b.setuNo(rset.getInt("USER_NO"));
				b.setStatus(rset.getString("STATUS"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMissPlace(rset.getString("MISS_PLACE"));
				b.setMissDt(rset.getString("MISS_DT"));
				b.setMissGender(rset.getString("MISS_GENDER"));
				b.setMissPhone(rset.getString("MISS_PHONE"));
				b.setBoardDiv(rset.getString("BOARD_DIV"));

				b.setRewardPc(rset.getInt("REWARD_PC"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}

	//miss_con에 insert
	public int MissinsertBoard2(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("miss_insertBoard2");

	
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getMissPlace());
			System.out.println(b.getMissDt());
			pstmt.setString(2,b.getMissDt());
			pstmt.setString(3,b.getMissGender());
			pstmt.setString(4,b.getMissPhone());
			pstmt.setString(5,"실종");
			pstmt.setInt(6, b.getRewardPc());
			pstmt.setString(7, b.getMissPlaceDetail());
			
	
			
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	public MissingAttachment selectOneAttachment(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MissingAttachment file = null;
		
		String query = prop.getProperty("missingselectOneAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				file = new MissingAttachment();
				
				file.setFileKind(rset.getString("FILE_KIND"));
				file.setAttachmentNo(rset.getInt("ATTACHMENT_NO"));
				file.setOriginNm(rset.getString("ORIGIN_NM"));
				file.setChangeNm(rset.getString("CHANGE_NM"));
				file.setFilePath(rset.getString("FILE_PATH"));
				file.setUploadDt(rset.getDate("UPLOAD_DT"));
				file.setAdBoardno(rset.getInt("AD_BOARD_NO"));
				file.setBoardNo(rset.getInt("BOARD_NO"));
				file.setEntNo(rset.getInt("ENT_NO"));
				file.setFileLevel(rset.getString("FILE_LEVEL"));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return file;
	}


	public int insertMissingContent(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("miss_insertThumb");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getbKind());
			pstmt.setString(2,b.getbNm());
			pstmt.setString(3,b.getbCon());
			pstmt.setInt(4, b.getuNo());
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int missingselectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int bid = 0;
		
		String query = prop.getProperty("missingselectCurrval");
		
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


	public int insertAttachment(Connection con, ArrayList<MissingAttachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("missinginsertAttachment");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(4,"실종");
				pstmt.setString(1, fileList.get(i).getOriginNm());
				pstmt.setString(2, fileList.get(i).getChangeNm());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setString(5,"1");
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


	public int insertMissingContent2(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("miss_insertThumb2");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getMissPlace());
			System.out.println(b.getMissDt());
			pstmt.setString(2,b.getMissDt());
			pstmt.setString(3,b.getMissGender());
			pstmt.setString(4,b.getMissPhone());
			pstmt.setString(5,"실종");
			pstmt.setInt(6, b.getRewardPc());
			pstmt.setString(7, b.getMissPlaceDetail());
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public ArrayList<HashMap<String, Object>> missingselectThumbnailList(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;
			System.out.println("다오");
		String query = prop.getProperty("missingselectThumbnailMap");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				
				hmap.put("bNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("bNm", rset.getString("BOARD_NM"));
				hmap.put("bDate", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeName", rset.getString("CHANGE_NM"));
				hmap.put("originName", rset.getString("ORIGIN_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
		
				hmap.put("reward", rset.getInt("REWARD_PC"));
				
		
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


	public HashMap<String, Object> missingselectThumbnailMap(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		Missing b = null;
		MissingAttachment at = null;
		ArrayList<MissingAttachment> list = null;
		
		String query = prop.getProperty("missingselectThumbnailOne");
		System.out.println("안들어갔누ㅠㅠㅠㅠㅠ1111");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MissingAttachment>();
			
			while(rset.next()) {
				b = new Missing();
				
				b.setbNo(rset.getInt("BOARD_NO"));
				b.setbKind(rset.getString("BOARD_KIND"));
				b.setbNm(rset.getString("BOARD_NM"));
				b.setbDate(rset.getDate("BOARD_DT"));
				b.setbCon(rset.getString("BOARD_CON"));
				b.setInqCon(rset.getInt("INQ_COUNT"));
				b.setRecCon(rset.getInt("REC_COUNT"));
				b.setsGrade(rset.getInt("STAR_GRADE"));
				b.setuNo(rset.getInt("USER_NO"));
				b.setStatus(rset.getString("STATUS"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMissPlace(rset.getString("MISS_PLACE"));
				b.setMissDt(rset.getString("MISS_DT"));
				b.setMissGender(rset.getString("MISS_GENDER"));
				b.setMissPhone(rset.getString("MISS_PHONE"));
				b.setBoardDiv(rset.getString("BOARD_DIV"));
	
				b.setRewardPc(rset.getInt("REWARD_PC"));
				
				b.setuName(rset.getString("USER_NM"));
				b.setMissPlaceDetail(rset.getString("DETAIL_PLACE"));
				
				at = new MissingAttachment();
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
			System.out.println(b);
			System.out.println("안들어갔누ㅠㅠㅠㅠㅠ2222");
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("attachment", list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}


	public int missingupdateCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("missingupdateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,num );
			pstmt.setInt(2,num );
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public Missing missingselectup(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Missing ub = null;

		String query = prop.getProperty("missingSelectModified");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);



			rset = pstmt.executeQuery();

			if(rset.next()) {
				ub = new Missing();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setsGrade(rset.getInt("STAR_GRADE"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setStatus(rset.getString("STATUS"));
				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setMissPlace(rset.getString("MISS_PLACE"));
				ub.setMissDt(rset.getString("MISS_DT"));
				ub.setRewardPc(rset.getInt("REWARD_PC"));
				ub.setMissGender(rset.getString("MISS_GENDER"));
				ub.setMissPhone(rset.getString("MISS_PHONE"));
				ub.setBoardDiv(rset.getString("BOARD_DIV"));
				ub.setMissPlaceDetail(rset.getString("DETAIL_PLACE"));
		
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}




		return ub;
	}


	public int missingupdateOutcon(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("missingUpdate");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, b.getbNm());
			pstmt.setString(2, b.getbCon());
			pstmt.setInt(3, b.getbNo());


			result = pstmt.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}




	return result;
	}


	public int missingupdateOutcon2(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("missingUpdate2");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, b.getMissPlace());
			pstmt.setString(2, b.getMissDt());
			pstmt.setString(3, b.getMissGender());
			pstmt.setString(4, b.getMissPhone());
			pstmt.setInt(5, b.getRewardPc());
			pstmt.setString(6, b.getMissPlaceDetail());
			pstmt.setInt(7, b.getbNo());


			result = pstmt.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}




	return result;
	}


	public int deletemissing(Connection con, int num) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("deleteMissing");

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


	public int missinggetoutListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("missingselectoutlist");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");

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


	public ArrayList<HashMap<String, Object>> missingselectOutList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingselectoutlist2");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("bNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("bNm", rset.getString("BOARD_NM"));
				hmap.put("bDate", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeName", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));

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


	public int MissinggetListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("missingselectoutlist");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingselectoutlist2");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
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
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));

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


	public int insertProContent2(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("pro_insertThumb2");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getMissPlace());
			System.out.println(b.getMissDt());
			pstmt.setString(2,b.getMissDt());
			pstmt.setString(3,b.getMissGender());
			pstmt.setString(4,b.getMissPhone());
			pstmt.setString(5,b.getBoardDiv());
		
			pstmt.setString(6, b.getMissPlaceDetail());
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int ProgetListCount(Connection con) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("missingselectoutlist");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");

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


	public ArrayList<HashMap<String, Object>> ProselectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingselectoutlist2");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
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
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
		

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


	public HashMap<String, Object> proselectThumbnailMap(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		Missing b = null;
		MissingAttachment at = null;
		ArrayList<MissingAttachment> list = null;
		
		String query = prop.getProperty("proselectThumbnailOne");
		System.out.println("안들어갔누ㅠㅠㅠㅠㅠ1111");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MissingAttachment>();
			
			while(rset.next()) {
				b = new Missing();
				
				b.setbNo(rset.getInt("BOARD_NO"));
				b.setbKind(rset.getString("BOARD_KIND"));
				b.setbNm(rset.getString("BOARD_NM"));
				b.setbDate(rset.getDate("BOARD_DT"));
				b.setbCon(rset.getString("BOARD_CON"));
				b.setInqCon(rset.getInt("INQ_COUNT"));
				b.setRecCon(rset.getInt("REC_COUNT"));
				b.setsGrade(rset.getInt("STAR_GRADE"));
				b.setuNo(rset.getInt("USER_NO"));
				b.setStatus(rset.getString("STATUS"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMissPlace(rset.getString("MISS_PLACE"));
				b.setMissDt(rset.getString("MISS_DT"));
				b.setMissGender(rset.getString("MISS_GENDER"));
				b.setMissPhone(rset.getString("MISS_PHONE"));
				b.setBoardDiv(rset.getString("BOARD_DIV"));
				b.setuName(rset.getString("USER_NM"));
				b.setMissPlaceDetail(rset.getString("DETAIL_PLACE"));
				
				at = new MissingAttachment();
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
			System.out.println(b);
			System.out.println("안들어갔누ㅠㅠㅠㅠㅠ2222");
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("attachment", list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}


	public int proupdateOutcon2(Connection con, Missing b) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("proUpdate2");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, b.getMissPlace());
			pstmt.setString(2, b.getMissDt());
			pstmt.setString(3, b.getMissGender());
			pstmt.setString(4, b.getMissPhone());
		
			pstmt.setString(5, b.getMissPlaceDetail());
			pstmt.setInt(6, b.getbNo());


			result = pstmt.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}




	return result;
	}


	public int insertAttachment2(Connection con, ArrayList<MissingAttachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("missinginsertAttachment2");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(4,"실종");
				pstmt.setString(1, fileList.get(i).getOriginNm());
				pstmt.setString(2, fileList.get(i).getChangeNm());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setString(5,"1");
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
		
		return result;	}


	public HashMap<String, Object> missingselectThumbnailMap2(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		Missing b = null;
		MissingAttachment at = null;
		ArrayList<MissingAttachment> list = null;
		
		String query = prop.getProperty("missingselectThumbnailOne");
		System.out.println("안들어갔누ㅠㅠㅠㅠㅠ1111");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MissingAttachment>();
			
			while(rset.next()) {
				b = new Missing();
				
				b.setbNo(rset.getInt("BOARD_NO"));
				b.setbKind(rset.getString("BOARD_KIND"));
				b.setbNm(rset.getString("BOARD_NM"));
				b.setbDate(rset.getDate("BOARD_DT"));
				b.setbCon(rset.getString("BOARD_CON"));
				b.setInqCon(rset.getInt("INQ_COUNT"));
				b.setRecCon(rset.getInt("REC_COUNT"));
				b.setsGrade(rset.getInt("STAR_GRADE"));
				b.setuNo(rset.getInt("USER_NO"));
				b.setStatus(rset.getString("STATUS"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMissPlace(rset.getString("MISS_PLACE"));
				b.setMissDt(rset.getString("MISS_DT"));
				b.setMissGender(rset.getString("MISS_GENDER"));
				b.setMissPhone(rset.getString("MISS_PHONE"));
				b.setBoardDiv(rset.getString("BOARD_DIV"));
	
				b.setuName(rset.getString("USER_NM"));
				b.setMissPlaceDetail(rset.getString("DETAIL_PLACE"));
				
				at = new MissingAttachment();
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
			System.out.println(b);
			System.out.println("안들어갔누ㅠㅠㅠㅠㅠ2222");
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("attachment", list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}


	public Missing missingselectup2(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Missing ub = null;

		String query = prop.getProperty("missingSelectModified");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);



			rset = pstmt.executeQuery();

			if(rset.next()) {
				ub = new Missing();

				ub.setbNo(rset.getInt("BOARD_NO"));
				ub.setbKind(rset.getString("BOARD_KIND"));
				ub.setbNm(rset.getString("BOARD_NM"));
				ub.setbDate(rset.getDate("BOARD_DT"));
				ub.setbCon(rset.getString("BOARD_CON"));
				ub.setInqCon(rset.getInt("INQ_COUNT"));
				ub.setRecCon(rset.getInt("REC_COUNT"));
				ub.setsGrade(rset.getInt("STAR_GRADE"));
				ub.setuNo(rset.getInt("USER_NO"));
				ub.setStatus(rset.getString("STATUS"));
				ub.setBoardNo(rset.getInt("BOARD_NO"));
				ub.setMissPlace(rset.getString("MISS_PLACE"));
				ub.setMissDt(rset.getString("MISS_DT"));
				ub.setMissGender(rset.getString("MISS_GENDER"));
				ub.setMissPhone(rset.getString("MISS_PHONE"));
				ub.setBoardDiv(rset.getString("BOARD_DIV"));
				ub.setMissPlaceDetail(rset.getString("DETAIL_PLACE"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}




		return ub;
	}


	public HashMap<String, Object> missingpaperSelect(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		Missing b = null;
		MissingAttachment at = null;
		ArrayList<MissingAttachment> list = null;
		
		String query = prop.getProperty("missingpaper");
		System.out.println("안들어갔누ㅠㅠㅠㅠㅠ1111");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<MissingAttachment>();
			
			while(rset.next()) {
				b = new Missing();
				
				b.setbNo(rset.getInt("BOARD_NO"));
				b.setbKind(rset.getString("BOARD_KIND"));
				b.setbNm(rset.getString("BOARD_NM"));
				b.setbDate(rset.getDate("BOARD_DT"));
				b.setbCon(rset.getString("BOARD_CON"));
				b.setInqCon(rset.getInt("INQ_COUNT"));
				b.setRecCon(rset.getInt("REC_COUNT"));
				b.setsGrade(rset.getInt("STAR_GRADE"));
				b.setuNo(rset.getInt("USER_NO"));
				b.setStatus(rset.getString("STATUS"));
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMissPlace(rset.getString("MISS_PLACE"));
				b.setMissDt(rset.getString("MISS_DT"));
				b.setMissGender(rset.getString("MISS_GENDER"));
				b.setMissPhone(rset.getString("MISS_PHONE"));
				b.setBoardDiv(rset.getString("BOARD_DIV"));
	
				b.setRewardPc(rset.getInt("REWARD_PC"));
				
				b.setuName(rset.getString("USER_NM"));
				b.setMissPlaceDetail(rset.getString("DETAIL_PLACE"));
				
				at = new MissingAttachment();
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
			System.out.println(b);
			System.out.println("안들어갔누ㅠㅠㅠㅠㅠ2222");
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("attachment", list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}


	public int MissinggetListCount2(Connection con, String cont) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("missingsearch1");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, cont);
			pstmt.setString(3, cont);
			pstmt.setString(4, cont);
			pstmt.setString(5, cont);
			pstmt.setString(6, cont);
			
			

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList(Connection con, int currentPage, int limit,
			String cont) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingsearch2");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(cont);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, cont);
			pstmt.setString(3, cont);
			pstmt.setString(4, cont);
			pstmt.setString(5, cont);
			pstmt.setString(6, cont);
			
			pstmt.setInt(7, startRow);
			pstmt.setInt(8, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList1(Connection con, int currentPage, int limit,
			String cont) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingsearch3");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(cont);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, cont);
		/*	pstmt.setString(3, cont);
			pstmt.setString(4, cont);
			pstmt.setString(5, cont);
			pstmt.setString(6, cont);*/
			
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int MissinggetListCount3(Connection con, String cont) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("missingsearch4");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, cont);

			

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


	public int MissinggetListCount4(Connection con, String cont) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("missingsearch5");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, cont);

			

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList2(Connection con, int currentPage, int limit,
			String cont) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingsearch6");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(cont);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, cont);

			
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int PgetListCount2(Connection con, String cont) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("prosearch1");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, cont);
			pstmt.setString(3, cont);
			pstmt.setString(4, cont);
			pstmt.setString(5, cont);
			pstmt.setString(6, cont);
			
			

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


	public ArrayList<HashMap<String, Object>> PselectOutList(Connection con, int currentPage, int limit, String cont) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("prosearch2");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(cont);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, cont);
			pstmt.setString(3, cont);
			pstmt.setString(4, cont);
			pstmt.setString(5, cont);
			pstmt.setString(6, cont);
			
			pstmt.setInt(7, startRow);
			pstmt.setInt(8, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int PgetListCount3(Connection con, String cont) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("prosearch4");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, cont);

			

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


	public ArrayList<HashMap<String, Object>> PselectOutList2(Connection con, int currentPage, int limit, String cont) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("prosearch6");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(cont);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, cont);

			
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int PgetListCount4(Connection con, String cont) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("prosearch5");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, cont);

			

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


	public ArrayList<HashMap<String, Object>> PselectOutList1(Connection con, int currentPage, int limit, String cont) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("prosearch3");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(cont);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, cont);
	
			
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int MissinggetListCount7(Connection con, String val) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("order1");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, val);
		
			

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList7(Connection con, int currentPage, int limit,
			String val) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("order2");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(val);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, val);
		
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int MissinggetListCount8(Connection con, String val) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("order3");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, val);
		
			

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList8(Connection con, int currentPage, int limit,
			String val) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("order4");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(val);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
			pstmt.setString(2, val);
		
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList9(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingselectoutlist3");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "실종");
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
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));

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


	public int MissinggetListCount9(Connection con, String val) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("order5");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, val);
		
			

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList9(Connection con, int currentPage, int limit,
			String val) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("order6");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(val);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, val);
		
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public int MissinggetListCount11(Connection con, String val) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;

		String query = prop.getProperty("order7");


		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, val);
		
			

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList11(Connection con, int currentPage, int limit,
			String val) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("order8");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println(val);
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
			pstmt.setString(2, val);
		
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);


			rset = pstmt.executeQuery();

			list = new ArrayList<HashMap<String,Object>>();

			while(rset.next()) {
				hmap = new HashMap<String,Object>();

				hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("bKind", rset.getString("BOARD_KIND"));
				hmap.put("boardNm", rset.getString("BOARD_NM"));
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));
				hmap.put("bDiv", rset.getString("BOARD_DIV"));
				hmap.put("bCon", rset.getString("BOARD_CON"));
				hmap.put("missP", rset.getString("MISS_PLACE"));
				hmap.put("detail", rset.getString("DETAIL_PLACE"));
				hmap.put("phone", rset.getString("MISS_PHONE"));
				

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


	public ArrayList<HashMap<String, Object>> MissingselectOutList17(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String,Object> hmap = null;

		String query = prop.getProperty("missingselectoutlist4");

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, "보호");
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
				hmap.put("gender", rset.getString("MISS_GENDER"));
				hmap.put("changeNm", rset.getString("CHANGE_NM"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("reward", rset.getInt("REWARD_PC"));

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


	public int report(Connection con, MissingReport re) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("missingreport");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, re.getuNo());
			pstmt.setString(2, re.getReason());
			pstmt.setInt(3, re.getbNo());
			pstmt.setInt(4, re.getuNo2());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}


	public int report(Connection con, int num, int uu) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset =null;

		String query = prop.getProperty("re");

		System.out.println(num+"보드볻부드붇붇ㅂ다저");
		System.out.println(uu+"유저ㅜ어주어줭다저");
		
		
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);
			pstmt.setInt(2, uu);
		

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}



		return result;
	}


	public int report2(Connection con, int test, int test2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("inre");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, test2);
			pstmt.setInt(2, test);
		

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}


	public int report3(Connection con, int test, int test2) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("dere");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, test);

		

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}



		return result;
	}


	public int insertcomment(Connection con, Comment cm) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("missingComent");

		try {

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, cm.getComment());
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


	public ArrayList<Comment> selectcomment(Connection con, int getbNo) {
		PreparedStatement pstmt = null;
		ArrayList<Comment> list = null;
		ResultSet rset = null;
		Comment cm = null;

		String query = prop.getProperty("selectcoment");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, getbNo);




			rset = pstmt.executeQuery();

			list = new ArrayList<Comment>();
			while(rset.next()) {
				cm = new Comment();

				cm.setComment(rset.getString("COM_CON"));
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


	public ArrayList<Comment> selectcoment(Connection con, int num) {
		PreparedStatement pstmt = null;
		ArrayList<Comment> list = null;
		ResultSet rset = null;
		Comment cm = null;

		String query = prop.getProperty("selectcoment");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);




			rset = pstmt.executeQuery();

			list = new ArrayList<Comment>();
			while(rset.next()) {
				cm = new Comment();

				cm.setComment(rset.getString("COM_CON"));
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


	public int reportCon(Connection con, MissingReport re) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("reportCon");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, re.getbNo());
			pstmt.setInt(2, re.getuNo());
			pstmt.setInt(3, re.getuNo2());
			pstmt.setString(4, re.getReason());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			close(pstmt);
		}


		return result;
	}


	public int changCo(Connection con, int cNo, String con2) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCo");

	
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, con2);
	
			pstmt.setInt(2,cNo);
	
			
	
			
			
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
		
		
		
	}


	public int deleteCo(Connection con, int cNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("deleteCo");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, cNo);


			result = pstmt.executeUpdate();



		} catch (SQLException e) {


			e.printStackTrace();
		}finally {
			close(pstmt);
		}


		return result;
	}


	public ArrayList<Comment> selectcomment(Connection con, int cNo, int bNo) {
		PreparedStatement pstmt = null;
		ArrayList<Comment> list = null;
		ResultSet rset = null;
		Comment cm = null;

		String query = prop.getProperty("selectcoment");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, bNo);
			/*pstmt.setInt(2, cNo);
*/



			rset = pstmt.executeQuery();

			list = new ArrayList<Comment>();
			while(rset.next()) {
				cm = new Comment();

				cm.setComment(rset.getString("COM_CON"));
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


	public int report5(Connection con, int test, int test2) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("recup");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, test);


			result = pstmt.executeUpdate();



		} catch (SQLException e) {


			e.printStackTrace();
		}finally {
			close(pstmt);
		}


		return result;
	}


	public int recde(Connection con, int test, int test2) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("recde");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, test);


			result = pstmt.executeUpdate();



		} catch (SQLException e) {


			e.printStackTrace();
		}finally {
			close(pstmt);
		}


		return result;
	}




	
	
	
	}