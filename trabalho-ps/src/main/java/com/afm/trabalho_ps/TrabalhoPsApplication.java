package com.afm.trabalho_ps;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.repository.ProdutoRepository;
import com.afm.trabalho_ps.service.ProdutoService;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.repository.InsumoRepository;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.repository.IngredienteRepository;
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
	private IngredienteRepository ingredienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoPsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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
            "Sabonete de Maracujá",
            "Promove hidratação e cicatrização ao mesmo tempo. A adição de suas sementes na composição do produto, produz uma esfoliação leve e a esperada sensação de limpeza. Sua apresentação em duas camadas dá ao sabonete uma interessante lembrança da fruta."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Canela",
            "Ele é afrodisíaco, estimulante, traz elasticidade e brilho à pele, e possui propriedades esfoliantes. Por conter alto teor de antioxidantes, ela é excelente no combate ao envelhecimento da cutis."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Curcuma",
            "Com propriedades anti-inflamatórias e antioxidantes, ajuda no tratamento de doenças inflamatória como psoríase e dermatite atópica, este sabonete vai deixar a sua pele com uma aparência mais jovem e saudável."
        ));
        produtoRepository.save(new Produto(
            "Sabonete de Carvão e Argila",
            "Auxilia na limpeza profunda da pele, combatendo impurezas e bactérias. Ajuda a proteger a pele contra os danos dos radicais livres. O aroma suave do capim limão proporciona uma sensação de frescor e tranquilidade."
        ));
        produtoRepository.save(new Produto(
            "Vela Aromática",
            "Vela aromática feita com cera de soja, pavio de madeira e óleos essenciais naturais. Proporciona uma experiência sensorial única, com aromas envolventes que criam um ambiente acolhedor e relaxante."
        ));
        insumoRepository.save(new Insumo(
            "Hidratante Corporal",
			2,
            "Fórmula suave, nutritiva, com consistência cremosa e rápida absorção. Ideal para todos os tipos de pele. Contém ativos antioxidantes que auxiliam na hidratação e regeneração da pele. Principais ativos: Manteiga de Manga, Óleo Vegetal de Castanha do Pará, Óleo Vegetal de Pracaxi, Cera de Coco, Glicerina Vegetal, Lactado de Sódio, Vitamina E, água desmineralizada, Azeite de oliva, Óleos essenciais e Oleoresina Alecrim. "
        ));
        ingredienteRepository.save(new Ingrediente(
            produtoService.findByName("Hidratante Corporal").getId(),
            1,
            100
        ));
    }
}
