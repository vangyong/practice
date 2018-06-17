package cn.segema.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CircleZanBiz {

	public List<CircleZan> findList(String circleId) {
		List<CircleZan> circleZanList = new ArrayList<CircleZan>();
		CircleZan circleZan = new CircleZan();
		circleZan.setCircleId(circleId);
		circleZan.setId(UUID.randomUUID().toString());
		circleZan.setMsg("msg"+circleId);
		circleZanList.add(circleZan);
		return circleZanList;
	}
}
