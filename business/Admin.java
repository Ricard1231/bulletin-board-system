package business;

public class Admin {
private String adname;
private String adpw;

public Admin() {
	super();
}

public Admin(String adname, String adpw) {
	this.adname = adname;
	this.adpw = adpw;
}

public String getAdname() {
	return adname;
}

public void setAdname(String adname) {
	this.adname = adname;
}

public String getAdpw() {
	return adpw;
}

public void setAdpw(String adpw) {
	this.adpw = adpw;
}


}
