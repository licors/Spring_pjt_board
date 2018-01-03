package com.practice.spring_pjt_board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.spring_pjt_board.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping("/write") 
	public String write(Model model, HttpServletRequest req) {
		IDao dao = sqlSession.getMapper(IDao.class);
		logger.info("write data : {} , {}", req.getParameter("writer"), req.getParameter("content"));
		dao.writeDao(req.getParameter("writer"), req.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/view") 
	public String view(Model model, HttpServletRequest req) {
		IDao idao = sqlSession.getMapper(IDao.class);
		model.addAttribute("board_view", idao.viewDao(req.getParameter("bid")));
		return "view";
	}
	
	@RequestMapping("/delete") 
	public String delete(Model model, HttpServletRequest req) {
		IDao idao = sqlSession.getMapper(IDao.class);
		idao.deleteDao(req.getParameter("bid"));
		return "redirect:list";
	}
}
