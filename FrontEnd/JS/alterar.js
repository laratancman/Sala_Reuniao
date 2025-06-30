document.addEventListener("DOMContentLoaded", () => {
  const idSala = localStorage.getItem("idSalaSelecionada");

  fetch(`http://localhost:8080/sala-reuniao/consultar/${idSala}`)
    .then((res) => {
      if (!res.ok) throw new Error("Sala não encontrada");
      return res.json();
    })
    .then((data) => {
      document.getElementById("nomeSala").value = data.nome || "";
      document.getElementById("capacidade").value = data.capacidade || "";
      document.getElementById("localizacao").value = data.localizacao || "";
      document.getElementById("possuiProjetor").checked =
        data.possuiProjetor || false;
      document.getElementById("possuiArCondicionado").checked =
        data.possuiArCondicionado || false;
      document.getElementById("numeroCadeiras").value = data.numCadeiras || "";
      document.getElementById("tipoMesa").value = data.tipoMesa || "";
      document.getElementById("recursosAdicionais").value =
        data.recursosAdicionais || "";
    })
    .catch((err) => {
      console.error("Erro ao carregar a sala:", err);
      alert("Erro ao carregar os dados da sala.");
    });

  document.getElementById("form").addEventListener("submit", (event) => {
    event.preventDefault();

    const dadosAtualizados = {
      id: parseInt(idSala),
      nome: document.getElementById("nomeSala").value,
      capacidade: parseInt(document.getElementById("capacidade").value) || 0,
      localizacao: document.getElementById("localizacao").value,
      possuiProjetor: document.getElementById("possuiProjetor").checked,
      possuiArCondicionado: document.getElementById("possuiArCondicionado")
        .checked,
      numCadeiras:
        parseInt(document.getElementById("numeroCadeiras").value) || 0,
      tipoMesa: document.getElementById("tipoMesa").value,
      recursosAdicionais: document.getElementById("recursosAdicionais").value,
    };

    fetch("http://localhost:8080/sala-reuniao/atualizar", {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(dadosAtualizados),
    })
      .then((res) => {
        if (!res.ok)
          return res.text().then((text) => {
            throw new Error(text);
          });
        return res.json();
      })
      .then(() => {
        document.getElementById("sucesso").style.display = "block";
      })
      .catch((err) => {
        document.getElementById("sucesso").style.display = "block";
      });
  });
});
