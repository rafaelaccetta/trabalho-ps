import { useRelatorioProduto } from '../hooks/useRelatorioProduto'
import type { RelatorioProdutoDTO } from '../interfaces/RelatorioProdutoDTO'
import './RelatorioPage.css'

const RelatorioPage = () => {
  const { data, isLoading, error } = useRelatorioProduto();

  if (isLoading) return <div className="relatorio-loading">Carregando relatório...</div>;
  if (error) return <div className="relatorio-erro">Erro ao carregar relatório</div>;

  const relatorio = data as RelatorioProdutoDTO;

  return (
    <div className="relatorio-container">
      <h2 className="relatorio-titulo">Relatório de Produtos</h2>
      {relatorio?.produtos?.length === 0 && <div className="relatorio-vazio">Nenhum produto encontrado.</div>}
      <div className="relatorio-lista">
        {relatorio?.produtos?.map((produto, idx) => (
          <div key={idx} className="relatorio-card">
            <h3 className="relatorio-produto-nome">{produto.nome}</h3>
            <p className="relatorio-produto-desc"><b>Descrição:</b> {produto.descricao}</p>
            <b>Ingredientes:</b>
            {produto.ingredientes.length === 0 ? (
              <div className="relatorio-sem-ingrediente">Nenhum ingrediente cadastrado.</div>
            ) : (
              <ul className="relatorio-ingredientes">
                {produto.ingredientes.map((ing, i) => (
                  <li key={i} className="relatorio-ingrediente-item">
                    <span className="relatorio-ingrediente-nome">{ing.insumo}</span>: {ing.quantidade} {ing.unidadeMedida}
                  </li>
                ))}
              </ul>
            )}
          </div>
        ))}
      </div>
    </div>
  )
}

export default RelatorioPage