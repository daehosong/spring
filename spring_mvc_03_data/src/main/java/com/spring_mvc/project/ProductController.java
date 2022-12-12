package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@RequestMapping("/product/productForm")
	public String productForm() {
		return "product/productForm";
	}
	
	@RequestMapping("/product/newProduct")
		public String newStudent(HttpServletRequest request, Model model) {
			//form의 각 input 태그의 name 속성 값 받아오기
			String prdNo = request.getParameter("prdNo");
			String prdName = request.getParameter("prdName");
			String prdPrice = request.getParameter("prdPrice");
			String prdCompany = request.getParameter("prdCompany");
			
			model.addAttribute("prdNo", prdNo);
			model.addAttribute("prdName", prdName);
			model.addAttribute("prdPrice", prdPrice);
			model.addAttribute("prdCompany", prdCompany);
			
			return "product/productResultView";
		}

	//(2) @RequestParam 어노테이션 사용 
	//index 페이지에서 ProductForm 페이지 요청
	@RequestMapping("/product/productForm2")
	public String studentForm2() {
		return "product/productForm2"; 
	}		
		
	@RequestMapping("/product/newProduct2")
	public String newStudent2(@RequestParam("prdNo") String prdNo,
												  @RequestParam("prdName") String prdName,
												  @RequestParam("prdPrice") String prdPrice,
												  @RequestParam("prdCompany") String prdCompany,
											       Model model) {
	
		// 결과 페이지로 출력하기 위해 Model로 설정
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		
		return "product/productResultView";
	}
	
	// (3) Command 객체 사용
	@RequestMapping("/product/productForm3")
	public String productForm3() {
		return "product/productForm3"; // 입력 폼 열기
	}
	
	@RequestMapping("/product/newProduct3")
	public String newProduct3(ProductVO productVO) {
		return "product/productResultView3";	
	}
	
	//url을 통한 데이터 전달 : @PathVariable 이용
	@RequestMapping("/product/productDetailView/{pdNo}")
	public String productDetailView(@PathVariable String pdNo) {
		System.out.println(pdNo);
		return "index";
	}
	
	@RequestMapping("/product/productDetailView2/{prdNo}/{prdName}/{prdPrice}/{prdCompany}")
	public String productDetailView2(
			@PathVariable String prdNo,
			@PathVariable String prdName,
			@PathVariable String prdPrice,
			@PathVariable String prdCompany) {
		System.out.println(prdNo);
		System.out.println(prdName);
		System.out.println(prdPrice);
		System.out.println(prdCompany);
		return "index";
	}

	@RequestMapping("/product/prdSearchForm")
	public String prdSearchForm() {
		return "product/prdSearchForm";
	}
	@RequestMapping("/product/prdSearch")
	public String prdSearch(@RequestParam HashMap<String, Object> param,
			Model model) {
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		
		ProductVO vo1=new ProductVO();
		vo1.setPrdNo("20221029");
		vo1.setPrdName("초코");
		vo1.setPrdCompany("가나");
		
		ProductVO vo2=new ProductVO();
		vo2.setPrdNo("20221129");
		vo2.setPrdName("바나나");
		vo2.setPrdCompany("가나");
		
		ArrayList<ProductVO> prdList=new ArrayList<ProductVO>();
		prdList.add(vo1);
		prdList.add(vo2);
		
		model.addAttribute("prdList",prdList);
		return "product/prdSearchResultView";
	}
}
