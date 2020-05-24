package com.dongduk.myfancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dongduk.myfancy.service.StoreService;

@Controller
public class LoginController {
	
	
//	private StoreService storeService;

	@RequestMapping("/index")
	public String members(Model model) { //첫 페이지인 index에서 회원목록을 보여주기 위한 controller메소드
		return "index";
	}
	
	
//		@Autowired
//		private MemberService memberService;
//		private String beforeUri; //로그인 창에서 로그인할 경우 상세보기인지, 삭제인지 저장해놓기 위한 필드
//
//		@RequestMapping("/index")
//		public String members(Model model) { //첫 페이지인 index에서 회원목록을 보여주기 위한 controller메소드
//			List<MemberInfo> members = memberService.getMembers();
//			model.addAttribute("members", members);
//			return "index";
//		}
//
//		@RequestMapping("/members/{memberId}/detail")
//		public String memberDetail(HttpSession session, @PathVariable String memberId, Model model) { //회원 상세보기를 위한 메소드
//			if (session.getAttribute("id") != null && session.getAttribute("id").equals(memberId)) { //로그인되었는지 확인
//				MemberInfo mi = memberService.getMemberInfo(memberId); //해당 id에 맞는 MemberInfo객체 가져오기
//				if (mi == null) {
//					return "member/memberNotFound";
//				}
//				model.addAttribute("member", mi);
//			} else { //로그인되어있지 않으면 login.jsp로 이동
//				beforeUri = "/members/{memberId}/detail"; 
//				model.addAttribute("member", memberService.getMemberInfo(memberId)); //login.jsp에서 id는 해당 회원의 id값이 default로 들어가기 위해 member모델 보냄
//				return "member/login";	
//			}
//			return "member/memberDetail";
//		}
//		
//		@RequestMapping("/members/{memberId}/remove")
//		public String removeMember(HttpSession session, @PathVariable String memberId, Model model) { //회원 삭제를 위한 메소드
//			if (session.getAttribute("id") != null && session.getAttribute("id").equals(memberId)) //상세보기와 마찬가지로 로그인 되어있는지 확인
//				memberService.removeMember(memberId); //로그인 되어있다면 삭제
//			else {
//				beforeUri = "/members/{memberId}/remove";
//				model.addAttribute("member", memberService.getMemberInfo(memberId)); //login.jsp에서 id는 해당 회원의 id값이 default로 들어가기 위해 member모델 보냄
//				return "member/login";
//			}
//			return "redirect:/index";
//		}
//		
//		@RequestMapping("/members/{memberId}/login")
//		public String login(HttpSession session, @PathVariable String memberId, @RequestParam("pw") String pw, Model model) { //로그인 버튼을 눌렀을 때 적용되는 메소드
//			MemberInfo member = memberService.getMemberInfo(memberId); //해당 id에 맞는 MemberInfo객체 꺼냄
//			if (member.getPassword().equals(pw)) { //해당 member의 비밀번호와 입력한 비밀번호가 일치한지 확인
//				session.setAttribute("id", memberId); //일치하면 세션에 해당회원의 정보저장
//				return "redirect:" + beforeUri; //후에 원래 목적의 페이지로 이동(페이지로 바로 이동하는 것이 아닌 detail 또는 remove에 해당하는 controller메소드 수행 후 이동하도록 설정(jsp파일로 바로 이동이 아니라 redirect이용))
//			}
//			model.addAttribute("member", member);
//			model.addAttribute("message", "아이디(" + member.getId() +")와 암호가 일치하지 않습니다."); //비밀번호가 일치하지 않을 경우 출력할 오류메세지를 화면에 출력하기 위해 attribute로 전송
//			return "member/login";
//		}
//
//		public void setMemberService(MemberService memberService) {
//			this.memberService = memberService;
//		}
//
//	}

}
