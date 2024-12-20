document.addEventListener("DOMContentLoaded", () => {
    const theme = localStorage.getItem("theme") || "light";
    document.body.setAttribute("data-theme", theme);
    iconthemas();
});
function toggleTheme() {
    const currentTheme = document.body.getAttribute("data-theme");
    const newTheme = currentTheme === "dark" ? "light" : "dark";
    setTimeout(() => {
        document.body.setAttribute("data-theme", newTheme);
        localStorage.setItem("theme", newTheme);
        iconthemas();
    }, 500);
}
function iconthemas(){
    const dia = document.getElementById("sol");
    const noche = document.getElementById("luna");
    if(localStorage.getItem("theme") == "dark"){
        dia.classList.add("desaparecer");
        noche.classList.remove("desaparecer")
    }else{
        dia.classList.remove("desaparecer");
        noche.classList.add("desaparecer")
    }
}

