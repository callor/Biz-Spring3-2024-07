document.addEventListener("DOMContentLoaded", () => {
  const station_section = document.querySelector("section.station");
  const getArrive = (e) => {
    alert("Arrive");
  };
  station_section.addEventListener("click", getArrive);
});
