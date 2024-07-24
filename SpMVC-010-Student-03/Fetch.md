# Fetch API
- JavaScript 에서 직접 Http 프로토콜을 사용하여 (background에서) 서버에 요청을 보내고 응답을 처리하는 도구
- Fetch 는 다른 서버에 대하여 요청과 응답을 비동기적으로 요청하고 처리할수 있다.
- Fetch 는 비동기적으로 사용하기도 하며, 동기방식(Blocing)으로 사용하기도 한다.
- 사용하는 용도에 따라 적절히 선택하여 사용하면 된다

## 비동기 방식 사용
```js
fetch(url) // 서버의 url 을 통하여 요청하기 fetch 는 애플리케이션에게 OK!!
.then((res)=>{}) // 서버로 부터 응답이 오면 첫번째 then() 의 함수가 실행
		// 첫번째 then() 함수에서는 결과를 return 하도록 코딩
.then(rsult=>{}) // 첫번째 then() 의 함수가 return 값을 두번째 then() 의 함수에게 전달하고 실행
```

## 동기 방식 사용
```js
// 가장 바깥쪽 함수에 async 키워드가 부착된다
const main async() =>{
	const res = await fatch(url) // 서버에게 요청을 보내고 기다린다
			// 서버에서 응답이 오면 response 정보를 res 변수에 할당
	const result = await res.text() // 서버의 응답중에서 문자열만 추출하여
			// result 변수에 할당

	// result 변수를 사용하여 다른 코드 사


}