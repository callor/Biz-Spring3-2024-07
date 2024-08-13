document.addEventListener("DOMContentLoaded", () => {
  const station_list = document.querySelector("ul.station-list");
  const getArrive = async (e) => {
    const target = e.target;
    if (target.tagName === "SPAN" && target.classList.contains("item")) {
      const busId = target.closest("LI").dataset.id;
      //   document.location.href = `${rootPath}arrive/${busId}`;
      const arriveURL = `${rootPath}arrive/${busId}`;
      const response = await fetch(arriveURL);
      const html = await response.text();
      document.querySelector("section.stop_time").innerHTML = html;
    }
  };
  station_list.addEventListener("click", getArrive);
});
