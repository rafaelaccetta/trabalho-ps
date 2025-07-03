export interface IngredienteDTO {
  insumo: string;
  quantidade: number;
  unidadeMedida: string;
}

export interface ProdutoDTO {
  nome: string;
  descricao: string;
  ingredientes: IngredienteDTO[];
}

export interface RelatorioProdutoDTO {
  produtos: ProdutoDTO[];
}
