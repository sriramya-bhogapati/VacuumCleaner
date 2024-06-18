package com.edubridge.VacuumCleaner.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.VacuumCleaner.DBUtil.DBUtils;
import com.edubridge.VacuumCleaner.model.VacuumCleaner;


public class VacuumCleanerDaoImpl {

		static Connection con = DBUtils.getConnection();

		public int addVacuumCleaner(VacuumCleaner vc) {
			 String INSERT_QUERY = "insert into VacuumCleaner(brand,filtertype,powersource,price,rating)values(?,?,?,?,?)";
			 int status =0;
			 try {
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
				ps.setString(1, vc.getBrand());
				ps.setString(2, vc.getfiltertype());
				ps.setString(3, vc.getpowersource());
			    ps.setFloat(4,  vc.getprice());
			    ps.setFloat(5, vc.getrating());
			    
				
				status = ps.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return status;
		}
		public List<VacuumCleaner> findVacuumCleaner() {
			String SELECT_QUERY = "select * from VacuumCleaner";
			List<VacuumCleaner>VacuumCleanerList = new ArrayList<>();
				try {
				PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					VacuumCleaner vc = new VacuumCleaner();
					vc.setBrand(rs.getString("brand"));
					vc.setFilterType(rs.getString("filtertype"));
					vc.setpowersource(rs.getString("powersource"));
					vc.setprice(rs.getFloat("price"));
					vc.setrating(rs.getFloat("rating"));
					VacuumCleanerList.add(vc);
					
				}
			} catch (SQLException e) {
				
						
				e.printStackTrace();
			}
			return VacuumCleanerList;
			
		}

		public VacuumCleaner findVacuumCleanerByBrand(String brand) {
			VacuumCleaner vc = null;
		String SELECT_QUERY = "select * from vacuumcleaner where brand = ?";
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1,brand );
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vc=new VacuumCleaner();
				vc.setBrand(rs.getString("brand"));
				vc.setFilterType(rs.getString("filtertype"));
				vc.setpowersource(rs.getString("powersource"));
				vc.setprice(rs.getFloat("price"));
				vc.setrating(rs.getFloat("rating"));		
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
				return vc;
			
		}

		public int update(VacuumCleaner vc) {
			String UPDATE_QUERY = "update VacuumCleaner set brand=?,filtertype=?,powersource=?,price=?,rating=? where brand=?";
			int status = 0;
			try {
				PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
				
				ps.setString(1, vc.getBrand());
				ps.setString(2, vc.getfiltertype());
				ps.setString(3, vc.getpowersource());
				ps.setFloat(4,vc.getprice());
				ps.setFloat(5, vc.getrating());
				
				status = ps.executeUpdate();
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return status;
			
		}

		public int deleteVacuumCleanerByBrand(String brand) {
			String DELETE_QUERY = "delete from VacuumCleaner where brand=?";
			int status = 0;
			try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, brand);
			status = ps.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return status;
		}

		public void deleteAllVacuumCleaners() {
			String DELETE_QUERY = "delete from VacuumCleaner";
			try {
				PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}