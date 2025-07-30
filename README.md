# LiterAlura 📚

🔗 **Acesse o projeto no GitHub:** [https://github.com/jehu1914/literalura](https://github.com/jehu1914/literalura)

---

## 👨‍💻 Autor

| [<img src="https://avatars.githubusercontent.com/u/118707461?v=4" width=115><br><sub>Victor Silot</sub>](https://github.com/jehu1914) |
| :---: |

---

## 🛠️ Tecnologias utilizadas

<p align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" title="Java"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="50" title="Spring Boot"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" width="50" title="PostgreSQL"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="50" title="Maven"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" title="IntelliJ"/>
  <img src="https://img.shields.io/badge/API-Gutendex-4a4a4a?style=flat&logo=bookstack&logoColor=white" title="Gutendex API"/>
</p>

---

## 📖 Sobre o projeto

**LiterAlura** é um catálogo de livros em Java com Spring Boot que consome a API gratuita [Gutendex](https://gutendex.com/) (com mais de 70 mil livros) e persiste os dados em um banco **PostgreSQL**.

Foi desenvolvido como parte do desafio da plataforma Alura, com foco em:

- Consumo de APIs REST externas
- Persistência com Spring Data JPA
- Organização de código em camadas

---

## 🚀 Funcionalidades

A aplicação é executada via terminal e oferece 5 opções:

1. **Buscar livro pelo título** (consome a API Gutendex)
2. **Listar livros registrados** (dados persistidos no banco)
3. **Listar autores registrados**
4. **Listar autores vivos em determinado ano**
5. **Listar livros por idioma** (PT, EN, ES, FR)

> Exemplos utilizados:
- *Dom Casmurro* — Machado de Assis 🇧🇷
- *Emma* — Jane Austen 🇬🇧

---

## ⚙️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/jehu1914/literalura.git
cd literalura
