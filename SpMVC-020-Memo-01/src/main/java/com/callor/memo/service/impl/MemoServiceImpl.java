package com.callor.memo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.memo.models.Memo;
import com.callor.memo.service.MemoService;

@Service
public class MemoServiceImpl implements MemoService{
	
	protected final List<Memo> memoList;
	public MemoServiceImpl() {
		super();
		this.memoList = new ArrayList<Memo>();
		this.sampleMemo();
	}
	
	protected void sampleMemo() {
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		String[] memos = {
				"설산의 고행을",
				"없는 사막이 다 보여",
				"하는 온갖 과실이",
				"우는 봄날의 잔치는 얼마나",
				"능히 품으며 그들의",
				"세상을 하늘아래 두며"
		};
		for(String m : memos) {
		
			/*
			 * Builder 패턴을 사용하여 데이터객체 만들기
			 * lombok @Builder Annotaion 을 사용하면
			 * 데이터클래스(Dto, VO)에 Builder 내부 생성도구가 만들어진다
			 * Builder 패턴을 사용하면
			 * 1. 객체를 생성하면서 변수를 세팅할때, 변수이름과 동일한
			 * 		메서드를 통하여 변수를 세팅할 수 있다
			 * 2. 일부 변수의 값을 세팅하지 않고 싶을때 생략하면서
			 * 		나머지 변수만 세팅할 수 있다.
			 * 3. setter method 를 사용할때 보다 코드가 줄어든다
			 * 4. 생성자 주입을 통하여 사용할때와 달리
			 * 		변수의 세팅 순서를 유지 하지 않아도 된다.
			 * 		필요한 변수만 세팅할 수 있다
			 */
			Memo memo = Memo.builder()
					.m_seq("")
					.m_date(lt.format(date))
					.m_time(lt.format(time))
					.m_subject(m)
					.m_content(m + lt.format(time))
					.build();
			memoList.add(memo);
			
			// 클래스를 사용하여 객체를 생성하고
			// 객체의 각속성(변수)에 값을 setting 하기
//			Memo memo = new Memo();
//			memo.setM_seq("");
//			memo.setM_date(lt.format(date));
//			memo.setM_time(lt.format(time));
//			memo.setM_subject(m);
//			memo.setM_content(m + lt.format(time));

			/*
			 * 생성자를 사용하여 객체를 생성하면서
			 * 각 속성(변수)들을 생성자에 주입하여 
			 * 만드는 방법
			 */
//			Memo memo = new Memo(
//					"",
//					lt.format(date),
//					lt.format(time),
//					m,
//					m + lt.format(time)
//					); 
					
		}
		
		
	}

	@Override
	public List<Memo> selectAll() {
		return memoList;
	}

	@Override
	public Memo findById(String m_memo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Memo memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Memo memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String m_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
