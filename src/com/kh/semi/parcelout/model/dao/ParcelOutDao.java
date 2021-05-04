package com.kh.semi.parcelout.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.entrance.model.vo.EntranceDogInfo;
import com.kh.semi.parcelout.model.vo.Application;
import com.kh.semi.parcelout.model.vo.ParcelOut;
import com.kh.semi.parcelout.model.vo.ParcelOutQuestion;
import com.kh.semi.parcelout.model.vo.parceOutAnswer;
import com.kh.semi.user.model.vo.User;

import static com.kh.semi.common.JDBCTemplate.*;

public class ParcelOutDao {

	private Properties prop = new Properties();

	public ParcelOutDao() {

		String fileName = ParcelOutDao.class.getResource("/sql/parceloutApplication/application-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public int insertApplication(Connection con, User us, Application ap) {
			PreparedStatement pstmt = null;
			int result = 0;

			String query = prop.getProperty("PcoApp");

			try {
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, us.getUserNo());
				pstmt.setString(2, ap.getday());
				pstmt.setString(3, "N");




				result = pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}




		return result;
	}


	public int insertApplication2(Connection con, ArrayList<Application> list) {
			PreparedStatement pstmt = null;
			int result = 0;




			try {
				String test = "";
				for(int i = 1; i <= list.size(); i++) {

					String query = prop.getProperty("insertApplication2");
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1 , i);
					if(i <= 3 || i == 9 || i == 10 || i == 11 || i == 13) {
						test = "서술";
						pstmt.setString(2, test);
					}else if(i == 4 || i == 6 || i == 7 || i == 16 || i == 17) {
						test = "선다";
						pstmt.setString(2, test);
					}else if(i == 5 || i == 8 || i == 12 || i == 14 || i== 15 ||i ==18 || i ==19){
						test = "선택";
						pstmt.setString(2, test);
					}
					pstmt.setString(3, list.get((i-1)).getApplication());
					pstmt.setString(4, "Q"+i);

					result = pstmt.executeUpdate();
					System.out.println("여기 안들어오냐 ?");

				}




			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}


		return result;
	}


	public ParcelOut parceloutInfo(Connection con, int pcoAppNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ParcelOut pco =null;
		
		String query = prop.getProperty("pcoInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				
				pco = new ParcelOut();
				
				pco.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				pco.setUserNo(rset.getInt("USER_NO"));
				pco.setSelAppDt(rset.getString("SEL_APP_DT"));
				pco.setPcoSit(rset.getString("PCO_SIT"));
				pco.setCompanionRs(rset.getString("COMPANION_RS"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pco;
	}


	public ArrayList<parceOutAnswer> parceloutqanda(Connection con, int pcoAppNo) {
		
		ArrayList<parceOutAnswer> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		parceOutAnswer poa = null;
		
		String query = prop.getProperty("qandaInfo");
		
		try {
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				poa = new parceOutAnswer();
				poa.setPcoAppNo(rset.getInt("PCO_APP_NO"));
				poa.setPcoQuNo(rset.getInt("PCO_QU_NO"));
				poa.setAnsDt(rset.getDate("ANS_DT"));
				poa.setAnsKind(rset.getString("ANS_KIND"));
				poa.setAnsCon(rset.getString("ANS_CON"));
				poa.setAnsRs(rset.getString("ANS_RS"));
				poa.setQuCd(rset.getString("QU_CD"));
				poa.setOpNo(rset.getInt("OP_NO"));
				
				list.add(poa);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<ParcelOutQuestion> parceloutquestion(Connection con, int pcoAppNo) {

		ArrayList<ParcelOutQuestion> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ParcelOutQuestion poq =null;
		
		String query = prop.getProperty("question");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, pcoAppNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				
				poq = new ParcelOutQuestion();
				poq.setQuCd(rset.getString("QU_CD"));
				poq.setQuCon(rset.getString("QU_CON"));
				poq.setQuKind(rset.getString("QU_KIND"));
				
				list.add(poq);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

}
