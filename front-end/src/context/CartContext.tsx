import React, { createContext, useContext, useState } from 'react';
import type Produto from '../interfaces/Produto';

export interface ItemCarrinho {
  produto: Produto;
  quantidade: number;
}

interface CarrinhoContextType {
  itens: ItemCarrinho[];
  adicionarAoCarrinho: (produto: Produto) => void;
  removerDoCarrinho: (produtoId: number) => void;
  atualizarQuantidade: (produtoId: number, quantidade: number) => void;
  limparCarrinho: () => void;
}

const CarrinhoContext = createContext<CarrinhoContextType | undefined>(undefined);

export const CarrinhoProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
  const [itens, setItens] = useState<ItemCarrinho[]>([]);

  const adicionarAoCarrinho = (produto: Produto) => {
    setItens(prev => {
      const encontrado = prev.find(item => item.produto.id === produto.id);
      if (encontrado) {
        return prev.map(item => item.produto.id === produto.id ? {...item, quantidade: item.quantidade + 1} : item);
      }
      return [...prev, { produto, quantidade: 1 }];
    });
  };

  const removerDoCarrinho = (produtoId: number) => {
    setItens(prev => prev.filter(item => item.produto.id !== produtoId));
  };

  const atualizarQuantidade = (produtoId: number, quantidade: number) => {
    setItens(prev => prev.map(item => item.produto.id === produtoId ? {...item, quantidade} : item));
  };

  const limparCarrinho = () => setItens([]);

  return (
    <CarrinhoContext.Provider value={{ itens, adicionarAoCarrinho, removerDoCarrinho, atualizarQuantidade, limparCarrinho }}>
      {children}
    </CarrinhoContext.Provider>
  );
};

export function useCarrinho() {
  const ctx = useContext(CarrinhoContext);
  if (!ctx) throw new Error('useCarrinho deve ser usado dentro de um CarrinhoProvider');
  return ctx;
}
