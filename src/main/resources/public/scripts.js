function loadGetFactMsg() {
    let nameVar = document.getElementById("factores").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
           document.getElementById("getrespmsg").innerHTML =
           this.responseText;
    };
    xhttp.open("GET", "/factores?value="+nameVar);
    xhttp.send();
}

function loadGetPriMsg() {
    let nameVar = document.getElementById("primos").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
           document.getElementById("getrespmsg").innerHTML =
           this.responseText;
    };
    xhttp.open("GET", "/primos?value="+nameVar);
    xhttp.send();
}