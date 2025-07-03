import React from 'react'
import { useRelatorioProduto } from '../hooks/useRelatorioProduto'
import type { RelatorioProdutoDTO } from '../interfaces/RelatorioProdutoDTO'

const RelatorioPage = () => {
  const { data, isLoading, error } = useRelatorioProduto();

  if (isLoading) return <div>Carregando relatório...</div>;
  if (error) return <div>Erro ao carregar relatório</div>;

  const relatorio = data as RelatorioProdutoDTO;

  return (
    <div>
      <h2>Relatório de Produtos</h2>
      {relatorio?.produtos?.length === 0 && <div>Nenhum produto encontrado.</div>}
      {relatorio?.produtos?.map((produto, idx) => (
        <div key={idx} style={{border: '1px solid #ccc', borderRadius: 8, margin: '16px 0', padding: 16}}>
          <h3>{produto.nome}</h3>
          <p><b>Descrição:</b> {produto.descricao}</p>
          <b>Ingredientes:</b>
          {produto.ingredientes.length === 0 ? (
            <div style={{marginLeft: 16}}>Nenhum ingrediente cadastrado.</div>
          ) : (
            <ul style={{marginLeft: 16}}>
              {produto.ingredientes.map((ing, i) => (
                <li key={i}>{ing.insumo}: {ing.quantidade} {ing.unidadeMedida}</li>
              ))}
            </ul>
          )}
        </div>
      ))}
    </div>
  )
}

export default RelatorioPage