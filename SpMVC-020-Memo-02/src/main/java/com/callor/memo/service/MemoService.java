package com.callor.memo.service;

import java.util.List;

import com.callor.memo.models.Memo;

public interface MemoService {

	public List<Memo> selectAll();
	public Memo findById(String m_memo);
	
	public int insert(Memo memo);
	public int update(Memo memo);
	public int delete(String m_seq);
	
}
