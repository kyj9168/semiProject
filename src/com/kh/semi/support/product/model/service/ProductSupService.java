package com.kh.semi.support.product.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.semi.support.money.model.dao.MoneySupDao;
import com.kh.semi.support.product.model.dao.ProductSupDao;
import com.kh.semi.support.product.model.vo.ProductSup;

public class ProductSupService {

	public int insertMoneySupApp(ProductSup ps) {
		Connection con = getConnection();

		int result = new ProductSupDao().insertMoneySupApp(con, ps);

		close(con);

		return result;
	}

	public int okConfirmPost(int monSupNo) {
		Connection con = getConnection();

		int result = new ProductSupDao().okConfirmPost(con, monSupNo);

		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		close(con);

		return result;
	}

}
