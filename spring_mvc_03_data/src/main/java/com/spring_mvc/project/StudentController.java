package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	// index 페이지에서 studentForm 페이지 요청
	@RequestMapping("/student/studentForm")
	public String studentForm() {
		return "student/studentForm"; // studentForm.jsp 입력 폼 열기
	}
	
	// Form에서 전달된 데이터 받기
	// (1) HttpServletRequest 객체의 getParameter() 메소드 이용
	@RequestMapping("/student/newStudent")
	public String newStudent(HttpServletRequest request,
											    Model model) {
		// form의 각 input 태그의 name 속성 값 받아오기
		String stdNo = request.getParameter("stdNo");
		String stdName = request.getParameter("stdName");
		String stdYear = request.getParameter("stdYear");
		
		// 값이 제대로 전달되었늦지 확인하기 위해 콘솔에 출력
		System.out.println(stdNo);
		
		// 결과 페이지로 출력하기 위해 Model로 설정
		model.addAttribute("stdNo", stdNo);
		model.addAttribute("stdName", stdName);
		model.addAttribute("stdYear", stdYear);
		
		return "student/studentResultView";
	}
	
	// index 페이지에서 studentForm 페이지 요청
	@RequestMapping("/student/studentForm2")
	public String studentForm2() {
		return "student/studentForm2"; // studentForm.jsp 입력 폼 열기
	}
		
	// (2) @RequestParam 어노테이션 사용 
	@RequestMapping("/student/newStudent2")
	public String newStudent2(@RequestParam("stdNo") String stdNo,
												  @RequestParam("stdName") String stdName,
												  @RequestParam("stdYear") String stdYear,
											       Model model) {
	
		// 결과 페이지로 출력하기 위해 Model로 설정
		model.addAttribute("stdNo", stdNo);
		model.addAttribute("stdName", stdName);
		model.addAttribute("stdYear", stdYear);
		
		return "student/studentResultView";
		}
	
	// 3. Command 객체 사용
	// index 페이지에서 studentForm 페이지 요청
	@RequestMapping("/student/studentForm3")
	public String studentForm3() {
		return "student/studentForm3"; // studentForm.jsp 입력 폼 열기
	}

	@RequestMapping("/student/newStudent3")
	public String newStudent3(StudentVO studentVO) {
		// stdNo 출력 : Getter
		System.out.println(studentVO.getStdNo()); 
		return "student/studentResultView3";
	}
	
	// Command 객체 이름 변경
	@RequestMapping("/student/studentForm4")
	public String studentForm4() {
		return "student/studentForm4"; // studentForm.jsp 입력 폼 열기
	}
	
	// 객체명 studentVO를 std로 변경
	@RequestMapping("/student/newStudent4")
	public String newStudent4(@ModelAttribute("std") StudentVO studentVO) {
		return "student/studentResultView4";
	}
	
	//url을 통한 데이터 전달 : @PathVariable 이용
	@RequestMapping("/student/studentDetailView/{stdNo}")
	public String studentDetailView(@PathVariable String stdNo) {
		System.out.println(stdNo);
		return "index"; 
	}
	
	//url을 통한 데이터 전달 : @PathVariable로 여러 개 처리
	@RequestMapping("/student/studentDetailView2/{stdNo}/{stdName}/{stdYear}")
	public String studentDetailView2(@PathVariable String stdNo,
															 @PathVariable String stdName,
															 @PathVariable String stdYear) {
		System.out.println(stdNo);
		System.out.println(stdName);
		System.out.println(stdYear);
		return "index"; 
	}
	
	// 학생 검색 폼 열기
	@RequestMapping("/student/studentSearchForm")
	public String studentSearchForm() {
		return "student/studentSearchForm";
	}
	
	// 학생 검색 처리 : HashMap으로 받기
	@RequestMapping("/student/studentSearch")
	public String studentSearch(@RequestParam HashMap<String, Object> param,
													Model model) {
		// param 값 출력 : key로 value 찾아서 출력
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		
		// DB에서 검색한 결과 받아왔다고 가정하고 ArrayList에 담아서 뷰페이지로 전달
		// name "홍길동"으로 검색한 결과가 2명 존재한다고 가정
		// VO 2개 생성 : 생성자 없으므로 setter 사용해서 값 설정
		StudentVO vo1 = new StudentVO();
		vo1.setStdNo("2021001");
		vo1.setStdName("홍길동");
		vo1.setStdYear(2);
		
		StudentVO vo2 = new StudentVO();
		vo2.setStdNo("2022001");
		vo2.setStdName("홍길동");
		vo2.setStdYear(1);
		
		// ArrayList에 vo1, vo2 추가
		ArrayList<StudentVO> stdList = new ArrayList<StudentVO>();
		stdList.add(vo1);
		stdList.add(vo2);
		// 여기까지 DB에서 검색한 결과 반환 : ArrayList로 반환됨	
		
		// DB 연동한 경우
		//ArrayList<StudentVO> stdList = stdService.getStdSearch();
		
		// Model 객체 이용하여 데이터 설정
		model.addAttribute("stdList", stdList);

		return "student/studentSearchResultView";
	}
}
















