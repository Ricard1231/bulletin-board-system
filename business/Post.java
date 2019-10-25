package business;

import java.sql.Timestamp;

public class Post {
	private int pid;
	private String pTitle;
	private String pContent;
	private String pAuthor;
	private Timestamp pDate;
	private int pReplies;
	private int pClicks;
	private String pLastUpdate;
	private String pLastAuthor;

	public Post() {
		super();
	}

	public Post(int pid, String pTitle, String pContent, String pAuthor, Timestamp pDate, int pReplies, int pClicks,
			String pLastUpdate, String pLastAuthor) {
		this.pid = pid;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pAuthor = pAuthor;
		this.pDate = pDate;
		this.pReplies = pReplies;
		this.pClicks = pClicks;
		this.pLastUpdate = pLastUpdate;
		this.pLastAuthor = pLastAuthor;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpAuthor() {
		return pAuthor;
	}

	public void setpAuthor(String pAuthor) {
		this.pAuthor = pAuthor;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public int getpReplies() {
		return pReplies;
	}

	public void setpReplies(int pReplies) {
		this.pReplies = pReplies;
	}

	public int getpClicks() {
		return pClicks;
	}

	public void setpClicks(int pClicks) {
		this.pClicks = pClicks;
	}

	public String getpLastUpdate() {
		return pLastUpdate;
	}

	public void setpLastUpdate(String pLastUpdate) {
		this.pLastUpdate = pLastUpdate;
	}

	public String getpLastAuthor() {
		return pLastAuthor;
	}

	public void setpLastAuthor(String pLastAuthor) {
		this.pLastAuthor = pLastAuthor;
	}

}
