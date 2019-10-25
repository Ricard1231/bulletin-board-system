package business;

import java.sql.Timestamp;

public class ReplyUser {
private String userlogo;
private Timestamp udate;
private Reply reply;

public ReplyUser() {
	super();
}

public ReplyUser(String userlogo, Timestamp udate, Reply reply) {
	this.userlogo = userlogo;
	this.udate = udate;
	this.reply = reply;
}

public String getUserlogo() {
	return userlogo;
}

public void setUserlogo(String userlogo) {
	this.userlogo = userlogo;
}

public Timestamp getUdate() {
	return udate;
}

public void setUdate(Timestamp udate) {
	this.udate = udate;
}

public Reply getReply() {
	return reply;
}

public void setReply(Reply reply) {
	this.reply = reply;
}


}
