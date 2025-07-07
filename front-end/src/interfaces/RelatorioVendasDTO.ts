export interface RelatorioVendasDTO {
  totalVendido: number;
  totalItensVendidos: number;
  produtoMaisVendido: string;
  quantidadeMaisVendida: number;
  vendas: VendaResumo[];
}

export interface VendaResumo {
  id: number;
  data: string;
  cliente: string;
  valorTotal: number;
  itens: ItemResumo[];
}

export interface ItemResumo {
  produto: string;
  quantidade: number;
}
