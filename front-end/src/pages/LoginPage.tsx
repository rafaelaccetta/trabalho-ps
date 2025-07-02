import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom'

type LoginForm = {
    email: string
    senha: string
}

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

const LoginPage = () => {
    const { register, handleSubmit } = useForm<LoginForm>()
    const [mensagem, setMensagem] = useState<string | null>(null)
    const navigate = useNavigate()

    const fazerLogin = async (data: LoginForm) => {
        setMensagem(null)
        try {
            const response = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(data),
            })
            if (response.ok) {
                const result = await response.json()
                // Salva qualquer valor como token para liberar o acesso
                localStorage.setItem('token', result.email || 'token')
                setMensagem('Login realizado com sucesso!')
                setTimeout(() => {
                  navigate('/')
                }, 800)
            } else {
                const erro = await response.text()
                setMensagem(erro)
            }
        } catch {
            setMensagem('Erro ao conectar com o servidor')
        }
    }

    return (
        <div style={cardStyle}>
            <h4 style={titleStyle}>Login</h4>
            <form style={{ width: '100%' }} onSubmit={handleSubmit(fazerLogin)}>
                <input
                    style={inputStyle}
                    type="email"
                    {...register('email')}
                    placeholder="Email"
                    required
                />
                <input
                    style={inputStyle}
                    type="password"
                    {...register('senha')}
                    placeholder="Senha"
                    required
                />
                <button style={buttonStyle} type="submit">
                    Entrar
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

export default LoginPage
