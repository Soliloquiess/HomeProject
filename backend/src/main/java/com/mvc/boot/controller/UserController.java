package com.mvc.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.boot.Result;
import com.mvc.boot.service.JwtService;
import com.mvc.boot.service.UserService;
import com.mvc.boot.vo.User;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/signup")
	public void signup(@RequestBody User userInfo) throws Exception{
		userService.join(userInfo);
//	    Result result = Result.successInstance();
//	    User createdMember = userService.join(memberMaster);
//	    result.setData(createdMember);
//	    return result;
	}

	@PostMapping(value = "/login")
	public Result login(String id, String password, HttpServletResponse response) throws Exception{
    	Result result = Result.successInstance();
    	Map<String, String> userInfo = new HashMap<String,String>();
    	userInfo.put(id, password);
        User loginMember = userService.login(userInfo);
        String token = jwtService.create("user", loginMember, "user");
//        response.setHeader("Authorization", token);
        result.setData(loginMember);
        return result;
    }
//	
//	@PostMapping(value = "/login")
//	public String login(String ID, String PASS, Model model, HttpSession session, HttpServletResponse response) {
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("ID",ID);
//		map.put("PASS",PASS);
//		try {
//			User member = userService.login(map);
//			if(member != null) {
//				session.setAttribute("user", member);
//				
//				Cookie cookie = new Cookie("ssafy_id", member.getID());
//				cookie.setPath("/");
//				if("saveok".equals(map.get("idsave"))) {
//					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
//				} else {
//					cookie.setMaxAge(0);
//				}
//				response.addCookie(cookie);
//			} else {
//				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
//				return "user/login";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//		return "/index";
//	}
//	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	
//	=============================================================================

}
