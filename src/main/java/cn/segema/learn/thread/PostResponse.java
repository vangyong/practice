package cn.segema.learn.thread;

import java.util.List;

public class PostResponse {

	private String id;
	private String userId;
	private List<CircleReviews> commentList;
	private List<CircleZan> supportList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<CircleReviews> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CircleReviews> commentList) {
		this.commentList = commentList;
	}

	public List<CircleZan> getSupportList() {
		return supportList;
	}

	public void setSupportList(List<CircleZan> supportList) {
		this.supportList = supportList;
	}

}
