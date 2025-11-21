document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("passwordForm");

    form.addEventListener("submit", async function(e) {
        e.preventDefault(); // Evitar recarga

        const formData = new FormData(form);

        const response = await fetch("/generar", {
            method: "POST",
            body: formData
        });

        const texto = await response.text();

        document.getElementById("resultado").textContent = texto;
    });

});
