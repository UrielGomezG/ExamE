document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("formulario");

    form.addEventListener("submit", async function(e) {
        e.preventDefault();

        const nombre = document.querySelector('input[name="Nombre"]').value.trim();
        const apellidoP = document.querySelector('input[name="ApellidoP"]').value.trim();
        const apellidoM = document.querySelector('input[name="ApellidoM"]').value.trim();
        const correo = document.querySelector('input[name="Correo"]').value.trim();
        const contraseña = document.querySelector('input[name="Contraseña"]').value.trim();

        if (nombre === "" || apellidoP === "" || apellidoM === "" || correo === "" || contraseña === "") {
            alert("Por favor, completa todos los campos");
            return;
        }

        const params = new URLSearchParams();
        params.append("Nombre", nombre);
        params.append("ApellidoP", apellidoP);
        params.append("ApellidoM", apellidoM);
        params.append("Correo", correo);
        params.append("Contraseña", contraseña);

        try {
            const response = await fetch("/resultado", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded"
                },
                body: params.toString()
            });

            if (response.ok) {
                const texto = await response.text();
                document.getElementById("resultado").textContent = texto;
            } else {
                alert("Error al enviar los datos");
            }
        } catch (error) {
            console.error("Error:", error);
            alert("Error de conexión");
        }
    });

});
