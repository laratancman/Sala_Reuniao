function listarSalas() {
  fetch("http://localhost:8080/sala-reuniao/listar")
    .then((res) => res.json())
    .then((data) => {
      const tbody = document.getElementById("salas");
      tbody.innerHTML = ""; 

      data.forEach((sala) => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
          <td>${sala.nome}</td>
          <td>${sala.capacidade}</td>
          <td>${sala.localizacao}</td>
          <td>${sala.possuiProjetor ? "Sim" : "Não"}</td>
          <td>${sala.possuiArCondicionado ? "Sim" : "Não"}</td>
          <td>${sala.numCadeiras}</td>
          <td>${sala.tipoMesa}</td>
          <td>${sala.recursosAdicionais}</td>
          <td><button class="btn-editar">Editar</button></td>
          <td><button class="btn-excluir">Excluir</button></td>
        `;

        tr.querySelector(".btn-editar").addEventListener("click", () => {
          localStorage.setItem("idSalaSelecionada", sala.id);
          window.location.href = "alterar.html"; 
        });

        tr.querySelector(".btn-excluir").addEventListener("click", () => {
          if (confirm("Deseja realmente excluir essa sala?")) {
            fetch(`http://localhost:8080/sala-reuniao/deletar/${sala.id}`, {
              method: "DELETE",
            })
              .then((res) => {
                if (!res.ok)
                  return res.text().then((text) => {
                    throw new Error(text);
                  });
                alert("Sala excluída com sucesso!");
                listarSalas();
              })
              .catch((err) => alert("Erro ao excluir sala: " + err.message));
          }
        });

        tbody.appendChild(tr);
      });
    });
}

document.addEventListener("DOMContentLoaded", listarSalas);
