document.addEventListener("DOMContentLoaded", () => {
  const student_table = document.querySelector("table.student.list");
  /*
    객체?.fun()
    객체 요소가 null 이 아닐때만 fun() 함수를 실행하라
    null safe code 라고 한다.
  */
  const student_data = student_table?.querySelector("tbody");

  const onDataClickHandlr = (e) => {
    // click event 가 최초로 발생한 요소 = taget(TD)
    const target = e.target;
    // 최초로 클릭된 요소가 TD tag 이면
    if (target.tagName === "TD") {
      // 클릭된 TD tag 를 감싸고 있는 부모tag(closest) 중에서
      // 가장 가까이에서 감싸고 있는 TR 을 select 해라
      const tr = target.closest("TR");
      const st_num = tr.dataset.st_num;
      // 선택된 st_num 를 서버(Controller)에게 요청하여
      // 학생의 detail 정보를 보고 싶다
      document.location.href = `${rootPath}/detail?st_num=${st_num}`;
      // alert(st_num);
      // ---------------------------
      // td tag 에 data-st_num 속성에 설정된 값을 가져와서 보이기
      //   const st_num = target.dataset.st_num;
      //   alert(st_num);
      // --------------------------
      // TD tag 의 값(문자열) 확인
      //   alert(target.textContent);
    }
  };
  student_data.addEventListener("click", onDataClickHandlr);
});
