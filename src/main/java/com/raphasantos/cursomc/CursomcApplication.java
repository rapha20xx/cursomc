package com.raphasantos.cursomc;

import com.raphasantos.cursomc.domain.*;
import com.raphasantos.cursomc.domain.enums.EstadoPagamento;
import com.raphasantos.cursomc.domain.enums.TipoCliente;
import com.raphasantos.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama Mesa e banho");
		Categoria cat4 = new Categoria(null, "Decoração");
		Categoria cat5 = new Categoria(null, "Eletrônico");

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));

		Produto prod1 = new Produto(null,"Computador", 3000.00);
		Produto prod2 = new Produto(null,"Mouse", 20.00);
		Produto prod3 = new Produto(null,"caneta", 1.00);

		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2));
		cat2.getProdutos().addAll(Arrays.asList(prod3));

		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1));
		prod3.getCategorias().addAll(Arrays.asList(cat2));

		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));

		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");

		Cidade cid1 = new Cidade(null, "Sumaré", est1);
		Cidade cid2= new Cidade(null, "Paulinia", est1);
		Cidade cid3= new Cidade(null, "Uberlândia", est2);

		est1.getCidades().addAll(Arrays.asList(cid1,cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36754567", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3862789", "89765432"));

		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "32990276", cli1, cid1);
		Endereco end2 = new Endereco(null, "Rua Matos", "105", "Sala 800", "Centro", "37890876", cli1, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido itemPed1 = new ItemPedido(ped1, prod1, 0.00, 1, 2000.00);
		ItemPedido itemPed2 = new ItemPedido(ped1, prod3, 0.00, 2, 80.00);
		ItemPedido itemPed3 = new ItemPedido(ped2, prod2, 100.00, 1, 800.00);

		prod1.getItens().addAll(Arrays.asList(itemPed1));
		prod2.getItens().addAll(Arrays.asList(itemPed3));
		prod3.getItens().addAll(Arrays.asList(itemPed2));

		itemPedidoRepository.saveAll(Arrays.asList(itemPed1,itemPed2,itemPed3));
	}
}
