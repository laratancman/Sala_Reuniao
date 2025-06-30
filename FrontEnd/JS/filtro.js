document.addEventListener("DOMContentLoaded", () => {
  const inputBusca = document.getElementById("busca");
  const tbody = document.getElementById("salas");

  inputBusca.addEventListener("input", () => {
    const filtro = inputBusca.value.toLowerCase();

    Array.from(tbody.rows).forEach((linha) => {
      const textoLinha = linha.textContent.toLowerCase();

      if (textoLinha.includes(filtro)) {
        linha.style.display = "";
      } else {
        linha.style.display = "none";
      }
    });
  });
});
