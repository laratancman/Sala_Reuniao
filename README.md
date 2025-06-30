# Sistema de Gerenciamento de Salas de Reunião 📅

Projeto Java Web para controle e gerenciamento de salas de reunião de uma empresa. Desenvolvido utilizando **JSP**, **HTML**, **CSS**, **JavaScript** e **JDBC** com acesso a banco de dados.

## 🔍 Sobre o Projeto

O sistema tem como objetivo informatizar o cadastro, consulta e manutenção das salas de reunião da empresa, permitindo que usuários realizem operações de CRUD (Criar, Listar, Atualizar e Deletar) com facilidade por meio de uma interface web intuitiva.

---

## 🧩 Funcionalidades

- ✅ Cadastro de novas salas
- ✅ Listagem de todas as salas cadastradas
- ✅ Edição de salas existentes
- ✅ Exclusão de salas
- ✅ Filtro de busca por nome ou localização

---

## 🧾 Entidade Principal

### `SalaReuniao`
A classe `SalaReuniao` representa uma sala de reunião com os seguintes atributos:

| Atributo              | Tipo      | Descrição                                     |
|-----------------------|-----------|-----------------------------------------------|
| `id`                  | int       | Identificador único da sala                   |
| `nome`                | String    | Nome da sala (ex: "Sala Azul")                |
| `capacidade`          | int       | Capacidade máxima de pessoas                  |
| `localizacao`         | String    | Localização física da sala                    |
| `possuiProjetor`      | boolean   | Indica se possui projetor                     |
| `possuiArCondicionado`| boolean   | Indica se possui ar-condicionado              |
| `numeroCadeiras`      | int       | Quantidade de cadeiras disponíveis            |
| `tipoMesa`            | String    | Tipo de mesa (ex: "Redonda", "Retangular")    |
| `recursosAdicionais`  | String    | Recursos extras (ex: "TV, Flipchart")         |

---

## 🖼️ Interface Web

- Utiliza HTML5, CSS3 e JavaScript puro para interação dinâmica.
- A página de **consulta** apresenta as salas em uma tabela, com botões de edição e exclusão.
- Campo de **busca** permite filtrar por nome ou localização em tempo real usando JavaScript.

---

## 💡 Tecnologias Utilizadas

- **Java Web (JSP)**
- **JDBC** para conexão com o banco de dados
- **HTML5** + **CSS3** + **JavaScript**
- **Servlets** para controle de requisições
- **Banco de dados relacional** (ex: MySQL ou PostgreSQL)

---

## 🧪 Validações Implementadas

- Todos os campos obrigatórios são validados.
- Não é permitido cadastrar capacidades ou quantidades negativas.
- Exclusão exige confirmação do usuário.
- Busca é case-insensitive e funciona parcialmente (contém).

---

## 📁 Organização do Projeto (Arquitetura MVC)

projeto/
│
├── model/ # Classe SalaReuniao e conexão JDBC
├── controller/ # Servlets responsáveis pelo CRUD
├── view/ # Páginas JSP e HTML estáticos
├── css/ # Estilos globais e específicos
├── js/ # Scripts JavaScript (ex: filtro de busca)
└── banco.sql # Script para criação da tabela no banco

---

## ▶️ Como Executar o Projeto

1. Clone o repositório:
2. Importe o projeto em sua IDE Java (ex: Eclipse ou IntelliJ)
3. Configure a conexão com o banco de dados no arquivo de conexão JDBC
4. Importe o script `banco.sql` no seu banco
5. Inicie o servidor (Apache Tomcat ou similar)
6. Acesse via navegador: `http://localhost:8080/sala-reuniao/`

---

## 📌 Autor

Desenvolvido por **Lara Tancman**  
Turma 303 – Projeto de Java Web – 2025

---
