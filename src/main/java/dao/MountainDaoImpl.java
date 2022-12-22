package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Mountain;

public class MountainDaoImpl implements MountainDao {

	private DataSource ds;

	public MountainDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Mountain> findAll() throws Exception {
		List<Mountain> mountainList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = " SELECT * FROM mountain ";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				mountainList.add(mapToMountain(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return mountainList;
	}

	@Override
	//ReportServletで使用
	public Mountain findById(Integer id) throws Exception {
		Mountain mountain = new Mountain();
		try(Connection con = ds.getConnection()){
			String sql = " SELECT * FROM mountain WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				mountain = mapToMountain(rs);
			}
		}catch(Exception e) {
			throw e;
		}
		return mountain;
	}

	@Override
	public Mountain findByName(String name) throws Exception {
		Mountain mountain = new Mountain();
		try(Connection con = ds.getConnection()){
			String sql = " SELECT * FROM mountain WHERE name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				mountain = mapToMountain(rs);
			}
		}catch(Exception e) {
			throw e;
		}
		return mountain;
	}
	
	@Override
	public void insert(Mountain mountain) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Mountain mountain) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Mountain mountain) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	
	private Mountain mapToMountain(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("name");
		String erea = rs.getString("erea");
		Integer elevation = (Integer) rs.getObject("elevation");

		return new Mountain(id, name, erea, elevation);
	}

	@Override
	public List<Mountain> findByErea(String erea, String elevation) throws Exception {

		List<Mountain> mountainList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = " SELECT * FROM mountain WHERE erea = ?";
			if (elevation.equals("low")) {
				sql += " ORDER BY elevation";

			} else if (elevation.equals("high")) {
				sql += " ORDER BY elevation DESC";
			}

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, erea);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mountainList.add(mapToMountain(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return mountainList;
	}

	

	@Override
	public List<Mountain> sortAll(String elevation) throws Exception {
		List<Mountain> mountainList = new ArrayList<>();
		String sql = null;
		try (Connection con = ds.getConnection()) {
			if (elevation.equals("high")) {
				sql = " SELECT * FROM mountain " + " ORDER BY elevation DESC ";
			} else if (elevation.equals("low")) {
				sql = " SELECT * FROM mountain " + " ORDER BY elevation ";
			} else {
				sql = " SELECT * FROM mountain";
			}
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mountainList.add(mapToMountain(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return mountainList;

	}

}
