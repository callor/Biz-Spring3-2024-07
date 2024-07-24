package com.callor.student.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.student.models.StudentVO;

/*
 * DBMS CRUD 구현
 * CREATE : INSERT = 새로운 데이터를 Table 에 추가하기
 * 
 * READ : SELECT = 기존에 저장된 데이터를 Table 에서 불러오기
 * 		모든 데이터 SELECT : WHERE 절이 없이 SELECT
 * 		PK 기준의 SELECT : PK 칼럼을 기준으로 WHERE 절에서 SELECT
 * 
 * UPDATE : UPDATE : 기존에 저장된 데이터를 변경하기(일부, 또는 전체)
 * 		PK 데이터는 수정하지 않는다
 * 
 * DELETE : DELETE : 필요없어진 데이터를 영구적으로 Table 에서 제거하기
 * 		PK 기준으로 DELETE 실행
 * 
 */
public interface StudentDao {
	
	@Select("SELECT * FROM tbl_student ORDER BY st_num")
	public List<StudentVO> selectAll();
	
	@Select("SELECT * FROM tbl_student WHERE st_num =#{st_num}")
	public StudentVO findById(String st_num);
	
	@Select("SELECT * FROM tbl_student WHERE st_tel = #{st_tel}")
	public List<StudentVO> findByTel(String st_tel);

	@Select("SELECT * FROM tbl_student WHERE st_name = #{st_name}")
	public List<StudentVO> findByName(String st_name);
	
	public int insert(StudentVO stVO);
	public int update(StudentVO stVO);

	@Delete("DELETE FROM tbl_student WHERE st_num = #{st_num}")
	public int delete(String st_num);

}
