import React, { useMemo } from 'react';
import { useHistoricoVendas } from '../hooks/useHistoricoVendas';
import MenuSuperior from '../components/MenuSuperior';

const HistoricoComprasPage = () => {
    const idUsuario = useMemo(() => {
    const raw = localStorage.getItem('id');
    return raw ? Number(raw) : undefined;
    }, []);

  const { data, isLoading, error } = useHistoricoVendas(idUsuario);

  return (
    <div style={{ padding: '80px 24px' }}>
      <MenuSuperior />
      <h2 style={{ textAlign: 'center', color: '#1976d2', marginBottom: 24 }}>
        Histórico de Compras
      </h2>

      {isLoading ? (
        <p>Carregando...</p>
      ) : error ? (
        <p>Erro ao carregar histórico.</p>
      ) : data && data.length === 0 ? (
        <p>Você ainda não realizou nenhuma compra.</p>
      ) : (
        data?.map(venda => (
          <div
            key={venda.id}
            style={{
              border: '1px solid #ccc',
              borderRadius: 8,
              padding: 16,
              marginBottom: 16,
              background: '#f9f9f9',
            }}
          >
            <h4 style={{ marginBottom: 8 }}>Compra #{venda.id}</h4>
            <p><strong>Data:</strong> {new Date(venda.data).toLocaleDateString()}</p>
            <p><strong>Total:</strong> R$ {venda.total?.toFixed(2)}</p>
            <p><strong>Estado:</strong> {venda.estado}</p>
            <ul style={{ marginTop: 12 }}>
              {venda.itens.map((item, i) => (
                <li key={i}>
                  {item.nomeProduto} - {item.quantidade}x R$ {item.preco.toFixed(2)}
                </li>
              ))}
            </ul>
          </div>
        ))
      )}
    </div>
  );
};

export default HistoricoComprasPage;
