package com.myspring.pro30.board.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro30.board.service.BoardService;
import com.myspring.pro30.board.vo.ArticleVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController{
	
	private static final String ARTICLE_IMAGE_REPO = "/Users/seongju/Coding/JSP/Java_Web/file_repo";
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleVO articleVO;

	@Override
	@RequestMapping(value="/board/listArticles.do", 
				method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(
			HttpServletRequest request, 
			HttpServletResponse response
	) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List articlesList = boardService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
	}

	@Override
	@RequestMapping(value="/board/addNewArticle.do", method = RequestMethod.POST)
	public ResponseEntity addNewArticle(
			MultipartHttpServletRequest multipartRequest, 
			HttpServletResponse response
	) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> articleMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			articleMap.put(name, value);
		}

		return null;
	}

	@Override
	public ModelAndView viewArticle(int articleNO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
