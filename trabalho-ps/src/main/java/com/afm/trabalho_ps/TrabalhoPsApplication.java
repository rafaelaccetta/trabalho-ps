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

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoPsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//		============================================================ CADASTRO DE PRODUTOS ================================================================

        produtoRepository.save(new Produto(
            "Hidratante Corporal",
            "Fórmula suave, nutritiva, com consistência cremosa e rápida absorção. Ideal para todos os tipos de pele. Contém ativos antioxidantes que auxiliam na hidratação e regeneração da pele. Principais ativos: Manteiga de Manga, Óleo Vegetal de Castanha do Pará, Óleo Vegetal de Pracaxi, Cera de Coco, Glicerina Vegetal, Lactado de Sódio, Vitamina E, água desmineralizada, Azeite de oliva, Óleos essenciais e Oleoresina Alecrim. "
        ));
        produtoRepository.save(new Produto(
            "Shampoo de Dolomita",
            "O Shampoo de Dolomita é um produto inovador que combina a pureza da dolomita com ingredientes naturais para proporcionar uma limpeza suave e eficaz aos cabelos. A dolomita, um mineral rico em magnésio e cálcio, é conhecida por suas propriedades benéficas para a saúde capilar. Este shampoo é formulado para nutrir, fortalecer e revitalizar os fios, deixando-os macios, brilhantes e saudáveis."
        ));
        produtoRepository.save(new Produto(
            "Shampoo de Spirulina",
            "O Shampoo de Spirulina é um produto inovador que combina a poderosa alga spirulina com ingredientes naturais para proporcionar uma limpeza suave e eficaz aos cabelos. A spirulina, rica em proteínas, vitaminas e minerais, é conhecida por suas propriedades benéficas para a saúde capilar. Este shampoo é formulado para nutrir, fortalecer e revitalizar os fios, deixando-os macios, brilhantes e saudáveis."
        ));
        produtoRepository.save(new Produto(
            "Shampoo Detox",
            "Um Shampoo de limpeza profunda que renova a saúde dos cabelos, controla a oleosidade e remove resíduos sem desidratar os fios. Ele é RECOMENDADO PARA TODOS OS TIPOS DE CABELOS. Possui em sua composição o Carvão Ativado e a Argila preta eles agem como removedor de toxinas e auxilia no crescimento dos fios, já o Óleo essencial de Menta refresca e ajuda no combate à descamação excessiva do couro cabeludo (caspa)."
        ));
        produtoRepository.save(new Produto(
            "Sachê Perfumado",
            "Nossos sachês perfumados são cuidadosamente elaborados com essência premium vermiculita, um mineral que potencializa a fixação e a durabilidade das fragrâncias, liberando o aroma de forma suave e contínua por semanas. Perfeitos para perfumar gavetas, closets, bolsas, carros ou qualquer cantinho especial, eles proporcionam bem-estar e aconchego ao ambiente, transformando a rotina com os benefícios da aromaterapia."
        ));
        produtoRepository.save(new Produto(
            "Home Spray",
            "Desfrute de ambientes cheirosos e tenha uma experiência única e marcante com nossas coleções de Home Spray com perfumes exclusivos da linha de produtos para casa.. São diversas fragrâncias desenvolvidas especialmente para conquistar ambientes mais íntimos, românticos ou urbanos."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Arroz e Lavanda",
            "Experimente o poder da natureza com nosso Sabonete Natural de Arroz e Lavanda, formulado para proporcionar um cuidado suave e eficaz para a sua pele. Com uma combinação única de ingredientes naturais, esse sabonete oferece benefícios incríveis, como:"
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Capim Limão",
            "Auxilia na limpeza profunda da pele, combatendo impurezas e bactérias. Ajuda a proteger a pele contra os danos dos radicais livres. O aroma suave do capim limão proporciona uma sensação de frescor e tranquilidade."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Pimenta Rosa",
            "Quer cuidar da sua pele com um toque natural e eficaz? Nosso Sabonete de Pimenta Rosa com Óleo Essencial de Hortelã-Pimenta é a escolha perfeita para quem busca alívio e frescor no dia a dia. Com propriedades adstringentes, antissépticas e antifúngicas, ele auxilia no tratamento de dermatites, psoríase e outras irritações da pele."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Camomila",
            "O Sabonete de Camomila é o cuidado diário que a sua pele merece. Rico em flavonoides e cumarina, ingredientes naturais com propriedades calmantes e cicatrizantes, ele proporciona uma limpeza profunda e suave, respeitando o equilíbrio natural da pele Com ação hidratante e regeneradora, evita o ressecamento e melhora a textura da pele, deixando-a com um aspecto mais saudável, iluminado e jovem. Sua fórmula delicada auxilia no clareamento de manchas, promove a elasticidade e combate o aspecto seco e envelhecido."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Maracuja",
            "Promove hidratação e cicatrização ao mesmo tempo. A adição de suas sementes na composição do produto, produz uma esfoliação leve e a esperada sensação de limpeza. Sua apresentação em duas camadas dá ao sabonete uma interessante lembrança da fruta."
        ));
        produtoRepository.save(new Produto(
            "Vela Aromática",
            "Vela aromática feita com cera de soja, pavio de madeira e óleos essenciais naturais. Proporciona uma experiência sensorial única, com aromas envolventes que criam um ambiente acolhedor e relaxante."
        ));

//		============================================================ CADASTRO DE INSUMOS ================================================================

        insumoRepository.save(new Insumo(
            "Óleo de Ricino",
			10
        ));
		insumoRepository.save(new Insumo(
			"Manteiga de Cupuaçu",
			10
		));
		insumoRepository.save(new Insumo(
			"BTMS",
			10
		));
		insumoRepository.save(new Insumo(
			"Cera de Carnaúba",
			10
		));
		insumoRepository.save(new Insumo(
			"SCI",
			10
		));
		insumoRepository.save(new Insumo(
			"Spirulina em pó",
			10
		));
		insumoRepository.save(new Insumo(
			"Betaina",
			10
		));
		insumoRepository.save(new Insumo(
			"Extrato de Capim Limão",
			10
		));
		insumoRepository.save(new Insumo(
			"Ácido Láctico",
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
			"Oleos essenciais de Capim Limão",
			10
		));
		insumoRepository.save(new Insumo(
			"Dolomita em pó",
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
			"Extrato de Hortelã",
			10
		));
		insumoRepository.save(new Insumo(
			"Oleo essencial de Hortelã-Pimenta",
			10
		));
		insumoRepository.save(new Insumo(
			"Carvão Ativado",
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
			"Castanha do Pará em pó",
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
			"Óxido de Cromo Verde",
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
			"Semente de Maracujá",
			10
		));
		insumoRepository.save(new Insumo(
			"Estearato de glicerila GMS",
			10
		));
		insumoRepository.save(new Insumo(
			"Alcool Cetílico",
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
			"Manteiga de Karité",
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
			"Essencia de algodão",
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

        ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Oleo de Ricino"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Manteiga de Cupuaçu"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("BTMS"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Cera de Carnaúba"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("SCI"),
            100	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Spirulina em pó"),
            30	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Betaina"),
            8	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Capim Limão"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Acido Láctico"),
            2	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Nipaguarde"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Oleo Essencial de Capim Limão"),
            2	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Spirulina"),
            insumoService.buscarIdPorNome("Alcool Cetílico"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Oleo de Ricino"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Manteiga de Manga"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("BTMS"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Cera de Carnaúba"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("SCI"),
            100	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Dolomita em pó"),
            30	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Betaina"),
            8	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Extrato de Camomila"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Acido Láctico"),
            2	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Nipaguarde"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Oleo Essencial de Jasmin"),
            2	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Violeta Gensiana"),
            5	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo de Dolomita"),
            insumoService.buscarIdPorNome("Alcool Cetílico"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Oleo de Ricino"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Manteiga de Ucuuba"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("BTMS"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Cera de Carnaúba"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("SCI"),
            100	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Carvão Ativado"),
            20	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Argila Preta"),
            20	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Betaina"),
            8	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Extrato de Hortelã"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Acido Láctico"),
            2	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Nipaguarde"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Oleo Essencial de Hortelã-Pimenta"),
            2	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Shampoo Detox"),
            insumoService.buscarIdPorNome("Alcool Cetílico"),
            4	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
            600	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Extrato de Aveia"),
            15
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Castanha do Pará em pó"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Arroz"),
            150	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Arroz e Lavanda"),
            insumoService.buscarIdPorNome("Oleo Essencial de Lavanda"),
            5	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limão"),
            insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
            600	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limão"),
            insumoService.buscarIdPorNome("Extrato de Capim Limão"),
            15	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limão"),
            insumoService.buscarIdPorNome("Lauril Vegetal"),
            10	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limão"),
            insumoService.buscarIdPorNome("Oleo Essencial de Capim Limão"),
            5	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limão"),
            insumoService.buscarIdPorNome("Óxido de Cromo Verde"),
            1	
        ));
		ingredienteRepository.save(new Ingrediente(
            produtoService.buscarIdPorNome("Sabonete de Capim Limão"),
            insumoService.buscarIdPorNome("Glicerina bidestilada"),
            5	
        ));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
			600	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Extrato de Pimenta Rosa"),
			15	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Lauril Vegetal"),
			10	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Oleo Essencial de Hortelã-Pimenta"),
			5	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Pimenta Rosa"),
			insumoService.buscarIdPorNome("Pimenta Rosa"),
			20	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
			600	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Extrato de Aloe Vera"),
			15	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Lauril Vegetal"),
			10	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("glicerina bidestilada"),
			5	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Mica Laranja"),
			1	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Essencia de Maracuja"),
			15	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Semente de Maracuja"),
			2	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Camomila"),
			insumoService.buscarIdPorNome("Base glicerinada branca vegana"),
			600	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Maracuja"),
			insumoService.buscarIdPorNome("Extrato de Camomila"),
			15	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Camomila"),
			insumoService.buscarIdPorNome("Lauril Vegetal"),
			10	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sabonete de Camomila"),
			insumoService.buscarIdPorNome("Essencia de Camomila"),
			15	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Estearato de glicerila GMS"),
			85	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Alcool Cetílico"),
			15	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Oleo de Amendoas"),
			65	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Manteiga de Karité"),
			63	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Agua Destilada"),
			750	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Glicerina bidestilada"),
			13	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Nipaguarde"),
			8	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Oleoresina de Alecrim"),
			2	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Vitamina E"),
			2	
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Hidratante Corporal"),
			insumoService.buscarIdPorNome("Oleo Essencial de Lavanda"),
			10
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sache Perfumado"),
			insumoService.buscarIdPorNome("Vermiculita"),
			250
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sache Perfumado"),
			insumoService.buscarIdPorNome("Essencia de algodão"),
			25
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Sache Perfumado"),
			insumoService.buscarIdPorNome("Alcool de Cereais"),
			25
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Home Spray"),
			insumoService.buscarIdPorNome("Agua Destilada"),
			180
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Home Spray"),
			insumoService.buscarIdPorNome("Essencia de algodão"),
			20
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Vela Aromática"),
			insumoService.buscarIdPorNome("Cera vegetal de coco"),
			150
		));
		ingredienteRepository.save(new Ingrediente(
			produtoService.buscarIdPorNome("Vela Aromática"),
			insumoService.buscarIdPorNome("Essencia de camomila"),
			15
		));

// ===================== RELATÓRIO DE PRODUTOS E INGREDIENTES =====================
        relatorioProdutoService.imprimirRelatorioProdutosEIngredientes();
    }
}
