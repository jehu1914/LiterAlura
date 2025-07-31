package br.com.alura.LiterAlura.controller;


import br.com.alura.LiterAlura.model.Autor;
import br.com.alura.LiterAlura.model.Livro;
import br.com.alura.LiterAlura.repository.AutorRepository;
import br.com.alura.LiterAlura.repository.LivroRepository;
import br.com.alura.LiterAlura.service.ConsumoApi;
import br.com.alura.LiterAlura.service.ConsumoGutendexService;
import br.com.alura.LiterAlura.service.ConverteDados;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LiterAluraController {

    private final Scanner scanner = new Scanner(System.in);
    private final LivroRepository livroRepo;
    private final AutorRepository autorRepo;
    private final ConsumoApi api;
    private final ConverteDados conversor;
    private final ConsumoGutendexService gutendexService;

    public LiterAluraController(
            LivroRepository livroRepo,
            AutorRepository autorRepo,
            ConsumoApi api,
            ConverteDados conversor,
            ConsumoGutendexService gutendexService
    ) {
        this.livroRepo = livroRepo;
        this.autorRepo = autorRepo;
        this.api = api;
        this.conversor = conversor;
        this.gutendexService = gutendexService;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                \n=== Menu LiterAlura ===
                1 - Buscar livro por título
                2 - Listar livros registrados
                3 - Listar autores
                4 - Listar autores vivos em determinado ano
                5 - Listar livros por idioma
                6 - Top 10 livros mais baixados
                7 - Buscar autor por nome
                8 - Estatísticas gerais
                0 - Sair
                """);

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1 -> buscarLivroApi();
                case 2 -> listarLivros();
                case 3 -> listarAutores();
                case 4 -> autoresPorAno();
                case 5 -> livrosPorIdioma();
                case 6 -> top10Livros();
                case 7 -> buscarAutor();
                case 8 -> estatisticas();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void buscarLivroApi() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        Optional<Livro> livroExistente = livroRepo.findByTituloIgnoreCase(titulo);
        if (livroExistente.isPresent()) {
            System.out.println("Livro já existe no banco: " + livroExistente.get());
            return;
        }

        Optional<Livro> livro = gutendexService.buscarLivroPorTitulo(titulo);
        if (livro.isPresent()) {
            livroRepo.save(livro.get());
            System.out.println("Livro salvo com sucesso: " + livro.get());
        } else {
            System.out.println("Livro não encontrado na API.");
        }
    }

    private void listarLivros() {
        livroRepo.findAll().forEach(System.out::println);
    }

    private void listarAutores() {
        autorRepo.findAll().forEach(System.out::println);
    }

    private void autoresPorAno() {
        System.out.print("Digite o ano desejado: ");
        int ano;
        try {
            ano = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ano inválido.");
            return;
        }

        List<Autor> autores = autorRepo.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(ano, ano);
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void livrosPorIdioma() {
        System.out.print("Digite o idioma (PT, EN, ES, FR): ");
        String idioma = scanner.nextLine().toUpperCase();
        List<Livro> livros = livroRepo.findByIdioma(idioma);

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado no idioma: " + idioma);
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void top10Livros() {
        List<Livro> top10 = livroRepo.findTop10ByOrderByDownloadsDesc();
        System.out.println("Top 10 livros mais baixados:");
        top10.forEach(System.out::println);
    }

    private void buscarAutor() {
        System.out.print("Digite parte do nome do autor: ");
        String nomeParcial = scanner.nextLine();

        List<Autor> autores = autorRepo.findByNomeContainingIgnoreCase(nomeParcial);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado.");
        } else {
            autores.forEach(autor -> {
                System.out.println("\nAutor encontrado:");
                System.out.println(autor);
                autor.getLivros().forEach(System.out::println);
            });
        }
    }


//    private void buscarAutor() {
//        System.out.print("Digite o nome do autor: ");
//        String nome = scanner.nextLine();
//        Optional<Autor> autor = autorRepo.findByNomeIgnoreCase(nome);
//
//        if (autor.isPresent()) {
//            System.out.println("Autor encontrado:");
//            System.out.println(autor.get());
//            autor.get().getLivros().forEach(System.out::println);
//        } else {
//            System.out.println("Autor não encontrado.");
//        }
//    }

    private void estatisticas() {
        long totalLivros = livroRepo.count();
        long totalAutores = autorRepo.count();
        double mediaDownloads = livroRepo.findAll().stream()
                .mapToInt(Livro::getDownloads)
                .average()
                .orElse(0);

        System.out.println("=== Estatísticas ===");
        System.out.println("Total de livros: " + totalLivros);
        System.out.println("Total de autores: " + totalAutores);
        System.out.printf("Média de downloads: %.2f\n", mediaDownloads);
    }
}
