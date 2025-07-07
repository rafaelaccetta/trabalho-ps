import React, { useState, useEffect } from 'react'
import { useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom'
import type Produto from '../interfaces/Produto'
import useCadastrarProduto from '../hooks/useCadastrarProduto'
import useListarInsumos from '../hooks/useListarInsumos'
import useCadastrarIngrediente from '../hooks/useCadastrarIngrediente'
import type Ingrediente from '../interfaces/Ingrediente'
import type Insumo from '../interfaces/Insumo'

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

type ProdutoForm = {
    nome: string
    descricao: string
}

const CadastroProdutoPage = () => {
    const { register, handleSubmit, reset } = useForm<ProdutoForm>()
    const [mensagem, setMensagem] = useState<string | null>(null)
    const [insumos, setInsumos] = useState<Insumo[]>([])
    const [ingredientes, setIngredientes] = useState<Ingrediente[]>([])
    const [loadingInsumos, setLoadingInsumos] = useState(true)
    const navigate = useNavigate()

    useEffect(() => {
        async function fetchInsumos() {
            try {
                const lista = await useListarInsumos()
                setInsumos(lista)
            } catch (e) {
                setMensagem('Erro ao buscar insumos')
            } finally {
                setLoadingInsumos(false)
            }
        }
        fetchInsumos()
    }, [])

    const adicionarIngrediente = () => {
        setIngredientes([
            ...ingredientes,
            {
                idProduto: 0,
                idInsumo: 0,
                quantidade: 1,
                unidadeMedida: ''
            }
        ])
    }

    const handleIngredienteChange = (idx: number, field: keyof Ingrediente, value: any) => {
        const novos = [...ingredientes]
        if (field === 'idInsumo') {
            novos[idx].idInsumo = Number(value)
        } else if (field === 'quantidade') {
            novos[idx].quantidade = Number(value)
        } else if (field === 'unidadeMedida') {
            novos[idx].unidadeMedida = value
        }
        setIngredientes(novos)
    }

    const cadastrarProduto = async (data: ProdutoForm) => {
        setMensagem(null)
        const novoProduto: Produto = {
            nome: data.nome,
            descricao: data.descricao
        }
        try {
            const produtoSalvo = await useCadastrarProduto(novoProduto)
            for (const ingrediente of ingredientes) {
                await useCadastrarIngrediente({
                    ...ingrediente,
                    idProduto: produtoSalvo.id,
                    unidadeMedida: ingrediente.unidadeMedida
                })
            }
            setMensagem('Produto cadastrado com sucesso!')
            reset()
            setIngredientes([])
            setTimeout(() => {
                setMensagem(null)
                navigate('/cadastro')
            }, 1500)
        } catch (error: any) {
            setMensagem('Erro ao cadastrar produto ou ingredientes')
            setTimeout(() => setMensagem(null), 3000)
        }
    }

    return (
        <div style={cardStyle}>
            <h4 style={titleStyle}>Insira os dados do produto</h4>
            <form style={{ width: '100%' }} onSubmit={handleSubmit(cadastrarProduto)}>
                <input
                    style={inputStyle}
                    {...register('nome')}
                    placeholder="Nome do produto"
                    required
                />
                <textarea
                    style={{ ...inputStyle, minHeight: 80 }}
                    {...register('descricao')}
                    placeholder="Descrição"
                    required
                />
                <h5>Ingredientes</h5>
                {ingredientes.map((ingrediente, idx) => (
                    <div key={idx} style={{ marginBottom: 12, border: '1px solid #eee', padding: 8, borderRadius: 6 }}>
                        <select
                            style={inputStyle}
                            value={ingrediente.idInsumo}
                            onChange={e => handleIngredienteChange(idx, 'idInsumo', e.target.value)}
                            required
                        >
                            <option value="">Selecione o insumo</option>
                            {[...insumos]
                                .sort((a, b) => a.nome.localeCompare(b.nome))
                                .map((insumo, i) => (
                                    <option key={i} value={insumo.id}>{insumo.nome}</option>
                                ))}
                        </select>
                        <input
                            style={inputStyle}
                            type="number"
                            min={1}
                            value={ingrediente.quantidade}
                            onChange={e => handleIngredienteChange(idx, 'quantidade', e.target.value)}
                            placeholder="Quantidade"
                            required
                        />
                        <select
                            style={inputStyle}
                            value={ingrediente.unidadeMedida}
                            onChange={e => handleIngredienteChange(idx, 'unidadeMedida', e.target.value)}
                            required
                        >
                            <option value="">Unidade de medida</option>
                            <option value="mg">mg</option>
                            <option value="g">g</option>
                            <option value="kg">kg</option>
                            <option value="ml">ml</option>
                            <option value="l">l</option>
                            <option value="un">un</option>
                        </select>
                    </div>
                ))}
                <button type="button" style={{ ...buttonStyle, background: '#43a047', marginBottom: 12 }} onClick={adicionarIngrediente}>
                    Adicionar Ingrediente
                </button>
                <button style={buttonStyle} type="submit">
                    Cadastrar
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

export default CadastroProdutoPage