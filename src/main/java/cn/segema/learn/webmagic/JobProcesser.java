package cn.segema.learn.webmagic;

import java.util.List;

import org.jsoup.Jsoup;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class JobProcesser implements PageProcessor {

	@Override
	public void process(Page page) {
		// 解析页面 获取招聘信息详情的url地址
		List<Selectable> list = page.getHtml().css("div#resultList div.el").nodes();
		// 判断获取到的集合是否为空 如果为空表示这是招聘详情页 如果不为空表示这是列表页
		if (list.size() == 0) {
			// 如果为空 表示这是招聘详情页 解析页面获取招聘信息 保存数据
			this.saveJobInfo(page);
		} else {
			// 如果不为空 解析详情页的url地址 放到任务队列中
			for (Selectable selectable : list) {
				String jobInfoUrl = selectable.links().toString();
				page.addTargetRequest(jobInfoUrl); // 把获取到的url地址放到任务队列中
			}
			// 获取下一页的url
			String bkurl = page.getHtml().css("div.p_in li.bk").nodes().get(1).links().toString();
			// 把url放到任务队列中
			page.addTargetRequest(bkurl);
		}
	}

	// 解析页面获取招聘信息 保存数据
	private void saveJobInfo(Page page) {
		Job job = new Job();
		Html html = page.getHtml();
		job.setCompanyName(String.valueOf(html.css("div.cn p.cname a", "text")));
		job.setCompanyAddr(Jsoup.parse(html.css("div.bmsg").nodes().get(1).toString()).text());
		job.setCompanyInfo(Jsoup.parse(html.css("div.tmsg").toString()).text());
		job.setJobName(html.css("div.cn h1", "text").toString());
		job.setJobAddr(html.css("div.cn p.msg", "title").toString());
		job.setJobInfo(Jsoup.parse(html.css("div.job_msg").toString()).text());
		job.setUrl(page.getUrl().toString());
		job.setSalaryMax(Jsoup.parse(html.css("div.cn strong").toString()).text());
		job.setSalaryMin("");
		String time = html.css("div.cn p.msg", "title").toString();
		job.setTime(time.substring(time.length() - 8));
		page.putField("jobinfo", job);

	}

	private Site site = Site.me().setCharset("gbk").setTimeOut(10 * 1000) // 超时时间
			.setRetrySleepTime(3000).setRetryTimes(3);

	@Override
	public Site getSite() {
		return site;
	}

}
