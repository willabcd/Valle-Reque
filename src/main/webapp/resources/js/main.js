const d = document;
function toggleMenu() {
    const icon =d.getElementById("icon-salider");
    const  btn = d.getElementById('conten-cerrar-abrir');
    const sudmenus = d.querySelectorAll(".submenu");
    document.getElementById('sidebar').classList.toggle('collapsed');
    document.getElementById('header').classList.toggle('collapsed');
    document.getElementById('content').classList.toggle('collapsed');
    if (icon.classList.contains("pi-chevron-left") ){
        icon.classList.toggle("pi-chevron-left");
        icon.classList.toggle("pi-bars");
        btn.style.justifyContent="center";
        sudmenus.forEach(v =>(v.style.display="none"));
    }else {
        icon.classList.toggle("pi-chevron-left");
        icon.classList.toggle("pi-bars");
        btn.style.justifyContent="end";
    }
}

function  tooglesudmenus(opciones,submenus){
    const option = d.querySelectorAll(opciones);
    const sudmenus = d.querySelectorAll(submenus);
    option.forEach((v, k) => {
        v.addEventListener("click", (e) => {
            e.preventDefault();
            if (sudmenus[k].style.display === "block") {
                sudmenus[k].style.display = "none";
            } else {
                sudmenus[k].style.display = "block";
            }
        });
    });
}
d.addEventListener('click', function(e) {
    const  btn = d.getElementById('btm-cerrar');
    const menulateral = document.getElementById('sidebar');
    if (menulateral.classList.contains("collapsed") && menulateral.contains(e.target) && !(e.target === btn || btn.contains(e.target))) {
        toggleMenu();
    }
    if (e.target === btn || btn.contains(e.target)){
        toggleMenu();
    }
});

document.addEventListener("DOMContentLoaded", function () {
 tooglesudmenus(".toggle-submenu",".submenu")
});



