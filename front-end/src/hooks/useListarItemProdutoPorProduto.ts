import type Produto from '../interfaces/Produto';

export interface ItemProdutoEstoque {
  id: number;
  produto: Produto;
  quantidade: number;
  preco: number;
}

export default async function useListarItemProdutoPorProduto(idProduto: number): Promise<ItemProdutoEstoque[]> {
  const response = await fetch(`http://localhost:8080/item-produto?produtoId=${idProduto}`);
  if (!response.ok) throw new Error('Erro ao buscar estoque do produto');
  return response.json();
}
