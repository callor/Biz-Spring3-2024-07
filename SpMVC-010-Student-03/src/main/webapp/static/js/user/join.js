const INPUT_INDEX = {
  USERNAME: 0,
  PASSWORD: 1,
  NAME: 2,
  NICK: 3,
  BUTTON: 4,
};
const ERROR_MESSAGE = [
  "* USER NAME 은 반드시 입력하세요",
  "* PASSWORD 는 반드시 입력하세요",
  "* 사용자의 본명을 반드시 입력하세요",
  "* 사용자의 별명을 반드시 입력하세요",
];

document.addEventListener("DOMContentLoaded", () => {
  const join_form = document.querySelector("form.user.join");
  // form > input 전체를 배열로 추출하기
  const join_inputs = join_form.querySelectorAll("input");
  const error_inputs = join_form.querySelectorAll("span");

  const emptyValid = (index) => {
    // const text = join_form[index].value
    const text = join_inputs[index].value;
    if (!text) {
      error_inputs[index].textContent = ERROR_MESSAGE[index];
      error_inputs[index].style.display = "inline-block";
      join_inputs[index].select();
      return false;
    }
    return true;
  };

  const onJoinSumbit = () => {
    // span tag 개수만큼 반복하면서 emptyValid 함수를 사용하여
    // 값이 입력되지 않은 상황을 검사하기
    let yesValid = true;
    for (let i = 0; i < error_inputs.length; i++) {
      const span = error_inputs[i];
      span.style.display = "none";
      if (!(yesValid = emptyValid(i))) break;
    }
    if (yesValid) join_form.submit();

    // 유사배열(join_inputs)을
    // Array.from() 을 통과시켜 순수배열(input_value_array)로 변경하기
    // const input_value_array = Array.from(join_inputs);
    // 순수배열로 변경되었기 때문에 map() 함수 사용가능
    // const input_values = input_value_array.map(
    //   (input) => input.value
    // );

    // 유사배열에서는 map() 사용 불가
    // join_inputs 배열에는 map() 함수를 적용할수 없다
    // join_inputs.map is not a function
    // const input_values = join_inputs.map((input) => input.value);

    // if (!input_values[INPUT_INDEX.USERNAME]) {
    //   const error_input = error_inputs[INPUT_INDEX.USERNAME];
    //   error_input.textContent = "* USER NAME 은 반드시 입력하세요";
    //   error_input.style.display = "inline-block";
    //   join_inputs[INPUT_INDEX.USERNAME].select();
    //   return;
    // }
  };

  // join_inputs[4]
  join_inputs[INPUT_INDEX.BUTTON].addEventListener(
    "click",
    onJoinSumbit
  );
});
