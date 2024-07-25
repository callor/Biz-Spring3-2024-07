document.addEventListener("DOMContentLoaded", () => {
  const INPUT_INDEX = {
    USERNAME: 0,
    PASSWORD: 1,
    NAME: 2,
    NICK: 3,
    BUTTON: 4,
  };

  const join_form = document.querySelector("form.user.join");
  // form > input 전체를 배열로 추출하기
  const join_inputs = join_form.querySelectorAll("input");

  const onJoinSumbit = () => {
    // alert("Button Click");

    // 유사배열(join_inputs)을
    // Array.from() 을 통과시켜 순수배열(input_value_array)로 변경하기
    const input_value_array = Array.from(join_inputs);
    // 순수배열로 변경되었기 때문에 map() 함수 사용가능
    const input_values = input_value_array.map(
      (input) => input.value
    );

    // 유사배열에서는 map() 사용 불가
    // join_inputs 배열에는 map() 함수를 적용할수 없다
    // join_inputs.map is not a function
    // const input_values = join_inputs.map((input) => input.value);

    if (!input_values[INPUT_INDEX.USERNAME]) {
      alert("USER NAME 은 반드시 입력하세요");
      join_inputs[INPUT_INDEX.USERNAME].select();
      return;
    }
  };

  // join_inputs[4]
  join_inputs[INPUT_INDEX.BUTTON].addEventListener(
    "click",
    onJoinSumbit
  );
});
