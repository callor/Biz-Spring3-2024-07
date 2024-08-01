# Spring 프로젝트에서 JSON 데이터 받고, 보내기
- Spring 이 시작될 때는 `JSON` 데이터가 없던 때이다.
- JavaScript 가 JSON 데이터 type 을 제안하면서, 많은 프로그래밍 언어, 도구들이 JSON 데이터를 지원하기 시작한다.
- Spring 에서도 JSON 데이터를 취급하기 위해 여러가지 도구가 만들어지고 활용 되었다
- 여러가지 도구 중에서 `Jackson-databind` 라는 도구를 가장 많이 사용하는데, 이 도구는 별도의 설정이 필요 없이 Spring 프로젝트와 가장 잘 융합이 된다.
- `Jacson-dataBind`를 사용하기 위해서는 `dependecy`를 프로젝트에 설정해야 한다
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.2</version>
</dependency>
```

## JavaScript 에서 `fetch()` 함수를 사용하여 `JSON` 데이터 보내기
- 데이터 직렬화
```javascript
const form = subBox.querySelector("form.memo.input"); // 1
const formData = new FormData(form); // 1
const planFormData = Object.fromEntries(formData.entries()); //2 
const payload = JSON.stringify(planFormData);
````
1. `form` 을 querySelector 하고, `FormData` type 으로 변환한다
2. `FormData` 중에서 데이터(input) 들만 별도로 추출한다.
3. 추출된 데이터(entries)를 JSON 형태의 문자열로 직렬화 한다

- `fetch()` 로 보내기
```javascript
const fetchConfig = {
   method: "POST",
   headers: {
     "Content-Type": "application/json",
   },
   body: payload,
};
fetch(`${rootPath}/comps/input`, fetchConfig)
````
1. fetch 가 사용할 설정(Config)를 만든다. 이때 headers 를 주의해서 작성한다.
2. 직렬화 된 JSON 데이터를 body 에 부착한다
