package cn.segema.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CircleReviewsBiz {

	public List<CircleReviews> getPostComments(String circleId) {
		
		List<CircleReviews> circleReviewsList  = new ArrayList<CircleReviews>();
		CircleReviews circleReviews = new CircleReviews();
		circleReviews.setCircleId(circleId);
		circleReviews.setId(UUID.randomUUID().toString());
		circleReviews.setReview("review"+circleId);
		circleReviewsList.add(circleReviews);
		return circleReviewsList;
	}
}
