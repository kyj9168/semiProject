package com.kh.semi.user.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.entrance.model.vo.Entrance;
import com.kh.semi.user.controller.LoginServlet;
import com.kh.semi.user.model.dao.UserDao;
import com.kh.semi.user.model.vo.User;

public class UserService {

	public User loginCheck(User reqUser) {

		Connection con = getConnection();
		int result = 0;
		User loginUser = new User();
		UserDao md = new UserDao();

		if (reqUser.getPwdHis().equals("Y")) {
			int remember = md.rememberPwd(con, reqUser);
			if (remember > 0) {
				commit(con);
			} else {
				rollback(con);
			}
		} else {

		}

		result = md.checkStatus(con, reqUser);
		System.out.println("결과숫자 : " + result);

		if (result == LoginServlet.LOGIN_OK) {
			loginUser = md.selectOne(con, reqUser);
			loginUser.setStatusNum(LoginServlet.LOGIN_OK);
			System.out.println("결과객체  : " + loginUser);
		} else if (result == LoginServlet.WRONG_PASSWORD) {
			loginUser.setStatusNum(LoginServlet.WRONG_PASSWORD);
		} else {
			loginUser.setStatusNum(LoginServlet.EXIT_NOT_MEMBER);
		}

		close(con);

		return loginUser;
	}

	public int signupUser(User ur) {
		Connection con = getConnection();

		UserDao ud = new UserDao();

		int result = ud.signupUser(con, ur);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public User updateUser(User u) {
		Connection con = getConnection();
		User loginUser = null;

		int result = new UserDao().updateUser(con, u);

		if (result > 0) {
			commit(con);
			loginUser = new UserDao().updateSelect(con, u);
		} else {
			rollback(con);
		}
		close(con);

		return loginUser;

	}

	public ArrayList<User> selectList(int currentPage, int limit) {

		Connection con = getConnection();

		ArrayList<User> list = new UserDao().selectList(con, currentPage, limit);

		close(con);

		return list;
	}

	public int secessionUser(String leaveRsCd, int userNo) {
		Connection con = getConnection();

		int result = new UserDao().secessionUser(con, leaveRsCd, userNo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int deleteUser(int userNo) {

		Connection con = getConnection();
		User deleteUser = null;

		int result = new UserDao().deleteUser(con, userNo);

		if (result > 0) {
			commit(con);

		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int modifyUser(User ur) {

		Connection con = getConnection();

		int result = new UserDao().modifyUser(con, ur);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;

	}

	public User getUser(String userId) {

		Connection con = getConnection();

		User user = new UserDao().getUser(con, userId);

		close(con);

		return user;
	}

	public int getListCount() {
		Connection con = getConnection();

		int listCount = new UserDao().getListCount(con);

		close(con);

		return listCount;
	}

	public User rememberPwd(String userId) {
		Connection con = getConnection();

		User u = new UserDao().rememberPwd2(con, userId);

		close(con);

		return u;

	}

	public User passLoginUser(String userId) {
		Connection con = getConnection();

		User u = new UserDao().passLoginUser(con, userId);

		close(con);

		return u;
	}

	public int idCheck(String userId) {
		Connection con = getConnection();

		int result = new UserDao().idCheck(con, userId);

		close(con);

		return result;
	}

	public int NickCheck(String nickNm) {
		Connection con = getConnection();

		int result = new UserDao().NickCheck(con, nickNm);

		close(con);

		return result;
	}

	public User userInfo(int userNo) {

		Connection con = getConnection();

		User user = new UserDao().getUserInfo(con, userNo);

		close(con);

		return user;

	}

	public int kakaologin(User ur) {

		Connection con = getConnection();

		int result = new UserDao().kakaologin(con, ur);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;

	}

	public int kakaoSignup(User ur) {

		Connection con = getConnection();

		int result = new UserDao().kakaoSignup(con, ur);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public ArrayList<Integer> reportCount(ArrayList<User> list) {

		Connection con = getConnection();

		ArrayList<Integer> reportCount = null;

		reportCount = new UserDao().reportCount(con,list);

		return reportCount;
	}

	public User selectfind(String userId, String email) {
		Connection con = getConnection();

		User us = new UserDao().selectfind(con,userId,email);

		close(con);

		return us;
	}

	public int selectfindpwd(User us) {
		Connection con = getConnection();

		int result = 0;

		result = new UserDao().selectfindpwd(con,us);

		close(con);

		return result;
	}

	public int updatesign(User us) {
		Connection con = getConnection();

		int result = 0;

		result = new UserDao().updatesign(con,us);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);

		return result;

	}

	public User entUser(Entrance et) {
		
		Connection con = getConnection();
		
		User us = new UserDao().entUser(con,et);
		
		close(con);
		
		return us;
	}

	public int pwCheck(String password, String userId) {
		
		Connection con = getConnection();

		int result = new UserDao().pwCheck(con,password ,userId);

		close(con);

		return result;
	}

}
