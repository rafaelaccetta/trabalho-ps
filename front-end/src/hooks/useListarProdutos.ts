import type Produto from '../interfaces/Produto'

export default async function useListarProdutos() {
  const response = await fetch('http://localhost:8080/produtos', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  });
  if (!response.ok) {
    throw new Error('Erro ao buscar produtos');
  }
  return response.json() as Promise<Produto[]>;
}
