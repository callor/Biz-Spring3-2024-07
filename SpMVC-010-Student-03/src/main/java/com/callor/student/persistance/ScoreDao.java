package com.callor.student.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.student.models.ScoreVO;

public interface ScoreDao {
	
	public List<ScoreVO> selectAll();
	public ScoreVO findById(String id);

	// 학번을 매개변수로 받아서 성적리스트를 return
	@Select("SELECT * FROM view_score WHERE sc_stnum = #{st_num}")
	public List<ScoreVO> findByStNum(String st_num);

}
