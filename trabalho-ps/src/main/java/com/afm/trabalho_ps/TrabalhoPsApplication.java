package com.afm.trabalho_ps;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.repository.ProdutoRepository;
import com.afm.trabalho_ps.service.ProdutoService;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.repository.InsumoRepository;
import com.afm.trabalho_ps.service.InsumoService;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.repository.IngredienteRepository;
import com.afm.trabalho_ps.service.RelatorioProdutoService;
import com.afm.trabalho_ps.model.Usuario;
import com.afm.trabalho_ps.repository.UsuarioRepository;
import com.afm.trabalho_ps.model.ItemProduto;
import com.afm.trabalho_ps.repository.ItemProdutoRepository;
import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.repository.VendaRepository;
import com.afm.trabalho_ps.model.ItemVenda;
import com.afm.trabalho_ps.dto.RelatorioVendasDTO;
import com.afm.trabalho_ps.dto.RelatorioProdutoDTO;
import com.afm.trabalho_ps.service.RelatorioVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabalhoPsApplication implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private InsumoRepository insumoRepository;

	@Autowired
	private InsumoService insumoService;

	@Autowired
	private IngredienteRepository ingredienteRepository;

	@Autowired
	private RelatorioProdutoService relatorioProdutoService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ItemProdutoRepository itemProdutoRepository;
	@Autowired
	private VendaRepository vendaRepository;

    @Autowired
    private com.afm.trabalho_ps.service.RelatorioVendasService relatorioService;

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoPsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//		============================================================ CADASTRO DE PRODUTOS ================================================================

        // Padronizar nomes SEM acento, til, cedilha ou qualquer caractere especial
        produtoRepository.save(new Produto(
            "Hidratante Corporal",
            "Formula suave, nutritiva, com consistencia cremosa e rapida absorcao. Ideal para todos os tipos de pele. Contem ativos antioxidantes que auxiliam na hidratacao e regeneracao da pele. Principais ativos: Manteiga de Manga, Oleo Vegetal de Castanha do Para, Oleo Vegetal de Pracaxi, Cera de Coco, Glicerina Vegetal, Lactato de Sodio, Vitamina E, agua desmineralizada, Azeite de oliva, Oleos essenciais e Oleoresina Alecrim. "
        ));
        produtoRepository.save(new Produto(
            "Shampoo de Dolomita",
            "O Shampoo de Dolomita e um produto inovador que combina a pureza da dolomita com ingredientes naturais para proporcionar uma limpeza suave e eficaz aos cabelos. A dolomita, um mineral rico em magnesio e calcio, e conhecida por suas propriedades beneficas para a saude capilar. Este shampoo e formulado para nutrir, fortalecer e revitalizar os fios, deixando-os macios, brilhantes e saudaveis."
        ));
        produtoRepository.save(new Produto(
            "Shampoo de Spirulina",
            "O Shampoo de Spirulina e um produto inovador que combina a poderosa alga spirulina com ingredientes naturais para proporcionar uma limpeza suave e eficaz aos cabelos. A spirulina, rica em proteinas, vitaminas e minerais, e conhecida por suas propriedades beneficas para a saude capilar. Este shampoo e formulado para nutrir, fortalecer e revitalizar os fios, deixando-os macios, brilhantes e saudaveis."
        ));
        produtoRepository.save(new Produto(
            "Shampoo Detox",
            "Um Shampoo de limpeza profunda que renova a saude dos cabelos, controla a oleosidade e remove residuos sem desidratar os fios. Ele e RECOMENDADO PARA TODOS OS TIPOS DE CABELOS. Possui em sua composicao o Carvao Ativado e a Argila preta eles agem como removedor de toxinas e auxilia no crescimento dos fios, ja o Oleo essencial de Menta refresca e ajuda no combate a descamacao excessiva do couro cabeludo (caspa)."
        ));
        produtoRepository.save(new Produto(
            "Sache Perfumado",
            "Nossos saches perfumados sao cuidadosamente elaborados com essencia premium vermiculita, um mineral que potencializa a fixacao e a durabilidade das fragrancias, liberando o aroma de forma suave e continua por semanas. Perfeitos para perfumar gavetas, closets, bolsas, carros ou qualquer cantinho especial, eles proporcionam bem-estar e aconchego ao ambiente, transformando a rotina com os beneficios da aromaterapia."
        ));
        produtoRepository.save(new Produto(
            "Home Spray",
            "Desfrute de ambientes cheirosos e tenha uma experiencia unica e marcante com nossas colecoes de Home Spray com perfumes exclusivos da linha de produtos para casa.. Sao diversas fragrancias desenvolvidas especialmente para conquistar ambientes mais intimos, romanticos ou urbanos."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Arroz e Lavanda",
            "Experimente o poder da natureza com nosso Sabonete Natural de Arroz e Lavanda, formulado para proporcionar um cuidado suave e eficaz para a sua pele. Com uma combinacao unica de ingredientes naturais, esse sabonete oferece beneficios incriveis, como:"
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Capim Limao",
            "Auxilia na limpeza profunda da pele, combatendo impurezas e bacterias. Ajuda a proteger a pele contra os danos dos radicais livres. O aroma suave do capim limao proporciona uma sensacao de frescor e tranquilidade."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Pimenta Rosa",
            "Quer cuidar da sua pele com um toque natural e eficaz? Nosso Sabonete de Pimenta Rosa com Oleo Essencial de Hortela-Pimenta e a escolha perfeita para quem busca alivio e frescor no dia a dia. Com propriedades adstringentes, antisepticas e antifungicas, ele auxilia no tratamento de dermatites, psoriase e outras irritacoes da pele."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Camomila",
            "O Sabonete de Camomila e o cuidado diario que a sua pele merece. Rico em flavonoides e cumarina, ingredientes naturais com propriedades calmantes e cicatrizantes, ele proporciona uma limpeza profunda e suave, respeitando o equilibrio natural da pele Com acao hidratante e regeneradora, evita o ressecamento e melhora a textura da pele, deixando-a com um aspecto mais saudavel, iluminado e jovem. Sua formula delicada auxilia no clareamento de manchas, promove a elasticidade e combate o aspecto seco e envelhecido."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Maracuja",
            "Promove hidratacao e cicatrizacao ao mesmo tempo. A adicao de suas sementes na composicao do produto, produz uma esfoliacao leve e a esperada sensacao de limpeza. Sua apresentacao em duas camadas da ao sabonete uma interessante lembranca da fruta."
        ));
        produtoRepository.save(new Produto(
            "Vela Aromatica",
            "Vela aromatica feita com cera de soja, pavio de madeira e oleos essenciais naturais. Proporciona uma experiencia sensorial unica, com aromas envolventes que criam um ambiente acolhedor e relaxante."
        ));

//		============================================================ CADASTRO DE INSUMOS ================================================================

        insumoRepository.save(new Insumo(
            "Oleo de Ricino",
			10
        ));
		insumoRepository.save(new Insumo(
			"Manteiga de Cupuacu",
			10
		));
		insumoRepository.save(new Insumo(
			"BTMS",
			10
		));
		insumoRepository.save(new Insumo(
			"Cera de Carnauba",
			10
		));
		insumoRepository.save(new Insumo(
			"SCI",
			10
		));
		insumoRepository.save(new Insumo(
			"Spirulina em po",
			10
		));
		insumoRepository.save(new Insumo(
			"Betaina",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Capim Limao",
			10
		));
		insumoRepository.save(new Insumo(
			"Acido Lactico",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleoresina de Alecrim",
			10
		));
		insumoRepository.save(new Insumo(
			"Nipaguarde",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleo essencial de Capim Limao",
			10
		));
		insumoRepository.save(new Insumo(
			"Dolomita em po",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Camomila",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleo essencial de Jasmin",
			10
		));
		insumoRepository.save(new Insumo(
			"Violeta Gensiana",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Hortela",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleo essencial de Hortela-Pimenta",
			10
		));
		insumoRepository.save(new Insumo(
			"Carvao Ativado",
			10
		));
		insumoRepository.save(new Insumo(
			"Argila Preta",
			10
		));
		insumoRepository.save(new Insumo(
			"Manteiga de Ucuuba",
			10
		));
		insumoRepository.save(new Insumo(
			"Manteiga de Manga",
			10
		));
		insumoRepository.save(new Insumo(
			"Base glicerinada branca vegana",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Aveia",
			10
		));
		insumoRepository.save(new Insumo(
			"Castanha do Para em po",
			10
		));
		insumoRepository.save(new Insumo(
			"Arroz",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleo Essencial de Lavanda",
			10
		));
		insumoRepository.save(new Insumo(
			"Lauril Vegetal",
			10
		));
		insumoRepository.save(new Insumo(
			"Oxido de Cromo Verde",
			10
		));
		insumoRepository.save(new Insumo(
			"Glicerina bidestilada",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Pimenta Rosa",
			10
		));
		insumoRepository.save(new Insumo(
			"Pimenta Rosa",
			10
		));
		insumoRepository.save(new Insumo(
			"Essencia de Camomila",
			10
		));
		insumoRepository.save(new Insumo(
			"Mica Laranja",
			10
		));
		insumoRepository.save(new Insumo(
			"Essencia de Maracuja",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Aloe Vera",
			10
		));
		insumoRepository.save(new Insumo(
			"Semente de Maracuja",
			10
		));
		insumoRepository.save(new Insumo(
			"Estearato de glicerila GMS",
			10
		));
		insumoRepository.save(new Insumo(
			"Alcool Cetilico",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleo de Amendoas",
			10
		));
		insumoRepository.save(new Insumo(
			"Agua Destilada",
			10
		));
		insumoRepository.save(new Insumo(
			"Vitamina E",
			10
		));
		insumoRepository.save(new Insumo(
			"Manteiga de Karite",
			10
		));
		insumoRepository.save(new Insumo(
			"Vermiculita",
			10
		));
		insumoRepository.save(new Insumo(
			"Alcool de Cereais",
			10
		));
		insumoRepository.save(new Insumo(
			"Essencia de algodao",
			10
		));
		insumoRepository.save(new Insumo(
			"Base de Aromatizador",
			10
		));
		insumoRepository.save(new Insumo(
			"Cera vegetal de coco",
			10
		));
		insumoRepository.save(new Insumo(
			"Pavilo de madeira",
			10
		));
//		============================================================ CADASTRO DE INGREDIENTES ================================================================

        // Padronizar buscas de ingredientes
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Oleo de Ricino"),
            10,
            "ml"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Manteiga de Cupuacu"),
            10,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("BTMS"),
            4,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Cera de Carnauba"),
            10,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("SCI"),
            100,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Spirulina em po"),
            30,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Betaina"),
            8,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Extrato de Capim Limao"),
            4,
            "ml"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Acido Lactico"),
            2,
            "ml"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
            1,
            "ml"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Nipaguarde"),
            1,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Alcool Cetilico"),
            4,
            "ml"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Oleo de Ricino"),
            10,
            "ml"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Manteiga de Manga"),
            10,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("BTMS"),
            4,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Cera de Carnauba"),
            10,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("SCI"),
            100,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Dolomita em po"),
            30,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Betaina"),
            8,
            "mg"
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Extrato de Camomila"),
            4,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Acido Lactico"),
            2,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
            1,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Nipaguarde"),
            1,
			"mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Oleo essencial de Jasmin"),
            2,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Violeta Gensiana"),
            5,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Alcool Cetilico"),
            4,
			"ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Oleo de Ricino"),
            10,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Manteiga de Ucuuba"),
            10,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("BTMS"),
            4,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Cera de Carnauba"),
            10,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("SCI"),
            100,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Carvao Ativado"),
            20,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Argila Preta"),
            20,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Betaina"),
            8,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Extrato de Hortela"),
            4,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Acido Lactico"),
            2,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
            1,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Nipaguarde"),
            1,
			"mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Oleo Essencial de Hortela-Pimenta"),
            2,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
            600,
			"mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Extrato de Aveia"),
            15,
			"mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Castanha do Para em po"),
            10,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Arroz"),
            150,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Oleo Essencial de Lavanda"),
            5,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limao"),
            insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
            600,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limao"),
            insumoService.buscarIdPorNome("Extrato de Capim Limao"),
            15,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limao"),
            insumoService.buscarIdPorNome("Lauril Vegetal"),
            10,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limao"),
            insumoService.buscarIdPorNome("Oleo Essencial de Capim Limao"),
            5,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limao"),
            insumoService.buscarIdPorNome("Oxido de Cromo Verde"),
            1,
            "mg"
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limao"),
            insumoService.buscarIdPorNome("Glicerina bidestilada"),
            5,
            "ml"
        ));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
			600,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Extrato de Pimenta Rosa"),
			15,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Lauril Vegetal"),
			10,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Oleo Essencial de Hortela-Pimenta"),
			5,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Pimenta Rosa"),
			20,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
			600,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Extrato de Aloe Vera"),
			15,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Lauril Vegetal"),
			10,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("glicerina bidestilada"),
			5,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Mica Laranja"),
			1,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Essencia de Maracuja"),
			15,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Semente de Maracuja"),
			2,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Camomila"),
			insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
			600,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Extrato de Camomila"),
			15,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Camomila"),
			insumoService.buscarIdPorNome("Lauril Vegetal"),
			10,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Camomila"),
			insumoService.buscarIdPorNome("Essencia de Camomila"),
			15,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Estearato de glicerila GMS"),
			85,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Alcool Cetilico"),
			15,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Oleo de Amendoas"),
			65,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Manteiga de Karite"),
			63,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Agua Destilada"),
			750,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Glicerina bidestilada"),
			13,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Nipaguarde"),
			8,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
			2,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Vitamina E"),
			2,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Oleo Essencial de Lavanda"),
			10,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sache Perfumado"),
			insumoService.buscarIdPorNome("Vermiculita"),
			250,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sache Perfumado"),
			insumoService.buscarIdPorNome("Essencia de algodao"),
			25,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sache Perfumado"),
			insumoService.buscarIdPorNome("Alcool de Cereais"),
			25,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Home Spray"),
			insumoService.buscarIdPorNome("Agua Destilada"),
			180,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Home Spray"),
			insumoService.buscarIdPorNome("Essencia de algodao"),
			20,
			"ml"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Vela Aromatica"),
			insumoService.buscarIdPorNome("Cera vegetal de coco"),
			150,
			"mg"
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Vela Aromatica"),
			insumoService.buscarIdPorNome("Essencia de camomila"),
			15,
			"ml"
		));


// ===================== DADOS MINIMOS PARA RELATORIO DE VENDAS =====================
        // 1. Usuario
        Usuario usuario1 = new Usuario("Maria Silva", "maria@email.com", "Rua das Flores, 123", "1990-01-01", "senha123", "11999999999");
        Usuario usuario2 = new Usuario("Joao Souza", "joao@email.com", "Av. Brasil, 456", "1985-05-10", "senha456", "11988888888");
        Usuario usuario3 = new Usuario("Ana Lima", "ana@email.com", "Rua Verde, 789", "1992-09-20", "senha789", "11977777777");
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);

        // Usuários do grupo para login de teste
        usuarioRepository.save(new Usuario("Miguel Jehle", "migueljehle@github.com", "Rua 1", "1995-01-01", "12345678", "11999990001"));
        usuarioRepository.save(new Usuario("Vania", "vaniacourses@github.com", "Rua 2", "1990-02-02", "12345678", "11999990002"));
        // ...adicione mais membros se necessário

        // Produtos já cadastrados
        Produto produto1 = produtoRepository.findAll().stream().filter(p -> p.getNome().equals("Shampoo de Dolomita")).findFirst().orElseThrow();
        Produto produto2 = produtoRepository.findAll().stream().filter(p -> p.getNome().equals("Sabonete de Maracuja")).findFirst().orElseThrow();
        Produto produto3 = produtoRepository.findAll().stream().filter(p -> p.getNome().equals("Hidratante Corporal")).findFirst().orElseThrow();
        // ItemProdutos
        ItemProduto itemProduto1 = itemProdutoRepository.findAll().stream().filter(ip -> ip.getProduto().getId().equals(produto1.getId())).findFirst().orElseGet(() -> itemProdutoRepository.save(new ItemProduto(produto1, 10, new java.math.BigDecimal("20.00"))));
        ItemProduto itemProduto2 = itemProdutoRepository.findAll().stream().filter(ip -> ip.getProduto().getId().equals(produto2.getId())).findFirst().orElseGet(() -> itemProdutoRepository.save(new ItemProduto(produto2, 15, new java.math.BigDecimal("12.00"))));
        ItemProduto itemProduto3 = itemProdutoRepository.findAll().stream().filter(ip -> ip.getProduto().getId().equals(produto3.getId())).findFirst().orElseGet(() -> itemProdutoRepository.save(new ItemProduto(produto3, 8, new java.math.BigDecimal("30.00"))));
        // Venda 1
        Venda venda1 = new Venda("FINALIZADA", 40.0, java.time.LocalDate.now(), usuario1);
        ItemVenda itemVenda1 = new ItemVenda(itemProduto1, 2, new java.math.BigDecimal("20.00"));
        itemVenda1.setVenda(venda1);
        venda1.setItens(java.util.Arrays.asList(itemVenda1));
        vendaRepository.save(venda1);
        // Venda 2
        Venda venda2 = new Venda("FINALIZADA", 24.0, java.time.LocalDate.now().minusDays(1), usuario2);
        ItemVenda itemVenda2 = new ItemVenda(itemProduto2, 2, new java.math.BigDecimal("12.00"));
        itemVenda2.setVenda(venda2);
        venda2.setItens(java.util.Arrays.asList(itemVenda2));
        vendaRepository.save(venda2);
        // Venda 3
        Venda venda3 = new Venda("FINALIZADA", 60.0, java.time.LocalDate.now().minusDays(2), usuario3);
        ItemVenda itemVenda3 = new ItemVenda(itemProduto3, 2, new java.math.BigDecimal("30.00"));
        itemVenda3.setVenda(venda3);
        venda3.setItens(java.util.Arrays.asList(itemVenda3));
        vendaRepository.save(venda3);
        // Venda 4 (com mais de um item)
        Venda venda4 = new Venda("FINALIZADA", 62.0, java.time.LocalDate.now().minusDays(3), usuario1);
        ItemVenda itemVenda4a = new ItemVenda(itemProduto1, 1, new java.math.BigDecimal("20.00"));
        ItemVenda itemVenda4b = new ItemVenda(itemProduto2, 1, new java.math.BigDecimal("12.00"));
        ItemVenda itemVenda4c = new ItemVenda(itemProduto3, 1, new java.math.BigDecimal("30.00"));
        itemVenda4a.setVenda(venda4);
        itemVenda4b.setVenda(venda4);
        itemVenda4c.setVenda(venda4);
        venda4.setItens(java.util.Arrays.asList(itemVenda4a, itemVenda4b, itemVenda4c));
        vendaRepository.save(venda4);

        // ===================== RELATORIO DE VENDAS =====================
        RelatorioVendasDTO relatorio = relatorioService.gerarRelatorio();
        System.out.println("\n===== RELATÓRIO DE VENDAS =====\n");
        System.out.println("Total vendido: " + relatorio.totalVendido);
        System.out.println("Total de itens vendidos: " + relatorio.totalItensVendidos);
        System.out.println("Produto mais vendido: " + relatorio.produtoMaisVendido + " (" + relatorio.quantidadeMaisVendida + ")\n");
        for (RelatorioVendasDTO.VendaResumo vendaResumo : relatorio.vendas) {
            System.out.println("Venda #" + vendaResumo.id + " | Cliente: " + vendaResumo.cliente + " | Data: " + vendaResumo.data + " | Valor: " + vendaResumo.valorTotal);
            for (RelatorioVendasDTO.ItemResumo item : vendaResumo.itens) {
                System.out.println("    - " + item.produto + ": " + item.quantidade);
            }
            System.out.println();
        }

        // Usuário admin para login diferenciado
        usuarioRepository.save(new Usuario(
            "Administrador",
            "admin@admin.com",
            "Rua do Admin, 1",
            "1980-01-01",
            "password",
            "11999990000"
        ));
    }
}
