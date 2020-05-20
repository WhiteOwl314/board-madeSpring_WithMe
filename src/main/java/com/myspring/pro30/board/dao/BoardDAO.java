package com.myspring.pro30.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;

public interface BoardDAO {

	List<ArticleVO> selectAllArticlesList() throws DataAccessException;

}
