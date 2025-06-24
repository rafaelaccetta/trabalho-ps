import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import type Usuario from '../interfaces/Usuario'
import useCadastrarUsuario from '../hooks/useCadastrarUsuario'

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

type UsuarioForm = {
    nome: string
    email: string
    endereco: string
    dataNascimento: string
    senha: string  
    telefone: string
}

const CadastroUsuarioPage = () => {
    const { register, handleSubmit, reset } = useForm<UsuarioForm>()
    const [mensagem, setMensagem] = useState<string | null>(null)

    const cadastrarUsuario = async (data: UsuarioForm) => {
        setMensagem(null)
        const novoUsuario: Usuario = {
            nome: data.nome,
            email: data.email,
            endereco: data.endereco,
            dataNascimento: data.dataNascimento,
            senha: data.senha,
            telefone: data.telefone
        }
        try {
            await useCadastrarUsuario(novoUsuario)
            setMensagem('Usuário cadastrado com sucesso!')
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
            <form style={{ width: '100%' }} onSubmit={handleSubmit(cadastrarUsuario)}>
                <input
                    style={inputStyle}
                    {...register('nome')}
                    placeholder="Nome"
                    required
                />
                <input
                    style={inputStyle}
                    type="email"
                    {...register('email')}
                    placeholder="Email"
                    required
                />
                <input
                    style={inputStyle}
                    {...register('endereco')}
                    placeholder="Endereço"
                    required
                />
                <input
                    style={inputStyle}
                    type="date"
                    {...register('dataNascimento')}
                    placeholder="Data de Nascimento"
                    required
                />
                <input
                    style={inputStyle}
                    type="password"
                    {...register('senha')}
                    placeholder="Senha"
                    required
                />
                <input
                    style={inputStyle}
                    type="tel"
                    {...register('telefone')}
                    placeholder="Telefone"
                    required
                />
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

export default CadastroUsuarioPage
