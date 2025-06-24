import type Usuario from '../interfaces/Usuario'

export default async function useCadastrarUsuario(usuario: Usuario) {
  const response = await fetch('http://localhost:8080/api/usuarios', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(usuario),
  });
  if (!response.ok) {
    throw new Error('Erro ao cadastrar usuário');
  }
  return response.json();
}