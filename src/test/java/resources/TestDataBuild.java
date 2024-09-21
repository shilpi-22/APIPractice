package resources;

import Pojo.payload;
import Pojo.payloadFields;
import Pojo.payloadIssueType;
import Pojo.payloadProject;

public class TestDataBuild {

	public payload paylaodData() {
		   payload ip = new payload();
		    payloadFields ifields = new payloadFields();
		    payloadProject p = new payloadProject();
		    payloadIssueType itype = new payloadIssueType();
			ifields.setProject(p);
			ifields.setIssuetype(itype);
			itype.setName("Bug");
			p.setKey("SCRUM");
			ifields.setDescription("Buttons not working");
			ifields.setSummary("Buttons not working");
			ip.setFields(ifields);
			return ip;
	}
	
	public payload paylaodData(String description, String summary) {
		   payload ip = new payload();
		    payloadFields ifields = new payloadFields();
		    payloadProject p = new payloadProject();
		    payloadIssueType itype = new payloadIssueType();
			ifields.setProject(p);
			ifields.setIssuetype(itype);
			itype.setName("Bug");
			p.setKey("SCRUM");
			ifields.setDescription(description);
			ifields.setSummary(summary);
			ip.setFields(ifields);
			return ip;
	}
}
