import type Ingrediente from '../interfaces/Ingrediente'

export default async function useCadastrarIngrediente(ingrediente: Ingrediente) {
  const response = await fetch('http://localhost:8080/ingredientes', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(ingrediente),
  });
  if (!response.ok) {
    throw new Error('Erro ao cadastrar ingrediente');
  }
  return response.json();
}
