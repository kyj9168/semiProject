package com.kh.semi.support.model.service;

import static com.kh.semi.common.JDBCTemplate.*;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.semi.adminboard.model.dao.AdminBoardDao;
import com.kh.semi.support.model.dao.SupportDao;
import com.kh.semi.support.money.model.vo.MoneySup;
import com.kh.semi.support.product.model.vo.ProductSup;

public class SupportService {

	public HashMap<String, Object> selectAllSupport(int userNo, int currentPage, int currentPage2, int limit, int limit2) {
		Connection con = getConnection();
		HashMap<String, Object> list = new HashMap<String, Object>();

		ArrayList<MoneySup> moneyList = new SupportDao().selectAllMoneySupport(con, userNo, currentPage, limit);
		ArrayList<ProductSup> productList = new SupportDao().selectAllProduntSupport(con, userNo, currentPage2, limit2);

		list.put("moneyList", moneyList);
		list.put("productList", productList);

		return list;
	}

	public int getSupportMoneyAllListCount(int userNo) {
		Connection con = getConnection();

		int listCount = new SupportDao().getSupportMoneyAllListCount(con, userNo);

		close(con);

		return listCount;
	}

	public int getSupportProductAllListCount(int userNo) {
		Connection con = getConnection();

		int listCount2 = new SupportDao().getSupportProductAllListCount(con, userNo);

		close(con);

		return listCount2;
	}

	public HashMap<String, Object> selectAllUserSupport(int currentPage, int currentPage2, int limit, int limit2) {
		Connection con = getConnection();
		HashMap<String, Object> list = new HashMap<String, Object>();

		ArrayList<MoneySup> moneyList = new SupportDao().selectAllUserMoneySupport(con, currentPage, limit);
		ArrayList<ProductSup> productList = new SupportDao().selectAllUserProduntSupport(con, currentPage2, limit2);

		list.put("moneyList", moneyList);
		list.put("productList", productList);

		return list;
	}

	public int getSupportMoneyAllUserListCount() {
		Connection con = getConnection();

		int listCount = new SupportDao().getSupportMoneyAllUserListCount(con);

		close(con);

		return listCount;
	}

	public int getSupportProductAllUserListCount() {
		Connection con = getConnection();

		int listCount2 = new SupportDao().getSupportProductAllUserListCount(con);

		close(con);

		return listCount2;
	}

	public HashMap<String, String> selectUserBillingKey(int monSupNo) {
		Connection con = getConnection();

		HashMap<String, String> result = new HashMap<String, String>();

		String billingkey = new SupportDao().selectUserBillingKey(con, monSupNo);
		String order_id = new SupportDao().selectUserOrderId(con, monSupNo);
		String supportDay = new SupportDao().selectUserSupportDay(con, monSupNo);

		System.out.println("order_Id : " + order_id);

		result.put("billingkey", billingkey);
		result.put("order_id", order_id);
		result.put("supportDay", supportDay);

		close(con);

		return result;
	}

	public String updateRegualSupport(String receipt_id, int monSupNo) {
		Connection con = getConnection();
		String email = null;

		int result = new SupportDao().updateReceipt_id(con, receipt_id, monSupNo);

		if(result > 0) {
			commit(con);
			email = new SupportDao().selectUserEmail(con, monSupNo);
		}else {
			rollback(con);
		}

		close(con);

		return email;
	}

}
