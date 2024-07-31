document.addEventListener("DOMContentLoaded", () => {
  const timeBox = document.querySelector("div.date-time");
  const m_date = timeBox?.querySelector("input[name='m_date']");
  const m_time = timeBox?.querySelector("input[name='m_time']");
  const btn_new = timeBox?.querySelector("input[type='button']");
  const getToday = () => {
    const today = new Date();
    m_date.value = today.toISOString().split("T")[0];
    m_time.value = today.toISOString().split("T")[1].split(".")[0];
  };
  const onNewHandler = async () => {
    getToday();
    const response = await fetch(`${rootPath}/comps/input`);
    const html = await response.text();
    const subBox = document.querySelector("article.sub");
    subBox.innerHTML = html;
  };
  btn_new.addEventListener("click", onNewHandler);
});
