package com.newlecture.javaWeb.dao;

import java.util.List;

import com.newlecture.javaWeb.entity.Notice;

public interface NoticeDao {
	//��¥�� �������̽��� ��� �ۺ��̶� �ۺ��̶�� �ϸ� �ȴ�.
	List<Notice> getList(int page,String query);	
	int getCount();
	Notice get(String id);
	int update(String id, String title, String content);
}
