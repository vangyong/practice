package cn.segema.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorDemo {

	static CircleReviewsBiz circleReviewsBiz = new CircleReviewsBiz();

	static CircleZanBiz circleZanBiz = new CircleZanBiz();

	public static void main(String[] args) {

		List<PostResponse> circleResponseList = new ArrayList<PostResponse>();
		int size = 5;
		ExecutorService commentPool = Executors.newFixedThreadPool(size);
		ExecutorService supportPool = Executors.newFixedThreadPool(size);

		try {
			List<Future> commentFutureList = new ArrayList<Future>(size);

			for (int i=0;i<5;i++) {
				final String circleId = String.valueOf(i);
				// 查评论列表
				Callable<List<CircleReviews>> callableComment = new Callable<List<CircleReviews>>() {
					@Override
					public List<CircleReviews> call() throws Exception {
						return circleReviewsBiz.getPostComments(circleId);
					}
				};
				Future f = commentPool.submit(callableComment);
				commentFutureList.add(f);
				
				// 查点赞列表
				Callable<List<CircleZan>> callableSupport = new Callable<List<CircleZan>>() {
					@Override
					public List<CircleZan> call() throws Exception {
						return circleZanBiz.findList(circleId);
					}
				};
				Future supportFuture = supportPool.submit(callableSupport);
				commentFutureList.add(supportFuture);
			}

			// 获取所有并发任务的执行结果
			int i = 0;
			PostResponse temp = null;
			List<CircleReviews> circleReviewsList = new ArrayList<CircleReviews>();
			
			
			
			
			for (Future f : commentFutureList) {
				System.out.println(f.get());
				
//				circleReviewsList.add(f.get());
//				temp.setCommentList( );
//				temp.setSupportList((List<CircleZan>) f.get());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭线程池
			commentPool.shutdown();
			supportPool.shutdown();
		}

	}

}
