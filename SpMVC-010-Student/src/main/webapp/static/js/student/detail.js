document.addEventListener("DOMContentLoaded", () => {
  const section_detail = document.querySelector(
    "section.student.detail"
  );
  const btn_list = section_detail?.querySelector("button.list");
  const btn_update = section_detail?.querySelector("button.update");
  const btn_delete = section_detail?.querySelector("button.delete");

  btn_list.addEventListener("click", () => {
    document.location.href = `${rootPath}/`;
  });
  btn_delete?.addEventListener("click", (e) => {
    if (confirm("정말 학생정보를 삭제할까요?")) {
      const st_num = e.target.dataset.st_num;
      document.location.replace(
        `${rootPath}/delete?st_num=${st_num}`
      );
    }
  });
});
