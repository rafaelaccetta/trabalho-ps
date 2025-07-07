import React, { useState, useEffect } from 'react'
import { useForm } from 'react-hook-form'
import type Encomenda from '../interfaces/Encomenda'
import type TokenResponse from '../interfaces/TokenResponse'
import useEncomendarProduto from '../hooks/useEncomendarProduto'
import useListarProdutos from '../hooks/useListarProdutos'
import type Produto from '../interfaces/Produto'


const cardStyle: React.CSSProperties = {
    maxWidth: 400,
    margin: '40px auto',
    padding: '32px 24px',
    borderRadius: 12,
    boxShadow: '0 4px 24px rgba(0,0,0,0.12)',
    background: '#fff',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
}

const titleStyle: React.CSSProperties = {
    marginBottom: 24,
    fontWeight: 600,
    fontSize: 24,
    color: '#333',
    letterSpacing: 1,
}

const inputStyle: React.CSSProperties = {
    width: '100%',
    padding: '8px 12px',
    marginBottom: 16,
    borderRadius: 6,
    border: '1px solid #ccc',
    fontSize: 16,
}

const buttonStyle: React.CSSProperties = {
    width: '100%',
    padding: '10px 0',
    borderRadius: 6,
    border: 'none',
    background: '#1976d2',
    color: '#fff',
    fontWeight: 600,
    fontSize: 16,
    cursor: 'pointer',
    marginTop: 8,
}

type EncomendaForm = {
    idProduto: number,
    quantidade: number
}

const EncomendaForm = () => {
    const { register, handleSubmit, reset } = useForm<EncomendaForm>()
    const [mensagem, setMensagem] = useState<string | null>(null)
    const [produtos, setProdutos] = useState<Produto[]>([])
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        async function fetchProdutos() {
            try {
                const lista = await useListarProdutos()
                setProdutos(lista)
            } catch (e) {
                setMensagem('Erro ao buscar produtos')
            } finally {
                setLoading(false)
            }
        }
        fetchProdutos()
    }, [])

    function getUserIdFromStorage() {
        return localStorage.getItem('id')
    }

    const encomendarProduto = async (data: EncomendaForm) => {
        setMensagem(null)
        const idCliente = getUserIdFromStorage()
        if (!idCliente) {
            setMensagem('Usuário não autenticado')
            return
        }
        const encomenda: Encomenda = {
            idCliente: Number(idCliente),
            idProduto: data.idProduto,
            quantidade: data.quantidade
        }
        try {
            const TokenResponse : TokenResponse = await useEncomendarProduto(encomenda)
            if(TokenResponse.token === 1){
              setMensagem('Encomenda realizada com sucesso!');
            } else if (TokenResponse.token === 0) {
              setMensagem('A encomenda não pode ser realizada porque não há insumos suficientes :(')
            } else {
              setMensagem('A encomenda não pode ser realizada porque o produto não foi encontrado :(')
            }
            reset()
            setTimeout(() => setMensagem(null), 3000) 
        } catch (error: any) {
            setMensagem('Erro ao encomendar produto :(')
            setTimeout(() => setMensagem(null), 3000)
        }
    }

    return (
        <div style={cardStyle}>
            <h4 style={titleStyle}>Encomendar Produto</h4>
            <form style={{ width: '100%' }} onSubmit={handleSubmit(encomendarProduto)}>
                {loading ? (
                    <div>Carregando produtos...</div>
                ) : (
                    <select style={inputStyle} {...register('idProduto', { valueAsNumber: true })} required>
                        <option value="">Selecione um produto</option>
                        {produtos.map((produto, idx) => (
                            <option key={idx} value={produto.id}>{produto.nome}</option>
                        ))}
                    </select>
                )}
                <input
                    style={inputStyle}
                    type='number'
                    {...register('quantidade', { valueAsNumber: true })}
                    placeholder="quantidade"
                    required
                />
                <button style={buttonStyle} type="submit">
                    Encomendar
                </button>
            </form>
            {mensagem && (
                <div style={{
                    marginTop: 16,
                    padding: 12,
                    borderRadius: 6,
                    background: mensagem.includes('sucesso') ? '#d4edda' : '#f8d7da',
                    color: mensagem.includes('sucesso') ? '#155724' : '#721c24',
                    border: mensagem.includes('sucesso') ? '1px solid #c3e6cb' : '1px solid #f5c6cb'
                }}>
                    {mensagem}
                </div>
            )}
        </div>
    )
}


export default EncomendaForm;