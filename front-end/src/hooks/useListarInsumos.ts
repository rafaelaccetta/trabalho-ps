import type Insumo from '../interfaces/Insumo'

export default async function useListarInsumos() {
  const response = await fetch('http://localhost:8080/insumos', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  });
  if (!response.ok) {
    throw new Error('Erro ao buscar insumos');
  }
  return response.json() as Promise<Insumo[]>;
}
