package com.kh.semi.board.missing.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.semi.board.missing.model.dao.MissingDao;
import com.kh.semi.board.missing.model.vo.Comment;
import com.kh.semi.board.missing.model.vo.Missing;
import com.kh.semi.board.missing.model.vo.MissingAttachment;
import com.kh.semi.board.missing.model.vo.MissingReport;
import com.kh.semi.board.parcelout.model.dao.UserBoardDao;
import com.kh.semi.board.parcelout.model.vo.Coment;
public class MissingService {
	

	
	//페이징 처리 후 게시물 목록 조회용 메소드
	public ArrayList<Missing> selectList(int currentPage, int limit) {
		Connection con= getConnection();
		ArrayList<Missing> list= new MissingDao().selectList(con,currentPage,limit);
		
		close(con);
		
		
		
		return list;
	}
	
	
	public int MissingInsert(Missing b, ArrayList<MissingAttachment> fileList) {
Connection con = getConnection();
		
		int result = 0;
		
		int result1 = new MissingDao().insertMissingContent(con, b);
		int result3 = new MissingDao().insertMissingContent2(con, b);
		
		if(result1 > 0) {
			int bid = new MissingDao().missingselectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
			//	fileList.get(i).setBid(bid);
			}
		}
		
		int result2 = new MissingDao().insertAttachment(con, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		return result;
	}
	public ArrayList<HashMap<String, Object>> missingselectThumbnailList() {
Connection con = getConnection();
		System.out.println("서비스");
		ArrayList<HashMap<String, Object>> list =
				new MissingDao().missingselectThumbnailList(con);
		System.out.println("서비스2");
		close(con);
		
		return list;
	}
	public HashMap<String, Object> missingselectThumbnailMap(int num) {
		System.out.println("어딩ㅇㅇㅇㅇ");
Connection con = getConnection();
		
		HashMap<String, Object> hmap = null;
		ArrayList<Comment> list = null;
		int result = new MissingDao().missingupdateCount(con,num);
		System.out.println("result"+result);
		if(result > 0) {
			commit(con);
			hmap = new MissingDao().missingselectThumbnailMap(con, num);
			list = new MissingDao().selectcoment(con,num);
			
		}else {
			rollback(con);
		}
		
		close(con);
		hmap.put("comment", list);
		
		
		return hmap;
	
	}
	public Missing missingselectup(int num) {
		Connection con = getConnection();

		Missing ub = new MissingDao().missingselectup(con, num);

		close(con);

	return ub;
	}
	public int updateMissing(Missing b) {
		Connection con = getConnection();

		int result = new MissingDao().missingupdateOutcon(con,b);
		int result2 = new MissingDao().missingupdateOutcon2(con,b);

		if(result > 0) {
			commit(con);
		}else{
			rollback(con);
		}

		close(con);

	return result;
	}
	public int deletemissing(int num) {
		Connection con = getConnection();

		int result = new MissingDao().deletemissing(con,num);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);



	return result;
	}



	public int getListoutCount() {

		Connection con = getConnection();

		int listCount = new MissingDao().missinggetoutListCount(con);

		close(con);

		return listCount;
	}

	
	public ArrayList<HashMap<String, Object>> selectOutList(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().missingselectOutList(con,currentPage,limit);


		close(con);

		return list;
	}


	public int MissinggetListCount() {
		Connection con = getConnection();

		int listCount = new MissingDao().MissinggetListCount(con);

		close(con);

		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList(con,currentPage,limit);


		close(con);

		return list;
	}


	public int ProInsert(Missing b, ArrayList<MissingAttachment> fileList) {
Connection con = getConnection();
		
		int result = 0;
		
		int result1 = new MissingDao().insertMissingContent(con, b);
		System.out.println(b.getBoardDiv());
		int result3 = new MissingDao().insertProContent2(con, b);
		
		if(result1 > 0) {
			int bid = new MissingDao().missingselectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
			//	fileList.get(i).setBid(bid);
			}
		}
		
		int result2 = new MissingDao().insertAttachment2(con, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		return result;
	}


	public int ProgetListCount() {
		Connection con = getConnection();

		int listCount = new MissingDao().ProgetListCount(con);

		close(con);

		return listCount;
	}


	public ArrayList<HashMap<String, Object>> ProselectList(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().ProselectList(con,currentPage,limit);


		close(con);

		return list;
	}


	public int updatePro(Missing b) {
		Connection con = getConnection();

		int result = new MissingDao().missingupdateOutcon(con,b);
		int result2 = new MissingDao().proupdateOutcon2(con,b);

		if(result > 0) {
			commit(con);
		}else{
			rollback(con);
		}

		close(con);

	return result;
	}


	public HashMap<String, Object> missingselectThumbnailMap2(int num) {
		System.out.println("어딩ㅇㅇㅇㅇ");
Connection con = getConnection();
		
		HashMap<String, Object> hmap = null;
		ArrayList<Comment> list = null;
		int result = new MissingDao().missingupdateCount(con,num);
		System.out.println("result"+result);
		if(result > 0) {
			commit(con);
			hmap = new MissingDao().missingselectThumbnailMap2(con, num);
			list = new MissingDao().selectcoment(con,num);
		}else {
			rollback(con);
		}
		
		close(con);
		hmap.put("comment", list);
		
		return hmap;
		

		
		
		

	}


	public Missing missingselectup2(int num) {
		Connection con = getConnection();

		Missing ub = new MissingDao().missingselectup2(con, num);

		close(con);

	return ub;
	}


	public HashMap<String, Object> missingpaperSelect(int num) {
		System.out.println("어딩ㅇㅇㅇㅇ");
		Connection con = getConnection();
				
				HashMap<String, Object> hmap = null;
				hmap = new MissingDao().missingpaperSelect(con, num);
				
				close(con);
				
				
				return hmap;
			
	}


	public int MissinggetListCount2(String cont) {
		Connection con = getConnection();
		
		int listCount = new MissingDao().MissinggetListCount2(con,cont);
		
		close(con);
		
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList2(int currentPage, int limit, String cont) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList(con,currentPage,limit,cont);


		close(con);

		return list;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList3(int currentPage, int limit, String cont) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList2(con,currentPage,limit,cont);


		close(con);

		return list;
	}


	public int MissinggetListCount4(String cont) {
		Connection con = getConnection();

		int listCount = new MissingDao().MissinggetListCount3(con,cont);

		close(con);

		return listCount;
	}


	public int MissinggetListCount5(String cont) {
		Connection con = getConnection();

		int listCount = new MissingDao().MissinggetListCount4(con,cont);

		close(con);

		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList4(int currentPage, int limit, String cont) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList1(con,currentPage,limit,cont);


		close(con);

		return list;
	}


	public int PgetListCount2(String cont) {
Connection con = getConnection();
		
		int listCount = new MissingDao().PgetListCount2(con,cont);
		
		close(con);
		
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> PselectList2(int currentPage, int limit, String cont) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().PselectOutList(con,currentPage,limit,cont);


		close(con);

		return list;
	}


	public int PgetListCount4(String cont) {
		Connection con = getConnection();

		int listCount = new MissingDao().PgetListCount3(con,cont);

		close(con);

		return listCount;
	}


	public ArrayList<HashMap<String, Object>> PselectList3(int currentPage, int limit, String cont) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().PselectOutList2(con,currentPage,limit,cont);


		close(con);

		return list;
	}


	public int PgetListCount5(String cont) {
		Connection con = getConnection();

		int listCount = new MissingDao().PgetListCount4(con,cont);

		close(con);

		return listCount;
	}


	public ArrayList<HashMap<String, Object>> PselectList4(int currentPage, int limit, String cont) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().PselectOutList1(con,currentPage,limit,cont);


		close(con);

		return list;
	}


	public int MissinggetListCount7(String val) {
	Connection con = getConnection();
		
		int listCount = new MissingDao().MissinggetListCount7(con,val);
		
		close(con);
		
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList7(int currentPage, int limit, String val) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList7(con,currentPage,limit,val);


		close(con);

		return list;
	}


	public int MissinggetListCount8(String val) {
Connection con = getConnection();
		
		int listCount = new MissingDao().MissinggetListCount8(con,val);
		
		close(con);
		
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList8(int currentPage, int limit, String val) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList8(con,currentPage,limit,val);


		close(con);

		return list;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList9(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList9(con,currentPage,limit);


		close(con);

		return list;
	}


	public int MissinggetListCount9(String val) {
	Connection con = getConnection();
		
		int listCount = new MissingDao().MissinggetListCount9(con,val);
		
		close(con);
		
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList9(int currentPage, int limit, String val) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList9(con,currentPage,limit,val);


		close(con);

		return list;
	}


	public int MissinggetListCount11(String val) {
Connection con = getConnection();
		
		int listCount = new MissingDao().MissinggetListCount11(con,val);
		
		close(con);
		
		return listCount;
	}


	public ArrayList<HashMap<String, Object>> MissngselectList11(int currentPage, int limit, String val) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList11(con,currentPage,limit,val);


		close(con);

		return list;
	}

/*
	public ArrayList<HashMap<String, Object>> MissngselectList12(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList12(con,currentPage,limit);


		close(con);

		return list;
	}
*/

	public ArrayList<HashMap<String, Object>> MissngselectList17(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new MissingDao().MissingselectOutList17(con,currentPage,limit);


		close(con);

		return list;
	}


	public int report(MissingReport re) {
		Connection con = getConnection();
		int result = 0;

		result = new MissingDao().report(con,re);

		if(result >0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}


	public int re(int num, int uu) {
		Connection con = getConnection();
		int result = 0;

		result = new MissingDao().report(con,num,uu);

		
		System.out.println(result+"DDDDDDDDDDDDDDDDDDDDDD");
	/*	if(result >0) {
			commit(con);
		}else {
			rollback(con);
		}*/
		close(con);

		return result;
		
		
	
	}


	public int re2(int test, int test2) {
		Connection con = getConnection();
		int result = 0;
		int result2 = 0;

		result = new MissingDao().report2(con,test,test2);

		if(result >0) {
			result2= new MissingDao().report5(con,test,test2);
			commit(con);
			
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}


	public int re3(int test, int test2) {
		Connection con = getConnection();
		int result = 0;
		int result2=0;

		result = new MissingDao().report3(con,test,test2);

		if(result >0) {
			
			result2=new MissingDao().recde(con,test,test2);
					commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}


	public ArrayList<Comment> comment(Comment cm) {
		Connection con = getConnection();
		int result = 0;
		ArrayList<Comment> list = null;

		result = new MissingDao().insertcomment(con,cm);

		if(result > 0) {
			commit(con);
			 list = new MissingDao().selectcomment(con,cm.getbNo());

		}else {
			rollback(con);
		}

		close(con);



		return list;
	}


	public int reportCon(MissingReport re) {
		Connection con = getConnection();
		int result = 0;

		result = new MissingDao().reportCon(con,re);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);


		return result;
	}


	public ArrayList<Comment> comment2(Comment cm) {
		Connection con = getConnection();
		int result = 0;
		ArrayList<Comment> list = null;

		result = new MissingDao().insertcomment(con,cm);

		if(result > 0) {
			commit(con);
			 list = new MissingDao().selectcomment(con,cm.getbNo());

		}else {
			rollback(con);
		}

		close(con);



		return list;
	}


	public ArrayList<Comment> changeCo(int cNo,String con2, int bNo) {
		Connection con = getConnection();
		int result = 0;
		ArrayList<Comment> list = null;
		
		result = new MissingDao().changCo(con,cNo,con2);
		if(result > 0) {
			commit(con);
			System.out.println("성공했씁니다 아마도도도도");
			 list = new MissingDao().selectcomment(con,cNo,bNo);

		}else {
			rollback(con);
		}

		close(con);



		return list;

	}


	public ArrayList<Comment> commentdelete(Comment cm) {
		Connection con = getConnection();
		int result = 0;
		ArrayList<Comment> list = null;

		
	
			
			result=new MissingDao().deleteCo(con,cm.getConNo());
			System.out.println("뀨뀨뀨뀨뀨뀨뀨"+result);
			if(result>0) {
			 list = new MissingDao().selectcomment(con,cm.getbNo());
			 commit(con);
			}
			 
			 
			 
			 
			 
		close(con);



		return list;
	}










	

}