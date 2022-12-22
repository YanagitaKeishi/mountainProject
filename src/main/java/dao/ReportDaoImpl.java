package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Report;

public class ReportDaoImpl implements ReportDao {
	
	private DataSource ds;
	
	public ReportDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Report> findAll() throws Exception {
		List<Report>reportList = new ArrayList<>();
		
		try(Connection con = ds.getConnection()){
			String sql = " SELECT report.id,report.name,erea,elevation,note,date,status,user.name AS user_name FROM report "
					+ "JOIN user ON report.report_id = user.login_id"
					+ " WHERE status = 'active' ORDER BY date";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				reportList.add(mapToUserReport(rs));
			}
		}catch(Exception e) {
			throw e;
		}
		return reportList;
	}

	@Override
	public List<Report> findByReportId(String reportId) throws Exception {
		List<Report>reportList = new ArrayList<>();
		
		try(Connection con = ds.getConnection()){
			String sql = " SELECT * FROM report WHERE status = 'active' AND report_id = ?"
					+" ORDER BY date ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, reportId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				reportList.add(mapToReport(rs));
			}
			
		}catch(Exception e) {
			throw e;
		}
		return reportList;
	}

	@Override
	public Report findById(Integer id) throws Exception {
		Report report = null;
		try(Connection con = ds.getConnection()){
			String sql = " SELECT * FROM report WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				report = mapToReport(rs);
				 
			}
			
		}catch(Exception e) {
			throw e;
		}
		return report;
		
	}

	@Override
	public void insert(Report report) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = " INSERT INTO report"
					+ " (id,name,erea,elevation,note,date,report_id)"
					+ " VALUES (null,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,report.getName());
			stmt.setString(2,report.getErea());
			stmt.setObject(3,report.getElevation());
			stmt.setString(4,report.getNote());
			stmt.setDate(5,(Date)report.getDate());
			stmt.setString(6,report.getReportId());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Report report) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = " UPDATE report SET name = ?, erea = ?, elevation = ?, note = ?, date = ?"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, report.getName());
			stmt.setString(2,report.getErea());
			stmt.setObject(3,report.getElevation());
			stmt.setString(4,report.getNote());
			stmt.setDate(5,(Date)report.getDate());
			stmt.setObject(6,report.getId(),Types.INTEGER);
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Integer id) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = " UPDATE report SET status = 'deleted' WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id);
			stmt.executeUpdate();

	}catch(Exception e) {
		throw e;
	}
	}
	
	//ログインユーザーの記録のみを閲覧
	private Report mapToReport(ResultSet rs) throws SQLException {
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("name");
		String erea = rs.getString("erea");
		Integer elevation = (Integer) rs.getObject("elevation");
		String note  = rs.getString("note");
		Date date = (Date) rs.getObject("date");
		String reportId = rs.getString("report_id");
		String status = rs.getString("status");
		return new Report(id,name,erea,elevation,note,date,reportId,status);
	}
	
	//全ユーザーの記録を閲覧
	private Report mapToUserReport(ResultSet rs) throws SQLException {
		Report report = new Report();
		report.setId((Integer) rs.getObject("id"));
		report.setName(rs.getString("name"));
		report.setErea(rs.getString("erea"));
		report.setElevation((Integer) rs.getObject("elevation")); 
		report.setNote(rs.getString("note"));
		report.setDate((Date)rs.getObject("date")); 
		report.setStatus(rs.getString("status"));
		report.setUserName(rs.getString("user_name"));
		//joinの途中、他のユーザーの記録を見たい
		return report;
	}
	
	

	
}
