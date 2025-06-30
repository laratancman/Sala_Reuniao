document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("form").addEventListener("submit", function (event) {
    event.preventDefault();

    const nomeSala = document.getElementById("nomeSala").value;
    const capacidade = document.getElementById("capacidade").value;
    const localizacao = document.getElementById("localizacao").value;
    const possuiProjetor = document.getElementById("possuiProjetor").checked;
    const possuiArCondicionado = document.getElementById(
      "possuiArCondicionado"
    ).checked;
    const numCadeiras = document.getElementById("numeroCadeiras").value;
    const tipoMesa = document.getElementById("tipoMesa").value;
    const recursosAdicionais =
      document.getElementById("recursosAdicionais").value;

    const dados = {
      nome: nomeSala,
      capacidade: capacidade,
      localizacao: localizacao,
      possuiProjetor: possuiProjetor,
      possuiArCondicionado: possuiArCondicionado,
      numCadeiras: numCadeiras,
      tipoMesa: tipoMesa,
      recursosAdicionais: recursosAdicionais,
    };

    fetch("http://localhost:8080/sala-reuniao/cadastrar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(dados),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Erro ao cadastrar sala");
        }
        return response.text();
      })
      .then((data) => {
        console.log("Sala cadastrada com sucesso:", data);

        const sucesso = document.getElementById("sucesso");
        sucesso.style.display = "block";
      })
      .catch((error) => {
        const erro = error.message;

        if (erro.includes("nome")) {
          document.getElementById("erroNomeSala").style.display = "block";
        } else if (erro.includes("localizacao")) {
          document.getElementById("erroLocalizacao").style.display = "block";
        }
      });
  });
});
