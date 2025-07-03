import { useQuery } from '@tanstack/react-query';

export function useRelatorioProduto() {
  return useQuery({
    queryKey: ['relatorio-produto'],
    queryFn: async () => {
      const res = await fetch('http://localhost:8080/api/relatorio/produtos', {
        method: 'GET',
        
      });
      console.log('Status:', res.status);
      const text = await res.text();
      console.log('Resposta:', text);
      if (!res.ok) throw new Error('Erro ao buscar relatório de produtos');
      return JSON.parse(text);
    }
  });
}
