package com.ssafy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/dept")
@Controller
public class DeptController {
	
	private final DeptService deptService;
	
	public DeptController(DeptService deptService) {
		super();
		this.deptService = deptService;
	}

//	@Override
//	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String uri = request.getServletPath().substring(5);
//		
//		if("/rest/list.do".equals(uri)) {
//			return deptRestList(request,response);
//		}else if("/modify.do".equals(uri)) {
//			return modifyDept(request,response);
//		}else if("/search.do".equals(uri)) {
//			return searchDeptList(request,response);
//		}
//		throw new IllegalAccessException("요청에 부합하는 컨트롤러가 존재하지 않습니다.");
//	}
//	
	@GetMapping("/list.do")
	protected ModelAndView deptList(HttpServletRequest request) 
			throws Exception {
		
		List<Dept> depts = deptService.getDepts();
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("depts", depts);
		
		return mav;
	}

//	protected DataInfo deptRestList(HttpServletRequest request, HttpServletResponse response) 
//			throws Exception {
//		return new DataInfo("application/json", deptService.getDepts());
//	}
//	
	@GetMapping("/detail.do")
	protected String deptDetail(@RequestParam("deptNo") int deptNo, Model model) 
		throws Exception {
		ModelAndView mav = new ModelAndView("detail");
		
		Dept dept = deptService.getDept(deptNo);
		
		model.addAttribute("dept",dept);
		
		return "detail"; // String 으로 반환 시 알아서 ViewName으로...
	}
	
	@PostMapping("/remove.do")
	protected String removeDept(@RequestParam("deptNo") int deptNo, Model model) 
			throws Exception {
		boolean result = deptService.removeDept(deptNo);
		
		if(result) { // 삭제 성공
			return "redirect:/dept/list.do";
		}else {
			model.addAttribute("errorMsg", "존재하지 않는 부서의 삭제를 시도하였습니다.");
			return "error";
		}
	}
	

	@PostMapping("/register.do")
	protected String registerDept(Dept dept, Model model) 
			throws Exception {

		boolean result = deptService.registerDept(dept);
		if(result) { // 등록 성공
			//   /dept/list.do
			return "redirect:/dept/list.do";
		}else {
			model.addAttribute("errorMsg", "이미 해당 부서가 존재합니다.");
			return "error";
		}
	}
	
	@PostMapping("/modify.do")
	protected String modifyDept(Dept dept) 
			throws Exception {
		
		deptService.modifyDept(dept);

		return "redirect:/dept/list.do";

	}
	
	@PostMapping("/search.do")
	protected String searchDeptList(@ModelAttribute String dname, Model model) 
			throws Exception {
		List<Dept> depts = deptService.getDepts(dname);
		model.addAttribute("depts", depts);
		
		return "redirect:/dept/list.do";
	}
	
//	@ExceptionHandler
//	public String handelException(Exception e, Model model) {
//		model.addAttribute("errorMsg", e.getMessage());
//		return "error";
//	}


}
