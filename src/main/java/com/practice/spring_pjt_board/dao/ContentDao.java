package com.practice.spring_pjt_board.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.spring_pjt_board.dto.ContentDto;
 
public class ContentDao implements IDao{
	JdbcTemplate template;
	
	@Override
	public ArrayList<ContentDto> listDao() {
		String query = "select * from board order by mId desc";
		ArrayList<ContentDto> dtos = (ArrayList<ContentDto>) template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		return dtos;
	}

}
