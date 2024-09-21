package resources;

public enum APIResources {

	CreateIssue("/rest/api/2/issue"),
	GetIssue(""),
	DeleteIssue("");
	private String resource;
	
	
	 APIResources(String resource) {
		this.resource = resource;
	}

	
	public String getResource() {
		return resource;
		
	}
		
	
	
	
}
