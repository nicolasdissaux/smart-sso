package com.smart.sso.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smart.sso.client.constant.SsoConstant;
import com.smart.sso.client.rpc.SsoUser;
import com.smart.sso.client.session.SessionUtils;

@Controller
public class IndexController {

	@Value("${server.port}")
	private Integer serverPort;
	@Value("${sso.server.url}")
	private String serverUrl;

	/**
	 * 初始页
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		SsoUser user = SessionUtils.getUser(request);
		// 登录用户名
		model.addAttribute("userName", user.getAccount());
		// 当前服务端口号
		model.addAttribute("serverPort", serverPort);
		// 当前sessionId
		model.addAttribute("sessionId", request.getSession().getId());
		// 单点退出地址
		model.addAttribute("logoutUrl", MessageFormat.format(SsoConstant.LOGOUT_URL, serverUrl,
				URLEncoder.encode(getLocalUrl(request), "utf-8")));
		return "index";
	}
	

    /**
     * 获取当前应用访问路径
     *
     * @param request
     * @return
     */
    private String getLocalUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();
        url.append(request.getScheme()).append("://").append(request.getServerName());
        if (request.getServerPort() != 80 && request.getServerPort() != 443) {
            url.append(":").append(request.getServerPort());
        }
        url.append(request.getContextPath());
        return url.toString();
    }
}
