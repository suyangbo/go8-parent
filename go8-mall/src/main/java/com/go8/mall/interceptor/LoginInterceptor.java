package com.go8.mall.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
/*import com.go8.sso.pojo.Member;
import com.go8.sso.service.MemberService;*/

public class LoginInterceptor implements HandlerInterceptor {
	/*@Autowired
	private MemberService memberService;*/
	
	@Value("${LOGIN_URL}")
	private String LOGIN_URL;
	
	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getParameter("token");
		StringBuffer lastAccessUrl = request.getRequestURL();
		String params = request.getQueryString();
		if(!StringUtils.isEmpty(params)) {
			lastAccessUrl.append("?").append(params);
		}
		if(StringUtils.isEmpty(token)) {
			response.sendRedirect(LOGIN_URL+"?returnUrl="+lastAccessUrl);
			return false;
		}else {
			//by token get user info
			Member member = memberService.getMemberInfo(token);
			if(member==null) {
				response.sendRedirect(LOGIN_URL+"?returnUrl="+lastAccessUrl);
				return false;
			}else {
				request.setAttribute("member", member);
				return true;
			}
		}
	}*/
}
