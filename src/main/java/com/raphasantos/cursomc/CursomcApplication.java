package com.raphasantos.cursomc;

import com.raphasantos.cursomc.domain.Categoria;
import com.raphasantos.cursomc.domain.Produto;
import com.raphasantos.cursomc.repositories.CategoriaRepository;
import com.raphasantos.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));

		Produto prod1 = new Produto(null,"Computador", 3000.00);
		Produto prod2 = new Produto(null,"Mouse", 20.00);
		Produto prod3 = new Produto(null,"caneta", 1.00);

		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2));
		cat2.getProdutos().addAll(Arrays.asList(prod3));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat2));

		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
	}
}
