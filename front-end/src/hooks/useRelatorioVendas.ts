import { useQuery } from '@tanstack/react-query';
import type { RelatorioVendasDTO } from '../interfaces/RelatorioVendasDTO';

export function useRelatorioVendas() {
  return useQuery({
    queryKey: ['relatorio-vendas'],
    queryFn: async () => {
      const res = await fetch('http://localhost:8080/api/relatorio/vendas', {
        method: 'GET',
      });
      console.log('Status:', res.status);
      const text = await res.text();
      console.log('Resposta:', text);
      if (!res.ok) throw new Error('Erro ao buscar relatório de vendas');
      return JSON.parse(text) as RelatorioVendasDTO;
    }
  });
}
