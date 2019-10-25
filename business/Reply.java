package business;

import java.sql.Timestamp;

public class Reply {
private int rid;
private String rtitle;
private String rcontent;
private String rauthor;
private Timestamp rdate;
private int pid;

public Reply() {
	super();
}

public Reply(int rid, String rtitle, String rcontent, String rauthor, Timestamp rdate, int pid) {
	this.rid = rid;
	this.rtitle = rtitle;
	this.rcontent = rcontent;
	this.rauthor = rauthor;
	this.rdate = rdate;
	this.pid = pid;
}

public int getRid() {
	return rid;
}

public void setRid(int rid) {
	this.rid = rid;
}

public String getRtitle() {
	return rtitle;
}

public void setRtitle(String rtitle) {
	this.rtitle = rtitle;
}

public String getRcontent() {
	return rcontent;
}

public void setRcontent(String rcontent) {
	this.rcontent = rcontent;
}

public String getRauthor() {
	return rauthor;
}

public void setRauthor(String rauthor) {
	this.rauthor = rauthor;
}

public Timestamp getRdate() {
	return rdate;
}

public void setRdate(Timestamp rdate) {
	this.rdate = rdate;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}
}
