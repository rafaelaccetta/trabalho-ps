import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import type Encomenda from '../interfaces/Encomenda'
import type TokenResponse from '../interfaces/TokenResponse'
import useEncomendarProduto from '../hooks/useEncomendarProduto'


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
    idCliente: number,
    idProduto: number,
    quantidade: number
}

const EncomendaForm = () => {
    const { register, handleSubmit, reset } = useForm<EncomendaForm>()
    const [mensagem, setMensagem] = useState<string | null>(null)

    const encomendarProduto = async (data: EncomendaForm) => {
        setMensagem(null)
        const encomenda: Encomenda = {
            idCliente: data.idCliente,
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
            setMensagem('Encomenda realizada com sucesso!')
            reset()
            setTimeout(() => setMensagem(null), 3000) 
        } catch (error: any) {
            setMensagem('Erro ao cadastrar usuário')
            setTimeout(() => setMensagem(null), 3000)
        }
    }

    return (
        <div style={cardStyle}>
            <h4 style={titleStyle}>Insira seus dados</h4>
            <form style={{ width: '100%' }} onSubmit={handleSubmit(encomendarProduto)}>
                <input
                    style={inputStyle}
                    type='number'
                    {...register('idCliente')}
                    placeholder="id do cliente"
                    required
                />
                <input
                    style={inputStyle}
                    type='number'
                    {...register('idProduto')}
                    placeholder="id do produto"
                    required
                /><input
                    style={inputStyle}
                    type='number'
                    {...register('quantidade')}
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