import React, { useState } from 'react'
import { useForm } from 'react-hook-form'
import { useNavigate } from 'react-router-dom'
import './LoginPage.css'

type LoginForm = {
    email: string
    senha: string
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
                localStorage.setItem('token', result.token)
                localStorage.setItem('email', result.email)
                setMensagem('Login realizado com sucesso!')
                setTimeout(() => {
                  if (result.email === 'admin@admin.com') {
                    navigate('/home')
                  } else {
                    navigate('/homeuser')
                  }
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
        <div className="login-card">
            <h4 className="login-title">Login</h4>
            <form style={{ width: '100%' }} onSubmit={handleSubmit(fazerLogin)}>
                <input
                    className="login-input"
                    type="email"
                    {...register('email')}
                    placeholder="Email"
                    required
                />
                <input
                    className="login-input"
                    type="password"
                    {...register('senha')}
                    placeholder="Senha"
                    required
                />
                <button className="login-btn" type="submit">
                    Entrar
                </button>
            </form>
            <button
                className="login-btn-cadastro"
                type="button"
                onClick={() => navigate('/cadastro/usuario')}
            >
                Criar nova conta
            </button>
            {mensagem && (
                <div className={`login-msg ${mensagem.includes('sucesso') ? 'sucesso' : 'erro'}`}>
                    {mensagem}
                </div>
            )}
        </div>
    )
}

export default LoginPage
