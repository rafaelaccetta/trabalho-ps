import React from 'react';
import { useRelatorioVendas } from '../hooks/useRelatorioVendas';
import './RelatorioPage.css';
import type { RelatorioVendasDTO } from '../interfaces/RelatorioVendasDTO';

const RelatorioVendasPage = () => {
  const { data, isLoading, error } = useRelatorioVendas();

  if (isLoading) return <div className="relatorio-loading">Carregando relatório...</div>;
  if (error) return <div className="relatorio-erro">Erro ao carregar relatório</div>;

  const relatorio = data as RelatorioVendasDTO;

  return (
    <div className="relatorio-container">
      <h2 className="relatorio-titulo">Relatório de Vendas</h2>

      <p><b>Total vendido:</b> R$ {relatorio.totalVendido}</p>
      <p><b>Total de itens vendidos:</b> {relatorio.totalItensVendidos}</p>
      <p><b>Produto mais vendido:</b> {relatorio.produtoMaisVendido} ({relatorio.quantidadeMaisVendida})</p>

      <div className="relatorio-lista">
        {relatorio.vendas.map((venda, idx) => (
          <div key={idx} className="relatorio-card">
            <h3 className="relatorio-produto-nome">Venda #{venda.id}</h3>
            <p><b>Cliente:</b> {venda.cliente}</p>
            <p><b>Data:</b> {venda.data}</p>
            <p><b>Total:</b> R$ {venda.valorTotal}</p>

            <b>Itens:</b>
            <ul className="relatorio-ingredientes">
              {venda.itens.map((item, i) => (
                <li key={i} className="relatorio-ingrediente-item">
                  {item.produto}: {item.quantidade}
                </li>
              ))}
            </ul>
          </div>
        ))}
      </div>
    </div>
  );
};

export default RelatorioVendasPage;
