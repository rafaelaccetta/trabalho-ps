import type Insumo from '../interfaces/Insumo'

export default async function useCadastrarInsumo(insumo: Insumo) {
  const response = await fetch('http://localhost:8080/insumos', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(insumo),
  });
  if (!response.ok) {
    throw new Error('Erro ao cadastrar insumo');
  }
  return response.json();
}