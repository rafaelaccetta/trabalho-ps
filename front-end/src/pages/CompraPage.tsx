import React, { useEffect, useState } from "react";
import type Produto from "../interfaces/Produto";
import useListarProdutos from "../hooks/useListarProdutos";
import "../pages/CompraPage.css";

const CompraPage: React.FC = () => {
  const [produtos, setProdutos] = useState<Produto[]>([]);
  const [loading, setLoading] = useState(true);
  const [erro, setErro] = useState("");
  const [mensagem, setMensagem] = useState("");
  const [quantidade, setQuantidade] = useState<{ [id: string]: number }>({});

  useEffect(() => {
    useListarProdutos()
      .then((data) => setProdutos(data))
      .catch(() => setErro("Erro ao buscar produtos"))
      .finally(() => setLoading(false));
  }, []);

  const comprar = async (produto: Produto) => {
    setMensagem("");
    setErro("");
    if (!produto.id) {
      setErro("Produto inválido");
      return;
    }
    const qtd = quantidade[String(produto.id)] || 1;
    try {
      const res = await fetch(`http://localhost:8080/api/encomenda`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ idProduto: produto.id, quantidade: qtd }),
      });
      if (!res.ok) throw new Error("Erro ao comprar produto");
      setMensagem("Compra realizada com sucesso!");
    } catch {
      setErro("Erro ao comprar produto");
    }
  };

  if (loading) return <div>Carregando produtos...</div>;
  if (erro) return <div className="login-msg erro">{erro}</div>;

  return (
    <div className="compra-bg" style={{ maxWidth: 900, margin: "0 auto" }}>
      <h2>Comprar Produto</h2>
      {mensagem && (
        <div className={`login-msg ${mensagem.includes('sucesso') ? 'sucesso' : 'erro'}`}>{mensagem}</div>
      )}
      <div className="compra-cards-container">
        {produtos.map((produto) => (
          <div className="compra-card" key={produto.id}>
            <strong>{produto.nome}</strong>
            <div>
              <input
                type="number"
                min={1}
                value={quantidade[String(produto.id)] || 1}
                onChange={e => setQuantidade({ ...quantidade, [String(produto.id)]: Number(e.target.value) })}
                style={{ width: 60, marginRight: 8 }}
              />
              <button onClick={() => comprar(produto)}>Comprar</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CompraPage;
