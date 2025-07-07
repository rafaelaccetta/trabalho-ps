import type ItemProduto from '../interfaces/ItemProduto';

export default async function useEstoqueProduto(idProduto: number): Promise<number> {
  const response = await fetch(`http://localhost:8080/item-produto?produtoId=${idProduto}`);
  if (!response.ok) throw new Error('Erro ao buscar estoque do produto');
  const lotes: ItemProduto[] = await response.json();
  return lotes.reduce((acc, lote) => acc + lote.quantidade, 0);
}
