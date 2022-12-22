package domain;


public class Mountain {
	
	private Integer id;
	private String name;
	private String erea;
	private Integer elevation;
	
	public Mountain() {
		
	}
	
	public Mountain(Integer id, String name, String erea, Integer elevation) {
		this.id = id;
		this.name = name;
		this.erea = erea;
		this.elevation = elevation;
		
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

}
