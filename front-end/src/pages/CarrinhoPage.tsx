import React from 'react';
import { useCarrinho } from '../context/CartContext';
import { useNavigate } from 'react-router-dom';
import MenuSuperior from '../components/MenuSuperior';

const CarrinhoPage = () => {
  const { itens, atualizarQuantidade, removerDoCarrinho, limparCarrinho } = useCarrinho();
  const navigate = useNavigate();

  const finalizarCompra = async () => {
    const idUsuario = localStorage.getItem('idUsuario');
    const venda = {
      idUsuario: idUsuario ? Number(idUsuario) : undefined,
      itens: itens.map(item => ({
        idProduto: item.produto.id,
        quantidade: item.quantidade
      }))
    };
    const response = await fetch('http://localhost:8080/vendas', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(venda)
    });
    if (response.ok) {
      limparCarrinho();
      alert('Compra finalizada com sucesso!');
      navigate('/homeuser');
    } else {
      alert('Erro ao finalizar compra.');
    }
  };

  return (
    <div style={{ maxWidth: 600, margin: '40px auto' }}>
      <MenuSuperior />
      <h2 style={{ textAlign: 'center', color: '#1976d2', marginTop: 100 }}>
        Seu Carrinho
      </h2>
      {itens.length === 0 ? (
        <>
          <p>O carrinho está vazio.</p>
          <button
            onClick={() => navigate('/catalogo')}
            style={{
              background: '#1976d2',
              color: '#fff',
              border: 'none',
              borderRadius: 4,
              padding: '10px 24px',
              fontWeight: 600,
              fontSize: 16,
              cursor: 'pointer',
              marginTop: 16,
            }}
          >
            Escolher Produtos
          </button>
        </>
      ) : (
        <>
          <table style={{ width: '100%', marginBottom: 24 }}>
            <thead>
              <tr>
                <th>Produto</th>
                <th>Quantidade</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              {itens.map(item => (
                <tr key={item.produto.id}>
                  <td>{item.produto.nome}</td>
                  <td>
                    <input
                      type="number"
                      min={1}
                      value={item.quantidade}
                      onChange={e => atualizarQuantidade(item.produto.id!, Number(e.target.value))}
                      style={{ width: 60 }}
                    />
                  </td>
                  <td>
                    <button onClick={() => removerDoCarrinho(item.produto.id!)} style={{ color: 'red', border: 'none', background: 'none', cursor: 'pointer' }}>Remover</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <button
            onClick={() => navigate('/catalogo')}
            style={{
              background: '#43a047',
              color: '#fff',
              border: 'none',
              borderRadius: 4,
              padding: '10px 24px',
              fontWeight: 600,
              fontSize: 16,
              cursor: 'pointer',
              marginRight: 12,
            }}
          >
            Continuar Comprando
          </button>
          <button onClick={finalizarCompra} style={{ background: '#1976d2', color: '#fff', border: 'none', borderRadius: 4, padding: '10px 24px', fontWeight: 600, fontSize: 16, cursor: 'pointer' }}>
            Finalizar Compra
          </button>
        </>
      )}
    </div>
  );
};

export default CarrinhoPage;
