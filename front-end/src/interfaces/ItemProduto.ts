import Produto from './Produto';

export default interface ItemProduto {
  id: number;
  produto: Produto;
  quantidade: number;
  preco: number;
}
