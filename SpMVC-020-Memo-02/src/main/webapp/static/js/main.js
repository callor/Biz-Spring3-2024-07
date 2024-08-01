document.addEventListener("DOMContentLoaded", () => {
  const listBox = document.querySelector("article.list");
  const subBox = document.querySelector("article.sub");

  const onNewMemo = async () => {
    const mDate = listBox.querySelector("input[name='m_date']");
    const mTime = listBox.querySelector("input[name='m_time']");

    const res = await fetch(`${rootPath}/comps/input`);
    const html = await res.text();
    subBox.innerHTML = html;

    const today = new Date();

    // 화면에 보여질 날짜와 시간
    mDate.value = today.toISOString().split("T")[0];
    mTime.value = today.toISOString().split("T")[1].split(".")[0];

    // 서버로 보낼 날짜와 시간
    subBox.querySelector("input[name='m_date']").value = mDate.value;
    subBox.querySelector("input[name='m_time']").value = mTime.value;
  };

  const onUpdateMemo = async (e) => {
    const mSeq = e.target.closest("LI").dataset.seq;
    const res = await fetch(`${rootPath}/comps/update/${mSeq}`);
    const html = await res.text();
    subBox.innerHTML = html;
  };

  const onDeleteMemo = async (e) => {
    const mSeq = e.target.closest("LI").dataset.seq;

    if (!confirm("메모를 삭제할까요?")) return;

    const res = await fetch(`${rootPath}/comps/delete/${mSeq}`);

    if (res.status !== 200) {
      alert("서버문제로 삭제를 할수 없습니다");
      return false;
    }
    const html = await res.text();
    listBox.innerHTML = html;
    alert("삭제를 완료했습니다.");
  };

  listBox?.addEventListener("click", (e) => {
    // listBox 내의 클릭된 요소
    const target = e.target;
    if (target.tagName === "INPUT" && target.classList.contains("btn-new")) onNewMemo();
    if (target.tagName === "SPAN" && target.classList.contains("memo-content")) onUpdateMemo(e);
    if (target.tagName === "I" && target.classList.contains("memo-delete")) onDeleteMemo(e);
  });

  const onSaveMemo = () => {
    const input_subject = subBox.querySelector("input[name='m_subject']");
    const input_content = subBox.querySelector("textarea[name='m_content']");
    if (!input_subject.value) {
      alert("메모 제목을 입력하세요");
      input_subject.select();
      return false;
    }
    if (!input_content.value) {
      alert("메모 내용을 입력하세요");
      input_content.select();
      return false;
    }

    /**
     * form 에 입력된 데이터를 서버로 보낼때 보통 submit() 으로 전송한다
     * submit() 전송은 서버에게 데이터를 보내는 request 가 발생하고,
     * 그 결과를 response  로 받아 화면을 refresh 한다.
     *
     * 여기에는 form에 입력된 데이터를 fetch() 를 사용하여 서버로 전송하고,
     * 결과를 화면의 일부(list) 만 갱신하는 방식으로 사용한다
     */

    const form = subBox.querySelector("form.memo.input");

    // form의 input 에 입력된 데이터를 Ajax 방식으로 전송하기 위해 변환하기
    // form 의 데이터를 FormData type 으로 변환시키기
    const formData = new FormData(form);

    // spring server 에 fetch() 를 사용하여 데이터를 전송할때는
    // 데이터 일렬화 ( 또는 직렬화, String serializeing ) 한다
    const planFormData = Object.fromEntries(formData.entries());
    // 문자열화
    const payload = JSON.stringify(planFormData);

    // fetch() 로 보내기 위한 설정
    const fetchConfig = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: payload,
    };
    fetch(`${rootPath}/comps/input`, fetchConfig)
      .then((res) => {
        if (res.status === 200) alert("저장 완료");
        return res.text();
      })
      .then((html) => (listBox.innerHTML = html));
  };

  subBox?.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "INPUT" && target.classList.contains("btn-save")) onSaveMemo(e);
  });

  fetch(`${rootPath}/comps/list`)
    .then((res) => res.text())
    .then((html) => (listBox.innerHTML = html));
});
