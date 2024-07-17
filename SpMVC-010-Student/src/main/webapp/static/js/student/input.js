document.addEventListener("DOMContentLoaded", () => {
  const input_form = document.querySelector(
    "section.student.input form"
  );
  const input_st_num = input_form.querySelector("#st_num");
  const input_st_name = input_form?.querySelector("#st_name");
  const input_st_dept = input_form?.querySelector("#st_dept");
  const input_st_grade = input_form?.querySelector("#st_grade");
  const input_st_tel = input_form?.querySelector("#st_tel");
  const input_st_addr = input_form?.querySelector("#st_addr");
  const btn_save = input_form?.querySelector("button.save");

  const onValidate = (text, alertName, object) => {
    if (!text) {
      alert(`${alertName} 는 반드시 입력하세요`);
      object.select();
      return false;
    }
    return true;
  };

  const onSaveHandler = () => {
    const text_st_num = input_st_num.value;
    const text_st_name = input_st_name.value;
    const text_st_dept = input_st_dept.value;
    const text_st_grade = input_st_grade.value;
    const text_st_tel = input_st_tel.value;
    const text_st_addr = input_st_addr.value;

    if (!onValidate(text_st_num, "학번", input_st_num)) return false;
    if (!onValidate(text_st_name, "이름", input_st_name))
      return false;
    if (!onValidate(text_st_dept, "학과", input_st_dept))
      return false;
    if (!onValidate(text_st_grade, "학년", input_st_grade))
      return false;

    // isNaN(변수) 변수에 포함된 값에 문자열이 섞여있냐? true
    if (isNaN(text_st_grade)) {
      alert("학년은 반드시 숫자로 입력해야 합니다");
      input_st_grade.select();
      return;
    }
    const int_st_grade = Number(text_st_grade);
    if (int_st_grade < 1 || int_st_grade > 4) {
      alert("학년은 1 ~ 4학년까지만 입력해야 합니다");
      input_st_grade.select();
      return;
    }

    if (!onValidate(text_st_tel, "전화번호", input_st_tel))
      return false;
    if (!onValidate(text_st_addr, "주소", input_st_addr))
      return false;

    input_form.submit();
  };
  btn_save?.addEventListener("click", onSaveHandler);
});
