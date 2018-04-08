package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	/* requestPro는 명령어에서 찾은 클래스를 클래스화 시키기 위한것이다*/
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
