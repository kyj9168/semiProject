package com.kh.semi.adminboard.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.semi.adminboard.model.dao.AdminBoardDao;
import com.kh.semi.adminboard.model.vo.AdminBoard;
import com.kh.semi.adminboard.model.vo.AdminComment;
import com.kh.semi.adminboard.model.vo.AdminStatic;
import com.kh.semi.adminboard.model.vo.AdminUserBoard;
import com.kh.semi.adminboard.model.vo.NoticeAttachment;
import com.kh.semi.board.free.model.dao.UserBoardDao;
import com.kh.semi.board.free.model.vo.UserBoardAttachment;
import com.kh.semi.board.missing.model.dao.MissingDao;
import com.kh.semi.board.parcelout.model.vo.Attachment;

public class AdminBoardService {

	public ArrayList<AdminBoard> selectList() {

		return null;
	}

	public int getListCount() {
		Connection con = getConnection();

		int listCount = new AdminBoardDao().getListCount(con);

		close(con);

		return listCount;
	}

	public ArrayList<AdminBoard> selectList(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AdminBoard> list = new AdminBoardDao().selectList(con, currentPage, limit);

		close(con);

		return list;
	}


	public int insertBoard(AdminBoard ab) {
		Connection con = getConnection();

		int result = new AdminBoardDao().insertBoard(con, ab);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);

		return result;
	}

	public HashMap<String, Object> selectOne(int num) {
		Connection con = getConnection();

		HashMap<String, Object> hmap = null;

		int result = new AdminBoardDao().updateCount(con, num);

		if(result > 0) {
			commit(con);

			hmap = new AdminBoardDao().selectOne(con, num);
		}else {
			rollback(con);
		}

		close(con);


		return hmap;
	}

	public int insertSupportMoneyBoard(AdminBoard ab, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;

		int result1 = new AdminBoardDao().insertThumbnailSupportContent(con, ab);

		if(result1 > 0) {
			int bid = new AdminBoardDao().selectCurrval(con);

			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setAdBoardno(bid);
			}
		}

		int result2 = new AdminBoardDao().insertSupportAttachment(con, fileList);

		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}

		return result;
	}

	public AdminBoard selectSupportList(int currentPage) {
		Connection con = getConnection();

		AdminBoard ab = new AdminBoardDao().selectSupportList(con, currentPage);

		close(con);

		return ab;
	}

	public Attachment selectSupportAttachment(int currentPage) {
		Connection con = getConnection();

		Attachment ac = new AdminBoardDao().selectSupportAttachment(con, currentPage);

		close(con);

		return ac;
	}

	public int getListCountad() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getListCountad(con);

		close(con);

		return result;
	}
	public int getListCountad2() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getListCountad2(con);

		close(con);

		return result;
	}

	public ArrayList<AdminUserBoard> selectListad(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AdminUserBoard> list = new AdminBoardDao().selectListad(con,currentPage,limit);

		close(con);



		return list;
	}
	public ArrayList<AdminUserBoard> selectListad2(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AdminUserBoard> list = new AdminBoardDao().selectListad2(con,currentPage,limit);

		close(con);



		return list;
	}

	public ArrayList<Integer> reportCount(ArrayList<AdminUserBoard> list2) {
		Connection con = getConnection();
		ArrayList<Integer> reportCount = null;

		reportCount = new AdminBoardDao().reportCount(con,list2);

		close(con);


		return reportCount;
	}

	public ArrayList<AdminUserBoard> selectAll(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<AdminUserBoard> list = null;

		list = new AdminBoardDao().selectAll(con,currentPage,limit);

		close(con);



		return list;
	}

	public int getfreeCount() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getfreeCount(con);

		close(con);


		return result;
	}

	public ArrayList<AdminUserBoard> selectfree(int currentPage, int limit) {
			Connection con = getConnection();
			ArrayList<AdminUserBoard> list = null;

			list = new AdminBoardDao().selectfree(con, currentPage, limit);

			close(con);

		return list;
	}



	public int getparceloutCount() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getparceloutCount(con);

		close(con);


		return result;
	}

	public ArrayList<AdminUserBoard> selectparcelout(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<AdminUserBoard> list = null;

		list = new AdminBoardDao().selectparcelout(con,currentPage,limit);

		close(con);


		return list;
	}

	public int deleteNotice(int adBoardNo) {
		Connection con = getConnection();

		int result = new AdminBoardDao().deleteNotice(con, adBoardNo);

		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}

		return result;

	}

	public int updateNotice(AdminBoard ab) {
		Connection con = getConnection();

		int result = new AdminBoardDao().updateNotice(con, ab);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return result;
	}





	public int getListCounted() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getListCounted(con);

		close(con);

		return result;
	}

	public ArrayList<AdminComment> selectListed(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AdminComment> list = new AdminBoardDao().selectListed(con,currentPage,limit);

		close(con);



		return list;
	}

	public int getListCounted2() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getListCounted2(con);

		close(con);

		return result;
	}

	public ArrayList<AdminComment> selectListed2(int currentPage2, int limit2) {
		Connection con = getConnection();

		ArrayList<AdminComment> list = new AdminBoardDao().selectListed2(con,currentPage2,limit2);

		close(con);



		return list;
	}

	public ArrayList<Integer> CoreportCount(ArrayList<AdminComment> list2) {
		Connection con = getConnection();
		ArrayList<Integer> reportCount = null;

		reportCount = new AdminBoardDao().CoreportCount(con,list2);

		close(con);


		return reportCount;
	}

	public ArrayList<Integer> recCount(ArrayList<AdminUserBoard> list) {
		Connection con = getConnection();
		ArrayList<Integer> recCount = null;

		recCount = new AdminBoardDao().recCount(con,list);

		close(con);



		return recCount;
	}
	public int getmssingCount() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getmssingCount(con);

		close(con);



		return result;
	}

	public ArrayList<AdminUserBoard> selectmissing(int currentPage, int limit) {
			Connection con = getConnection();

			ArrayList<AdminUserBoard> list = null;

			list = new AdminBoardDao().selectmissing(con,currentPage,limit);

			close(con);

		return list;
	}

	public int getmssingCount2() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getmssingCount2(con);

		close(con);


		return result;
	}

	public ArrayList<AdminUserBoard> selectmissing2(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<AdminUserBoard> list = null;

		list = new AdminBoardDao().selectmissing2(con,currentPage,limit);

		close(con);

	return list;
	}


	//회원탈퇴사유
	public ArrayList<HashMap<String, Object>> statics() {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics(con);


		close(con);





		return list;



	}

	//분양견 종류
	public ArrayList<HashMap<String, Object>> statics2() {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics2(con);


		close(con);





		return list;
	}

	//
	public ArrayList<HashMap<String, Object>> statics3() {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics3(con);


		close(con);





		return list;
	}

	public ArrayList<HashMap<String, Object>> statics4() {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics4(con);


		close(con);





		return list;
	}

	public ArrayList<Object> sortlow(int currentPage, int limit, String data) {
		Connection con = getConnection();

		ArrayList<Object> list = null;


		list = new AdminBoardDao().sortlow(con,currentPage,limit,data);

		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);

		return list;
	}

	public int getSortlistCount() {
		Connection con = getConnection();

		int listCount = 0;


		listCount = new AdminBoardDao().getSortlistCount(con);

		close(con);


		return listCount;
	}

	public ArrayList<Integer> reportCount2(ArrayList<Object> list) {
		Connection con = getConnection();

		ArrayList<Integer> list2 = null;

		list2 = new AdminBoardDao().reportCount2(con, list);

		close(con);




		return list2;

	}
	public ArrayList<HashMap<String, Object>> statics5() {
		Connection con = getConnection();
		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics5(con);

		close(con);


		return list;
	}

	public ArrayList<HashMap<String, Object>> statics6() {
		Connection con = getConnection();
		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics6(con);

		close(con);


		return list;
	}

	public ArrayList<HashMap<String, Object>> statics7() {
		Connection con = getConnection();
		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics7(con);

		close(con);

		return list;
	}

	public int getListCountedd() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getListCountedd(con);

		close(con);

		return result;
	}

	public int insertThumnail(AdminBoard ab, ArrayList<NoticeAttachment> fileList) {
		Connection con = getConnection();

		int result = 0;

		int result1 = new AdminBoardDao().insertThumbnailContent(con,ab);

		if(result > 0) {
			int adBoardNo = new AdminBoardDao().selectCurrval(con);

			for(int i=0; i<fileList.size();i++) {
				fileList.get(i).setAdBoardNo(adBoardNo);
			}
		}
		int result2 = new AdminBoardDao().insertAttachment(con, fileList);
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result =1;
		}else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectThumbnailList() {
		Connection con = getConnection();

		ArrayList<HashMap<String, Object>> list =
				new AdminBoardDao().selectThumbnailList(con);

		close(con);

		return list;
	}

	public int insertBoard(AdminBoard ab, ArrayList<NoticeAttachment> fileList) {
		Connection con = getConnection();

		int result = 0;

		int result1 = new AdminBoardDao().insertBoard(con, ab);

		if(result1 > 0) {
			int bid = new AdminBoardDao().selectCurrval(con);

			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setBoardNo(bid);
			}
		}

		int result2 = new AdminBoardDao().insertAttachment(con, fileList);

		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}

		return result;
	}


	public int getListCountedd() {
		Connection con = getConnection();
		int result = 0;

		result = new AdminBoardDao().getListCountedd(con);

		close(con);

		return result;


	public int getListCountabc(String boardsearch) {
		Connection con = getConnection();
		int result = 0;
		
		result = new AdminBoardDao().getListCounteabc(con, boardsearch);
		
		close(con);
		return result;
	}

	public ArrayList<AdminBoard> selectListabc(int currentPage, int limit, String boardsearch) {
		Connection con = getConnection();

		ArrayList<AdminBoard> list = new AdminBoardDao().selectListabc(con, currentPage, limit, boardsearch);
  }
	public ArrayList<HashMap<String, Object>> statics8() {
		Connection con = getConnection();
		ArrayList<HashMap<String,Object>> list = new AdminBoardDao().statics8(con);

		close(con);

		return list;

	}

}















