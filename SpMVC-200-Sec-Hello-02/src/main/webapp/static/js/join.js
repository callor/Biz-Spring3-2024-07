document.addEventListener("DOMContentLoaded", () => {
  const join_form = document.querySelector("form.join");
  const input_username = document.querySelector("#username");
  const input_password = document.querySelector("#password");
  const input_re_password = document.querySelector("#re_password");
  const button_join = document.querySelector("#join");

  const joinClickHandler = () => {
    alert("JOIN");
    // 유효성 검사
    // username, password 는 반드시 입력
    // password, re_password 는 반드시 일치
    join_form.submit();
  };

  button_join.addEventListener("click", joinClickHandler);
});
