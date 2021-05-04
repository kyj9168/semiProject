package com.kh.semi.sel.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.semi.sel.model.dao.SelSitDao;
import com.kh.semi.sel.model.vo.SelSit;

public class SelSitService {

	public ArrayList<String> selectSelDayforDate(String result) {
		Connection con = getConnection();

		ArrayList<String> list = new SelSitDao().selectSelDayforDate(con, result);

		close(con);

		return list;
	}

	public ArrayList<String> selectSelDayforDatePco(String result) {
		Connection con = getConnection();

		ArrayList<String> list = new SelSitDao().selectSelDayforDatePco(con, result);

		close(con);

		return list;
	}

	public HashMap<String, Object> selectAllSelDate(String result) {
		Connection con = getConnection();
		HashMap<String, Object> list = new HashMap<String, Object>();

		ArrayList<SelSit> list1 = new SelSitDao().selectAllSelEntranceDate(con, result);
		ArrayList<SelSit> list2 = new SelSitDao().selectAllSelParceloutDate(con, result);

		list.put("entrance", list1);
		list.put("parcelout", list2);

		close(con);

		return list;
	}

	public HashMap<String, Object> selectTodaySelHistory() {
		Connection con = getConnection();
		HashMap<String, Object> list = new HashMap<String, Object>();

		ArrayList<SelSit> list1 = new SelSitDao().selectTodaySelEntranceHistory(con);
		ArrayList<SelSit> list2 = new SelSitDao().selectTodaySelParcelHistory(con);

		list.put("entrance", list1);
		list.put("parcelout", list2);

		close(con);

		return list;
	}

	public int updateSelsitParcel(int selNo, String result) {
		Connection con = getConnection();
		int num = 0;
		String selNoString = String.valueOf(selNo).toString();

		if(result.equals("완료")) {
			int num1 = new SelSitDao().updateSelSitPco(con, selNoString);
			if(num1 > 0) {
				commit(con);
				int num2 = new SelSitDao().selectPcoNo(con, selNoString);
				System.out.println("신청번호 ? " + num2);
				int num3 = new SelSitDao().updateAppSitPco(con, num2);
				if(num3 > 0) {
					commit(con);
					num++;
				}else {
					rollback(con);
				}
			}else {
				rollback(con);
			}
		}else {
			int num1 = new SelSitDao().updateSelSitPco2(con, selNoString);
			if(num1 > 0) {
				commit(con);
				int num2 = new SelSitDao().selectPcoNo(con, selNoString);
				num = new SelSitDao().updateAppSitPcoNo(con, num2);
				if(num > 0) {
					commit(con);
				}else {
					rollback(con);
				}
			}else {
				rollback(con);
			}
		}

		return num;
	}

	public int updateSelsitEntrance(int selNo, String result) {
		Connection con = getConnection();
		int num = 0;
		String selNoString = String.valueOf(selNo).toString();

		if(result.equals("완료")) {
			int num1 = new SelSitDao().updateEntSelSit(con, selNoString);
			if(num1 > 0) {
				commit(con);
				int num2 = new SelSitDao().selectEntNo(con, selNoString);
				int num3 = new SelSitDao().updateEntApplySit(con, num2);
				if(num3 > 0) {
					commit(con);
					num = new SelSitDao().updateEntDogInfoSit(con, num2);
					if(num > 0) {
						commit(con);
					}else {
						rollback(con);
					}
				}else {
					rollback(con);
				}
			}else {
				rollback(con);
			}

		}else {
			int num1 = new SelSitDao().updateEntSelSitNo(con, selNoString);
			if(num1 > 0) {
				commit(con);
				int num2 = new SelSitDao().selectEntNo(con, selNoString);
				int num3 = new SelSitDao().updateEntApplySitNo(con, num2);
				if(num3 > 0) {
					commit(con);
					num = new SelSitDao().updateEntDogInfoSitNo(con, num2);
					if(num > 0) {
						commit(con);
					}else {
						rollback(con);
					}
				}else {
					rollback(con);
				}
			}else {
				rollback(con);
			}
		}

		return num;
	}

}
