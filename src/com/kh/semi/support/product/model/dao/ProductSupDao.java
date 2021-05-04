package com.kh.semi.support.product.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.semi.support.product.model.vo.ProductSup;

public class ProductSupDao {

	private Properties prop = new Properties();

	public ProductSupDao() {
		String fileName =
				ProductSupDao.class.getResource("/sql/support/ProductSup-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMoneySupApp(Connection con, ProductSup ps) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertProductSupApp");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ps.getCtgCd());
			pstmt.setString(2, ps.getPdNm());
			pstmt.setInt(3, ps.getUserNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int okConfirmPost(Connection con, int monSupNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("okConfirmPost");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, monSupNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
