document.addEventListener("DOMContentLoaded", () => {
    const theme = localStorage.getItem("theme") || "light";
    document.body.setAttribute("data-theme", theme);
});
function toggleTheme() {
    const currentTheme = document.body.getAttribute("data-theme");
    const newTheme = currentTheme === "dark" ? "light" : "dark";
    setTimeout(() => {
        document.body.setAttribute("data-theme", newTheme);
        localStorage.setItem("theme", newTheme);
    }, 500);
}