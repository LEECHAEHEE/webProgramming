package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	/* requestPro�� ��ɾ�� ã�� Ŭ������ Ŭ����ȭ ��Ű�� ���Ѱ��̴�*/
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
