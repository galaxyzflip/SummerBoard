package net.nice19.smboard.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.nice19.smboard.board.model.BoardModel;
import net.nice19.smboard.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	private ApplicationContext context = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
	private BoardService boardService = (BoardService) context.getBean("boardService");
	
	private int currentPage = 1;
	private int showArticleLimit = 10;
	private int showPageLimit;
	private int startArticleNum = 0;
	private int endArticleNum = 0;
	private int totalNum = 0;
	
	private String uploadPath = "C:\\Users\\EZEN\\git\\repository4\\SummerBoard\\src\\main\\webapp\\files";
	
	
	@RequestMapping("/list.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		String type = null;
		String keyword = null;
		
		if(request.getParameter("page") == null || request.getParameter("page").isBlank()) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		if(request.getParameter("type") != null) {
			type = request.getParameter("type").trim();
		}
		
		if(request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword").trim();
		}
		
		startArticleNum = (currentPage - 1) * showArticleLimit + 1;
		endArticleNum = startArticleNum + showArticleLimit - 1;
		
		List<BoardModel> boardList;
		if(type != null && keyword != null) {
			boardList = boardService.searchArticle(type, keyword, startArticleNum, endArticleNum);
			totalNum = boardService.getTotalNum();
			
		}else {
			boardList = boardService.getBoardList(startArticleNum, endArticleNum);
			totalNum = boardService.getTotalNum();
			
		}
		
		StringBuffer pageHtml = getPageHtml(currentPage, totalNum, showArticleLimit, showPageLimit);
			
		
		
		
		return mav;
		
	}


	private StringBuffer getPageHtml(int currentPage2, int totalNum2, int showArticleLimit2, int showPageLimit2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
