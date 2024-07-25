# Path : 경로
- path : 서버에 요청하는 것
- url(Uniform Resource Locator) : 클라이언트에서 서버에게 요청하는 `모든` 것

## Spring Application 에서 URL
- `http://localhost:8080/student/user/join`
- `http://localhost:8080/` : tomcat 에게 요청하기, tomcat 아 너 지금 실행하고 있니?, tomcat 서버가 작동되고 있는가를 묻는 요청(request)
- `student/` : tomcat 에게 `student` 라는 `Server Application` 이 실행되고 있는가 묻는 요청
- `user/join` : `student` Application 에서 서비스하고 있는 path 또는 url 에 대하여 요청을 하기, 여기에서 부터 Spring Application의 코딩 부분이 해당된다. `Controller`에서 처리할 부분