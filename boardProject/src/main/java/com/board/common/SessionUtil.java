package com.board.common;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.board.vo.ManagerVO;
public class SessionUtil {
	
	final String sessionName = "currentUser";

	//세션 등록
	public static void setUser(ManagerVO managerVO) {
		managerVO.setManagerPassword("");
		RequestContextHolder.getRequestAttributes().setAttribute("currentUser", managerVO, RequestAttributes.SCOPE_SESSION);
	}
	
	//세션 제거
	public static void removeUser() {
		RequestContextHolder.getRequestAttributes().removeAttribute("currentUser", RequestAttributes.SCOPE_SESSION);
	}

	//세션 정보
	public static ManagerVO getCurrentUser() {
		return (ManagerVO)RequestContextHolder.getRequestAttributes().getAttribute("currentUser", RequestAttributes.SCOPE_SESSION);
	}
	
	public static String getCurrentUserId() {
		return getCurrentUser() == null? "" : getCurrentUser().getManagerId();
	}
	
	public static String getCurrentUserName() {
		return getCurrentUser() == null? "" : getCurrentUser().getManagerName();
	}
	
	//로그인 여부
	public static Boolean isLogin() {
		if (RequestContextHolder.getRequestAttributes() == null) {
			return false;
		} else {
			if (getCurrentUser() == null) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	//로그인 유저 아이디
	public static String getUserId() {
		String userId = "";
		if(isLogin()) 
			userId = getCurrentUser().getManagerId();
		return userId;
	}
	
	//로그인 유저 이름
	public static String getUserName() {
		String userNamem = "";
		if(isLogin()) 
			userNamem = getCurrentUser().getManagerName();
		return userNamem;
	}

}
