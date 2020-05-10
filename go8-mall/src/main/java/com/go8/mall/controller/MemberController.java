package com.go8.mall.controller;

import org.springframework.stereotype.Controller;
/*import com.go8.sso.pojo.Member;
import com.go8.sso.service.MemberService;*/

@Controller
public class MemberController {
	/*@Autowired
	private MemberService memberService;*/

	/*@PostMapping("/register")
	public @ResponseBody Object register(Member member){
		try {
			String token = memberService.register(member);
			Map<String,Object> data = new HashMap<>();
			data.put("token", token);
			return ServiceResponse.ok(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PostMapping("/login")
	public @ResponseBody Object login(Member member){
		try {
			String token = memberService.login(member);
			if(token == null) {
				return ServiceResponse.info("登录名或者密码错误");
			}
			Map<String,Object> data = new HashMap<>();
			data.put("token", token);
			return ServiceResponse.ok(data);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("/info")
	public @ResponseBody Object getUserInfo(String token){
		try {
			Member member = memberService.getMemberInfo(token);
			return ServiceResponse.ok(member);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@GetMapping("/check")
	public @ResponseBody Object checkUnique(Member member){
		try {
			Member mem = memberService.validateUnique(member);
			return ServiceResponse.ok(mem);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}
	
	@PostMapping("/logout")
	public @ResponseBody Object logout(String token){
		try {
			memberService.logout(token);
			return ServiceResponse.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceResponse.error();
		}
	}*/
}
