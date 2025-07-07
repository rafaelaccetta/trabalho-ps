export default async function useEstoqueEPreco(idProduto: number): Promise<{ quantidade: number; preco: number }> {
  const res = await fetch(`http://localhost:8080/item-produto?produtoId=${idProduto}`);
  if (!res.ok) throw new Error('Erro ao buscar estoque e preço do produto');

  const data = await res.json();

  let totalQuantidade = 0;
  let menorPreco = Number.MAX_VALUE;

  for (const item of data) {
    totalQuantidade += item.quantidade || 0;
    if (item.preco < menorPreco) {
      menorPreco = item.preco;
    }
  }

  return {
    quantidade: totalQuantidade,
    preco: isFinite(menorPreco) ? menorPreco : 0
  };
}
