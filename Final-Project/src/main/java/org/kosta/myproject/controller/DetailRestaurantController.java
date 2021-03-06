package org.kosta.myproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.myproject.model.vo.MemberVO;
import org.kosta.myproject.model.vo.PagingBean;
import org.kosta.myproject.model.vo.RestaurantVO;
import org.kosta.myproject.model.vo.ReviewVO;
import org.kosta.myproject.service.ReservationService;
import org.kosta.myproject.service.RestaurantService;
import org.kosta.myproject.service.ReviewService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailRestaurantController {
	@Resource
	private ReservationService reservationService;
	@Resource
	private RestaurantService restaurantService;
	@Resource
	private ReviewService reviewService;

	@RequestMapping("/user/detailRestaurant")
	public String detailRestaurant(Model model, String resNo, String pageNo) {
		/** 회원이 로그인 했는지 안했는지 먼저 판단하고 로그인 했으면 if문 아래로 쭉 실행 **/
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		if (!aut.getName().equals("anonymousUser")) {
			MemberVO mvo = (MemberVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("mvo", mvo);
			
			/** 어떤식당에서 예약할껀지 알기위해 해주는거 **/
			RestaurantVO restaurantVO = restaurantService.findRestaurantByResNo(resNo);
			model.addAttribute("restaurantVO", restaurantVO);
			
			/** 리뷰 목록 및 페이징 **/
			int totalReviewCount = reviewService.getTotalReviewCount(resNo);
			PagingBean pagingBean = null;
			
			if (pageNo == null) {
				pagingBean = new PagingBean(totalReviewCount);
			} else {
				pagingBean = new PagingBean(totalReviewCount, Integer.parseInt(pageNo));
			}
			model.addAttribute("pagingBean", pagingBean);
			model.addAttribute("totalReviewCount", totalReviewCount);
			List<ReviewVO> getAllReview = reviewService.getAllReviewList(pagingBean, resNo);
			model.addAttribute("reviewList", getAllReview);
			
			for(int i=0; i<getAllReview.size(); i++) {
				System.out.println("리뷰 리스트:"+getAllReview.get(i));
			}
		}
		return "detailRestaurant.tiles";
	}
}
