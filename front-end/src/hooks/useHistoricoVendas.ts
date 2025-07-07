import { useQuery } from '@tanstack/react-query';

export interface ItemHistorico {
  nomeProduto: string;
  quantidade: number;
  preco: number;
}

export interface HistoricoVenda {
  id: number;
  estado: string;
  total: number;
  data: string;
  itens: ItemHistorico[];
}

export function useHistoricoVendas(id: number | undefined) {
  const isValidId = typeof id === 'number' && !isNaN(id) && id > 0;

  return useQuery<HistoricoVenda[]>({
    queryKey: ['historico-vendas', id],
    queryFn: async () => {
      const res = await fetch(`http://localhost:8080/vendas/historico?id=${id}`);
      if (!res.ok) throw new Error('Erro ao buscar histórico de compras');
      return res.json();
    },
    enabled: isValidId,
    staleTime: 1000 * 60,
  });
}

