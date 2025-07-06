import React, { useEffect, useState } from 'react';
import type Produto from '../interfaces/Produto';
import { useCarrinho } from '../context/CartContext';
import { useNavigate } from 'react-router-dom';
import useEstoqueProduto from '../hooks/useEstoqueProduto';

const CatalogoPage = () => {
  const [produtos, setProdutos] = useState<Produto[]>([]);
  const { adicionarAoCarrinho } = useCarrinho();
  const navigate = useNavigate();
  const [estoques, setEstoques] = useState<{ [id: number]: number }>({});

  useEffect(() => {
    fetch('http://localhost:8080/produtos')
      .then(res => res.json())
      .then(async (produtos: Produto[]) => {
        setProdutos(produtos);
        // Busca o estoque de cada produto
        const estoquesObj: { [id: number]: number } = {};
        for (const p of produtos) {
          if (p.id) {
            try {
              const estoque = await useEstoqueProduto(p.id);
              estoquesObj[p.id] = estoque;
            } catch {
              estoquesObj[p.id] = 0;
            }
          }
        }
        setEstoques(estoquesObj);
      });
  }, []);

  const handleAdicionar = (produto: Produto) => {
    adicionarAoCarrinho(produto);
    navigate('/carrinho');
  };

  return (
    <div style={{ maxWidth: 900, margin: '40px auto' }}>
      <h2>Catálogo de Produtos</h2>
      <div style={{ display: 'flex', flexWrap: 'wrap', gap: 24 }}>
        {produtos.map(produto => (
          <div key={produto.id} style={{ border: '1px solid #ccc', borderRadius: 12, padding: 20, width: 240, background: '#fafdff', boxShadow: '0 2px 8px #e3f0fc' }}>
            <h4 style={{ margin: '8px 0 4px 0', color: '#1976d2' }}>{produto.nome}</h4>
            <p style={{ minHeight: 48, color: '#444', fontSize: 15 }}>{produto.descricao}</p>
            <div style={{ fontSize: 14, color: estoques[produto.id!] > 0 ? '#388e3c' : '#b71c1c', marginBottom: 8 }}>
              {estoques[produto.id!] > 0 ? `Disponível: ${estoques[produto.id!]}` : 'Indisponível'}
            </div>
            <button
              onClick={() => handleAdicionar(produto)}
              disabled={estoques[produto.id!] === 0}
              style={{
                marginTop: 8,
                background: estoques[produto.id!] > 0 ? 'linear-gradient(90deg,#1976d2 60%,#43a047 100%)' : '#ccc',
                color: '#fff',
                border: 'none',
                borderRadius: 6,
                padding: '10px 18px',
                fontWeight: 600,
                fontSize: 16,
                cursor: estoques[produto.id!] > 0 ? 'pointer' : 'not-allowed',
                boxShadow: estoques[produto.id!] > 0 ? '0 2px 8px #e3f0fc' : 'none',
                transition: 'background 0.2s',
              }}
            >
              {estoques[produto.id!] > 0 ? 'Adicionar ao Carrinho' : 'Indisponível'}
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CatalogoPage;
