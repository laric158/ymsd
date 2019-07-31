package cn.itsource.cms.model;

/**
 * 对应数据库的t_news表
 * 
 * @author st
 *
 */
public class News {
	private Long id;
	private String title;
	private String context;
	private String imgUrl;
	private int viewCount;
	private boolean isRecommend;
	private String inputDate;
	private Long type_id;
	private Long user_id;
	private String imgSmallUrl;
	
	private NewsType newsType;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public boolean getIsRecommend() {
		return isRecommend;
	}

	public void setRecommend(boolean isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getImgSmallUrl() {
		return imgSmallUrl;
	}

	public void setImgSmallUrl(String imgSmallUrl) {
		this.imgSmallUrl = imgSmallUrl;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", context=" + context + ", imgUrl=" + imgUrl + ", viewCount="
				+ viewCount + ", isRecommend=" + isRecommend + ", inputDate=" + inputDate + ", type_id=" + type_id
				+ ", user_id=" + user_id + ", imgSmallUrl=" + imgSmallUrl + "]";
	}

}
