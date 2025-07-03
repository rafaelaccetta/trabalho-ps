import type Produto from '../interfaces/Produto'

export default async function useCadastrarProduto(produto: Produto) {
  const response = await fetch('http://localhost:8080/produtos', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(produto),
  });
  if (!response.ok) {
    throw new Error('Erro ao cadastrar produto');
  }
  return response.json();
}