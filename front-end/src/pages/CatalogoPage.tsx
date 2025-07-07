import React, { useEffect, useState } from 'react';
import type Produto from '../interfaces/Produto';
import { useCarrinho } from '../context/CartContext';
import { useNavigate } from 'react-router-dom';
import useEstoqueProduto from '../hooks/useEstoqueProduto';
import useEstoqueEPreco from '../hooks/useEstoqueEPreco';
import MenuSuperior from '../components/MenuSuperior';

type EstoqueEP = {
  quantidade: number;
  preco: number;
};

const CatalogoPage = () => {
  const [produtos, setProdutos] = useState<Produto[]>([]);
  const { adicionarAoCarrinho } = useCarrinho();
  const navigate = useNavigate();

  const [estoques, setEstoques] = useState<{ [id: number]: number }>({});

  const [estoquesEP, setEstoquesEP] = useState<{ [id: number]: EstoqueEP }>({});

  const [ordenarPor, setOrdenarPor] = useState<'quantidade' | 'alfabetica' | 'maisBarato' | 'maisCaro'>('alfabetica');

  useEffect(() => {
    fetch('http://localhost:8080/produtos')
      .then(res => res.json())
      .then(async (produtos: Produto[]) => {
        setProdutos(produtos);

        const estoquesObj: { [id: number]: number } = {};
        const estoquesEPObj: { [id: number]: EstoqueEP } = {};

        for (const p of produtos) {
          if (p.id) {
            try {
              const estoque = await useEstoqueProduto(p.id);
              estoquesObj[p.id] = estoque;
            } catch {
              estoquesObj[p.id] = 0;
            }
            try {
              const ep = await useEstoqueEPreco(p.id);
              estoquesEPObj[p.id] = ep;
            } catch {
              estoquesEPObj[p.id] = { quantidade: 0, preco: 0 };
            }
          }
        }

        setEstoques(estoquesObj);
        setEstoquesEP(estoquesEPObj);
      });
  }, []);

  const handleAdicionar = (produto: Produto) => {
    adicionarAoCarrinho(produto);
    navigate('/carrinho');
  };

  const ordenarProdutos = (a: Produto, b: Produto) => {
    const estoqueA = estoques[a.id!] || 0;
    const estoqueB = estoques[b.id!] || 0;
    const epA = estoquesEP[a.id!] || { quantidade: 0, preco: 0 };
    const epB = estoquesEP[b.id!] || { quantidade: 0, preco: 0 };

    switch (ordenarPor) {
      case 'quantidade':
        return estoqueB - estoqueA;
      case 'alfabetica':
        return a.nome.localeCompare(b.nome);
      case 'maisBarato':
        return epA.preco - epB.preco;
      case 'maisCaro':
        return epB.preco - epA.preco;
      default:
        return 0;
    }
  };

  return (
    <div
      style={{
        padding: '80px 16px 16px',
        boxSizing: 'border-box',
        width: '100%',
        minHeight: '100vh',
        overflowY: 'auto',
        overflowX: 'hidden',
      }}
    >
      <MenuSuperior />

      <h2 style={{ textAlign: 'center', color: '#1976d2' }}>
        Catálogo de Produtos
      </h2>

      <div style={{ textAlign: 'center', marginBottom: 16 }}>
        <label htmlFor="ordenarPor" style={{ marginRight: 8, fontWeight: 'bold' }}>
          Ordenar por:
        </label>
        <select
          id="ordenarPor"
          value={ordenarPor}
          onChange={e => setOrdenarPor(e.target.value as any)}
          style={{ padding: 6, fontSize: 16 }}
        >
          <option value="alfabetica">Ordem Alfabética</option>
          <option value="quantidade">Quantidade</option>
          <option value="maisBarato">Mais Barato</option>
          <option value="maisCaro">Mais Caro</option>
        </select>
      </div>

      <div
        style={{
          display: 'flex',
          flexWrap: 'wrap',
          justifyContent: 'center',
          gap: 24,
          marginTop: 24,
        }}
      >
        {(() => {
          const disponiveis = produtos.filter(p => (estoques[p.id!] || 0) > 0);
          const indisponiveis = produtos.filter(p => (estoques[p.id!] || 0) === 0);

          const ordenadosDisponiveis = disponiveis.sort(ordenarProdutos);

          return [...ordenadosDisponiveis, ...indisponiveis].map(produto => {
            const estoque = estoques[produto.id!] || 0;
            const ep = estoquesEP[produto.id!] || { quantidade: 0, preco: 0 };
            const disponivel = estoque > 0;

            return (
              <div
                key={produto.id}
                style={{
                  border: '1px solid #ccc',
                  borderRadius: 12,
                  padding: 20,
                  width: 240,
                  background: '#fafdff',
                  boxSizing: 'border-box',
                  boxShadow: '0 2px 8px #e3f0fc',
                }}
              >
                <h4 style={{ margin: '8px 0 4px 0', color: '#1976d2' }}>{produto.nome}</h4>
                <p style={{ minHeight: 48, color: '#444', fontSize: 15 }}>{produto.descricao}</p>
                <div
                  style={{
                    fontSize: 14,
                    color: disponivel ? '#388e3c' : '#b71c1c',
                    marginBottom: 4,
                  }}
                >
                  {disponivel ? `Disponível: ${estoque}` : 'Indisponível'}
                </div>
                <div style={{ fontWeight: 'bold', marginBottom: 8 }}>
                  Preço: R$ {ep.preco.toFixed(2).replace('.', ',')}
                </div>
                <button
                  onClick={() => handleAdicionar(produto)}
                  disabled={!disponivel}
                  style={{
                    marginTop: 8,
                    background: disponivel
                      ? 'linear-gradient(90deg,#1976d2 60%,#43a047 100%)'
                      : '#ccc',
                    color: '#fff',
                    border: 'none',
                    borderRadius: 6,
                    padding: '10px 18px',
                    fontWeight: 600,
                    fontSize: 16,
                    cursor: disponivel ? 'pointer' : 'not-allowed',
                    boxShadow: disponivel ? '0 2px 8px #e3f0fc' : 'none',
                    transition: 'background 0.2s',
                  }}
                >
                  {disponivel ? 'Adicionar ao Carrinho' : 'Indisponível'}
                </button>
              </div>
            );
          });
        })()}

      </div>
    </div>
  );
};

export default CatalogoPage;
