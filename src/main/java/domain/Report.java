package domain;

import java.sql.Date;

public class Report {
		
	private Integer id;
	private String name;
	private String erea;
	private Integer elevation;
	private String note;
	private Date date;
	private String reportId;
	private String status;
	private String userName;
	
	
	public Report() {
		
	}
	
	public Report(Integer id, String name, String erea, Integer elevation,
			String note, Date date, String reportId, String status) {
		this.id = id;
		this.name = name;
		this.erea = erea;
		this.elevation  = elevation;
		this.note = note;
		this.date = date;
		this.reportId = reportId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getErea() {
		return erea;
	}
	public void setErea(String erea) {
		this.erea = erea;
	}
	public Integer getElevation() {
		return elevation;
	}
	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
