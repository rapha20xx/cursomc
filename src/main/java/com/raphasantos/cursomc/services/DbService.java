package com.raphasantos.cursomc.services;

import com.raphasantos.cursomc.domain.*;
import com.raphasantos.cursomc.domain.enums.EstadoPagamento;
import com.raphasantos.cursomc.domain.enums.Perfil;
import com.raphasantos.cursomc.domain.enums.TipoCliente;
import com.raphasantos.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

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

    public void instantiateTestDataBase() throws ParseException {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Cama Mesa e banho");
        Categoria cat4 = new Categoria(null, "Eletrônico");
        Categoria cat5 = new Categoria(null, "Jardinagem");
        Categoria cat6 = new Categoria(null, "Decoração");
        Categoria cat7 = new Categoria(null, "Perfumaria");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
        Produto p5 = new Produto(null, "Toalha", 50.00);
        Produto p6 = new Produto(null, "Colcha", 200.00);
        Produto p7 = new Produto(null, "TV true color", 1200.00);
        Produto p8 = new Produto(null, "Roçadeira", 800.00);
        Produto p9 = new Produto(null, "Abajour", 100.00);
        Produto p10 = new Produto(null, "Pendente", 180.00);
        Produto p11 = new Produto(null, "Shampoo", 90.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        Estado est1 = new Estado(null, "São Paulo");
        Estado est2 = new Estado(null, "Minas Gerais");

        Cidade cid1 = new Cidade(null, "Sumaré", est1);
        Cidade cid2= new Cidade(null, "Paulinia", est1);
        Cidade cid3= new Cidade(null, "Uberlândia", est2);

        est1.getCidades().addAll(Arrays.asList(cid1,cid2));
        est2.getCidades().addAll(Arrays.asList(cid3));

        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36754567", TipoCliente.PESSOAFISICA,bCryptPasswordEncoder.encode("123") );
        cli1.getTelefones().addAll(Arrays.asList("3862789", "89765432"));

        Cliente cli2 = new Cliente(null, "Ana Costa", "ana@hotmail.com", "31628382740", TipoCliente.PESSOAFISICA, bCryptPasswordEncoder.encode("123"));
        cli2.getTelefones().addAll(Arrays.asList("93883321", "34252625"));
        cli2.addPerfil(Perfil.ADMIN);

        Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "32990276", cli1, cid1);
        Endereco end2 = new Endereco(null, "Rua Matos", "105", "Sala 800", "Centro", "37890876", cli1, cid2);
        Endereco end3 = new Endereco(null, "Avenida Floriano", "2106", null, "Centro", "281777012", cli2, cid2);

        cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
        cli2.getEnderecos().addAll(Arrays.asList(end3));

        clienteRepository.saveAll(Arrays.asList(cli1,cli2));
        enderecoRepository.saveAll(Arrays.asList(end1,end2,end3));

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

        ItemPedido itemPed1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido itemPed2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido itemPed3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        p1.getItens().addAll(Arrays.asList(itemPed1));
        p2.getItens().addAll(Arrays.asList(itemPed3));
        p3.getItens().addAll(Arrays.asList(itemPed2));

        itemPedidoRepository.saveAll(Arrays.asList(itemPed1,itemPed2,itemPed3));

    }
}
