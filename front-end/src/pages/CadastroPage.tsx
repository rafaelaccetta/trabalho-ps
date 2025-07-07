import React from 'react'
import { useNavigate, Outlet, useLocation } from 'react-router-dom'
import MenuSuperior from '../components/MenuSuperior'

const cardStyle: React.CSSProperties = {
  maxWidth: 400,
  margin: '120px auto 40px',
  padding: '32px 24px',
  borderRadius: 12,
  boxShadow: '0 4px 24px rgba(0,0,0,0.12)',
  background: '#fff',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
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
  marginTop: 16,
}

const CadastroPage = () => {
  const navigate = useNavigate()
  const location = useLocation()
  const isRootCadastro = location.pathname === '/cadastro'

  return (
    <>
      <MenuSuperior />
      <div style={isRootCadastro ? cardStyle : { marginTop: '80px' }}>
        {isRootCadastro ? (
          <>
            <h4 style={{ marginBottom: 24, fontWeight: 600, fontSize: 24, color: '#333' }}>
              Escolha o que deseja cadastrar:
            </h4>
            <button style={buttonStyle} onClick={() => navigate('/cadastro/produto')}>
              Cadastrar Produto
            </button>
            <button
              style={{ ...buttonStyle, background: '#43a047' }}
              onClick={() => navigate('/cadastro/insumo')}
            >
              Cadastrar Insumo
            </button>
          </>
        ) : (
          <Outlet />
        )}
      </div>
    </>
  )
}

export default CadastroPage
