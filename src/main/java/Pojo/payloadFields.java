package Pojo;

public class payloadFields {
private payloadProject project;
private String summary;
private String description;
private payloadIssueType issuetype;

public payloadProject getProject() {
	return project;
}
public void setProject(payloadProject project) {
	this.project = project;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public payloadIssueType getIssuetype() {
	return issuetype;
}
public void setIssuetype(payloadIssueType issuetype) {
	this.issuetype = issuetype;
}


}
