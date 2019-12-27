package com.internousdev.webproj5.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj5.dto.InquiryDTO;
import com.internousdev.webproj5.util.DBConnector;

public class InquiryDAO {

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO> ();

	public List<InquiryDTO>select(){
		DBConnector db = new DBConnector();
		Connection conn = db.getConnection();
		String sql = "select * from inquiry";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				InquiryDTO dto = new InquiryDTO();
				dto.setName(rs.getString("name"));
				dto.setQtype(rs.getString("qtype"));
				dto.setBody(rs.getString("body"));
				inquiryDTOList.add(dto);
			}//while
		}//try

		catch(SQLException e){e.printStackTrace();}
		try{conn.close();}
		catch(SQLException e){e.printStackTrace();}

		return inquiryDTOList;

	}//select

	public int insert(String name,String qtype,String body){

		int ret = 0;
		DBConnector db = new DBConnector();
		Connection conn = db.getConnection();
		String sql = "insert into inquiry values(?,?,?)";

		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, qtype);
			ps.setString(3, body);

			int i = ps.executeUpdate();

			if(i>0){
				System.out.println(i + "件登録されました。");
				ret = i;
			}//if
		}//try

		catch(SQLException e){e.printStackTrace();}
		try{conn.close();}
		catch(SQLException e){e.printStackTrace();}

		return ret;

	}//int
}//class
