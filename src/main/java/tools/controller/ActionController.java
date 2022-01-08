package tools.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

	@Value("${cas.server-url-prefix}")
	private String cas;

	@Value("${casClientLogoutUrl}")
	private String clientLogoutUrl;

	@RequestMapping(value = "ignore")
	public String ignore() throws Exception {
		return "ignore source";
	}

	@RequestMapping(value = "cas")
	public void cas(HttpServletResponse response) throws Exception {
		response.sendRedirect(cas);
	}

	@RequestMapping(value = "user")
	public String user(HttpServletRequest request) throws Exception {
		AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
		String username = principal.getName();
		return "login user: " + username;
	}

	@RequestMapping(value = "logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(clientLogoutUrl);
	}

	@RequestMapping(value = "logout1")
	public void logout1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("logout.html");
	}

	@RequestMapping(value = "logout2")
	public void logout2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.sendRedirect(clientLogoutUrl);
	}

	@RequestMapping(value = "success")
	public String success() throws Exception {
		return "logout success";
	}

}
