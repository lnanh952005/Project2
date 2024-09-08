package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;

//data access layer

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	static final String url = "jdbc:mysql://localhost:3306/estatebasic";
	static final String user = "root";
	static final String pass = "123456";
	
	@Override
	public ArrayList<BuildingEntity> findAll(String name,String districtId) {
		
		StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
		
		if(name != null && name.equals("")==false ) {
			sql.append("and b.name like '%" + name + "%' ");
		}
		
		if(districtId != null && !districtId.equals("")) {
			sql.append("and b.districtId = " + districtId + " ");
		}
		
		ArrayList<BuildingEntity> result = new ArrayList<>();
		
		try(Connection con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql.toString());
				){
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberofbasement(rs.getString("numberofbasement"));
				result.add(building);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.print("connected database failed ......");
		}
		return result;
	}
	
	
}
