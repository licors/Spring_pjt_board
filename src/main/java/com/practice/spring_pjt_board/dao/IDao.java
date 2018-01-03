package com.practice.spring_pjt_board.dao;

import java.util.ArrayList;

import com.practice.spring_pjt_board.dto.ContentDto;

public interface IDao {
	public ArrayList<ContentDto> listDao();
	public void writeDao(String writer, String content);
	public ContentDto viewDao(String bid);
	public void deleteDao(String bid);
}
