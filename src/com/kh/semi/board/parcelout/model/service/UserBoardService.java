package com.kh.semi.board.parcelout.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.semi.board.parcelout.model.dao.UserBoardDao;
import com.kh.semi.board.parcelout.model.vo.Attachment;
import com.kh.semi.board.parcelout.model.vo.Coment;
import com.kh.semi.board.parcelout.model.vo.Rec;
import com.kh.semi.board.parcelout.model.vo.Report;
import com.kh.semi.board.parcelout.model.vo.UserBoard;
import com.kh.semi.board.parcelout.model.dao.UserBoardDao;



public class UserBoardService {


	public int getListoutCount() {

		Connection con = getConnection();

		int listCount = new UserBoardDao().getoutListCount(con);

		close(con);

		return listCount;
	}
	public int getListoutCount2(String selectinput) {
		Connection con = getConnection();

		int listCount = new UserBoardDao().getListoutCount2(con,selectinput);
		close(con);

		return listCount;

	}
	public int getListoutCount3(String selectinput) {
		Connection con = getConnection();

		int listCount = new UserBoardDao().getListoutCount3(con, selectinput);

		close(con);

		return listCount;

	}



	public int insertOutuploadFiles(UserBoard b, ArrayList<Attachment> fileList) {
		Connection con = getConnection();

		int result = 0;

		int result1 = new UserBoardDao().insertOutuploadFiles(con, b);

		if(result1 > 0) {
			int bid = new UserBoardDao().selectCurrval(con);

			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setAttachmentNo(bid);
			}
			if(bid > 0) {
				System.out.println("이게 맞냐 진짜 확인 : " + bid);
				commit(con);
			}
		}

		int result2 = new UserBoardDao().insertAttachment(con , fileList);

		if(result1 > 0 && result2 >0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		close(con);

		return result;


	}
	public ArrayList<HashMap<String, Object>> selectOutList(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new UserBoardDao().selectOutList(con,currentPage,limit);


		close(con);

		return list;
	}
	public HashMap<String, Object> selectParceloutOne(int num, int uNo) {
			Connection con = getConnection();

			HashMap<String , Object> hmap = null;
			ArrayList<Coment> list = null;
			ArrayList<Integer> list2 = null;
			ArrayList<Integer> list3 = null;
			
			System.out.println("num 의 값 : " + num);
			int result = new UserBoardDao().updateCount(con , num);


			System.out.println("uNo 의 값  서비스 에서 : " + uNo);

			if(result > 0) {
				commit(con);

				hmap = new UserBoardDao().selectParceloutOne(con, num);

				list = new UserBoardDao().selectcoment(con,num);


				if(uNo > 0) {

				list2 = new UserBoardDao().selectRec(con,num,uNo);

				}

				list3 = new UserBoardDao().selectRecCount(con,num);



			}else {
				rollback(con);
			}

			close(con);


			hmap.put("coment", list);
			hmap.put("Rec", list2);
			hmap.put("selectRec", list3);

		return hmap;



	}
	public int updateRec(Rec re) {
			Connection con = getConnection();

			int result = new UserBoardDao().updateRec(con,re);

			if(result >0) {
				commit(con);
			}else {
				rollback(con);
			}
			close(con);




		return result;
	}
	public UserBoard selectmodified(int num) {
			Connection con = getConnection();

			UserBoard ub = new UserBoardDao().selectModified(con, num);

			close(con);

		return ub;
	}
	public int updateOutcon(UserBoard ub) {
			Connection con = getConnection();

			int result = new UserBoardDao().updateOutcon(con,ub);

			if(result > 0) {
				commit(con);
			}else{
				rollback(con);
			}

			close(con);

		return result;
	}
	public int deleteParcelout(int num) {
			Connection con = getConnection();

			int result = new UserBoardDao().deleteParcelout(con,num);

			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
			close(con);



		return result;
	}
	public ArrayList<HashMap<String, Object>> selectOutList2(int i, int j) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new UserBoardDao().selectOutList2(con,i,j);


		close(con);

		return list;
	}
	public ArrayList<HashMap<String, Object>> outselectConUno(String outselect, String selectinput, String currentPage4, int currentPage3, int limit) {
		Connection con = getConnection();


		ArrayList<HashMap<String,Object>> list = new UserBoardDao().outselectConUno(con,outselect,selectinput,currentPage4,currentPage3,limit);

		close(con);

		return list;
	}
	public ArrayList<HashMap<String, Object>> selectOutList3(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<HashMap<String,Object>> list = new UserBoardDao().selectOutList3(con,currentPage,limit);


		close(con);

		return list;


	}
	public ArrayList<HashMap<String, Object>> selectOutList4(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<HashMap<String,Object>> list = new UserBoardDao().selectOutList4(con,currentPage,limit);


		close(con);

		return list;
	}
	public int report(Report re) {
		Connection con = getConnection();
		int result = 0;

		result = new UserBoardDao().report(con,re);

		if(result >0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}
	public ArrayList<Coment> coment(Coment cm) {
		Connection con = getConnection();
		int result = 0;
		ArrayList<Coment> list = null;

		result = new UserBoardDao().insertcoment(con,cm);

		if(result > 0) {
			commit(con);
			 list = new UserBoardDao().selectcoment(con,cm.getbNo());

		}else {
			rollback(con);
		}

		close(con);



		return list;
	}
	public int Selectwrite(UserBoard ub) {
		Connection con = getConnection();
		int result = 0;

		result = new UserBoardDao().Selectwrite(con,ub);

		close(con);

		return result;
	}
	public int deleteRec(Rec re) {
			Connection con = getConnection();
			int result = 0;

			result = new UserBoardDao().deletRec(con,re);

			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}

			close(con);

		return result;
	}
	public int selectRecajax(Rec re) {
		Connection con = getConnection();
		int result = 0;

		result = new UserBoardDao().selectRecajax(con,re);

		close(con);

		return result;
	}
	public ArrayList selectRec10() {
		Connection con = getConnection();
		ArrayList list = null;
		ArrayList list2 = null;
		int result = 0;
		int result2 = 0;

		list = new UserBoardDao().selectRec10(con);

		list2 = new UserBoardDao().selectRec13(con);


		if(list2 != null) {

			result2 = new UserBoardDao().selectRec12(con,list2);

			if(result2 > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}


		if(list != null) {

			result = new UserBoardDao().selectRec11(con, list);

			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}

		}
		close(con);



		return list;
	}
	public int reportCon(Report re) {
		Connection con = getConnection();
		int result = 0;

		result = new UserBoardDao().reportCon(con,re);
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);


		return result;
	}
	public int deletcom(Coment cm) {
			Connection con = getConnection();
			int result = 0;

			result = new UserBoardDao().deletcom(con,cm);

			if(result > 0) {
				commit(con);

			}else {
				rollback(con);

			}
			close(con);


		return result;
	}
	public int updateComment(Coment cm) {
		Connection con = getConnection();
		int result = 0;

		result = new UserBoardDao().updateComment(con,cm);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}
	
	




}
