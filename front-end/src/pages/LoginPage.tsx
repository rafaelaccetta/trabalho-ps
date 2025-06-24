import React from 'react'
import { useForm } from 'react-hook-form'

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

type LoginForm = {
    email: string
    senha: string
}

const fazerLogin = (data: LoginForm) => {
    console.log('Login:', data)
    // Aqui você pode chamar sua função de autenticação
}

const LoginPage = () => {
    const { register, handleSubmit } = useForm<LoginForm>()

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
        </div>
    )
}

export default LoginPage
