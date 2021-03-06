package org.kosta.myproject.model.vo;

public class ReviewVO {
	private String reviewNo;
	private String reviewTitle;
	private String reviewContent;
	private String reviewRegdate;
	private String reviewImage;
	private String reviewGrade;
	private MemberVO memberVO;
	private RestaurantVO restaurantVO;
	public ReviewVO() {
		super();
	}
	public ReviewVO(String reviewNo, String reviewTitle, String reviewContent, String reviewRegdate, String reviewImage,
			String reviewGrade, MemberVO memberVO, RestaurantVO restaurantVO) {
		super();
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewRegdate = reviewRegdate;
		this.reviewImage = reviewImage;
		this.reviewGrade = reviewGrade;
		this.memberVO = memberVO;
		this.restaurantVO = restaurantVO;
	}
	public String getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewRegdate() {
		return reviewRegdate;
	}
	public void setReviewRegdate(String reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}
	public String getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}
	public String getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(String reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public RestaurantVO getRestaurantVO() {
		return restaurantVO;
	}
	public void setRestaurantVO(RestaurantVO restaurantVO) {
		this.restaurantVO = restaurantVO;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent
				+ ", reviewRegdate=" + reviewRegdate + ", reviewImage=" + reviewImage + ", reviewGrade=" + reviewGrade
				+ ", memberVO=" + memberVO + ", restaurantVO=" + restaurantVO + "]";
	}
	
}
