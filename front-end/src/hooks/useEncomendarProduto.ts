import type Encomenda from "../interfaces/Encomenda";

export default async function useEncomendarProduto(encomenda: Encomenda) {
  const response = await fetch('http://localhost:8080/api/encomenda', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(encomenda),
  });
  if (!response.ok) {
    throw new Error('Erro ao encomendar produto.');
  }
  return response.json();
}