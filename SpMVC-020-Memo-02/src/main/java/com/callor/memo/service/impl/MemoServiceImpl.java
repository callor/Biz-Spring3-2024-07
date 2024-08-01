package com.callor.memo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.callor.memo.models.Memo;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			
			String m_seq = UUID.randomUUID().toString();
		
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
					.m_seq(m_seq)
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
	public Memo findById(String m_seq) {
		/*
		 * memoList 에 저장된 요소중 m_seq 값이 매개변수로 전달받은
		 * m_seq 와 일치하는 값이 있으면 그 메모를 return 하기
		 */
		for(Memo memo : memoList) {
			if(memo.getM_seq().equals(m_seq)) return memo;
		}
		return null;
	}

	@Override
	public int insert(Memo memo) {
		String m_seq = UUID.randomUUID().toString();
		memo.setM_seq(m_seq);
		memoList.add(memo);
		return memoList.size();
	}

	@Override
	public int update(Memo memo) {

		String m_seq = memo.getM_seq();
//		for(Memo m : memoList) {
//			if(m.getM_seq().equals(m_seq)) {
//				m = memo;
//				break;
//			}
//		}
		
		int nSize = memoList.size();
		int index;
		for(index = 0 ; index < nSize ; index++) {
			if(memoList.get(index).getM_seq().equals(m_seq) ) break;
		}
		memoList.set(index, memo);
		
		// Korea 문자열의 소문자 o 를 대문자 O 변환하여 nation 변수에 저장
		String nation = "Korea".replace("o", "O");
		
		/*
		 * 자바 1.8(java8)이상에서 사용하는 List<T> type 의 데이터
		 * 요소를 교체하는 코드
		 * 
		 * 1. memoList 리스트 전체를 forEach 반복하기
		 * 2. 각 요소(각개별 메모)를 변수 m 에 담아 내부 함수로 전달
		 * 3. 만약 m 요소의 m_seq 값이 memo의 m_seq 값과 같으면( ? )
		 * 4. memo 를 return
		 * 5. 그렇지 않으면 그냥 자신( m )을 return
		 * 
		 * 그리하여 전달받은 데이터의 memo 를 memoList 의 요소로 교체하기
		 * 
		 * java 의 화살표함수( ()->{  } 를 lambda(람다) 함수 라고 한다
		 * javascript 화살표 함수( ()=>{ } ) 와 비슷한 객체 type 의 함수
		 * 
		 * for() {   }
		 * 
		 */
		memoList.replaceAll(m-> m.getM_seq().equals(m_seq) ? memo : m);
		
		log.debug(memoList.toString());
		return 0;
	}

	@Override
	public int delete(String m_seq) {

		int index = 0;
		/*
		 * forEach() 반복문을 순회하면서 m_seq 가 일치하는 memo 요소를
		 * 찾는다 일치하는 요소를 찾으면 break 실행하여 forEach()를 중단
		 * 이때 index 는 찾은 요소의 index 가 된다
		 * forEach() 다음에서 remove()를 실행하여 요소를 삭제한다
		 */
		for(Memo m : memoList) {
			if(m.getM_seq().equals(m_seq)) break; 
			index++;
		}
		memoList.remove(index);
		
		/*
		 * memoList 를 forEach() 로 반복하면서
		 * m_seq 를 검사하여 삭제 대상을 찾으면
		 * remove() 실행하여 요소를 삭제한다
		 * 
		 * 이 코드는 표면상으로 정상적으로 작동하는 것처럼 보인다
		 * 하지만, 내부에서 indexOutOfBound exception 이 발생할수 있고
		 * 메모리 누수등의 문제를 일으킬수 있다
		 * 가급적 이 코드는 사용하지 않는 것이 좋겠다
		 */
//		for(Memo m : memoList) {
//			if(m.getM_seq().equals(m_seq)) memoList.remove(index); 
//			index++;
//		}
		
		return 0;
	}

}
