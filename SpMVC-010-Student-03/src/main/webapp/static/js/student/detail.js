document.addEventListener("DOMContentLoaded", () => {
  const section_detail = document.querySelector(
    "section.student.detail"
  );
  const btn_list = section_detail?.querySelector("button.list");
  const btn_update = section_detail?.querySelector("button.update");
  const btn_delete = section_detail?.querySelector("button.delete");

  btn_list?.addEventListener("click", () => {
    document.location.href = `${rootPath}/`;
  });

  // event Handler 를 익명(무명) 함수로 선언하기
  // 외부에 함수를 선언하지 않고 직접 선언한 함수 몸체를 handler 에 add(추가하기)
  // 함수를 한번만 사용하고 다른곳에서는 더이상 사용하지 않을 것이라 라는 예측으로 제작
  // 익명함수로 handler 를 선언하는 것을 Call Back 함수 선언 이라고 도 한다.
  btn_delete?.addEventListener("click", (e) => {
    if (confirm("정말 학생정보를 삭제할까요?")) {
      // 클릭된(delete button) 의 부모 중에서 가장 가까이 있는 div 로 부터
      // data-st_num 로 설정된 값(학번)을 추출하고 그 값을 서버의 delete 에게 보내서
      // 삭제를 요청(Request)하기
      const st_num = e.target.closest("div").dataset.st_num;
      document.location.replace(
        `${rootPath}/delete?st_num=${st_num}`
      );
    }
  });

  btn_update?.addEventListener("click", (e) => {
    // update 버튼을 감싸고 있는 div 가 가지고 있는 st_num 변수 값을 추출하기
    const st_num = e.target.closest("div").dataset.st_num;
    // st_num 변수에 저장한 학번의 학생정보를 수정하고 싶으니 정보를 수정하는 화면을 나에게 보여줘
    document.location.href = `${rootPath}/update?num=${st_num}`;
  });
});
