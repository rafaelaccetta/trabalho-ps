import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

const MenuSuperior = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const handleLogout = () => {
    localStorage.clear();
    navigate('/login');
  };

  const email = localStorage.getItem('email');
  const isAdmin = email === 'admin@admin.com';

  const btnStyle: React.CSSProperties = {
    background: 'none',
    border: 'none',
    fontSize: 16,
    color: '#1976d2',
    cursor: 'pointer',
    fontWeight: 'bold',
  };

  return (
    <div
      style={{
        position: 'fixed',
        top: 0,
        left: 0,
        width: '100%',
        backgroundColor: '#ffffff',
        padding: '12px 24px',
        boxShadow: '0 2px 4px rgba(0,0,0,0.1)',
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        zIndex: 1000,
      }}
    >
      <div style={{ fontWeight: 600, fontSize: 20, color: '#1976d2' }}>
        Atelier Flor de Macela
      </div>

      <div style={{ display: 'flex', gap: 20 }}>
        {isAdmin ? (
          <>
            <button onClick={() => navigate('/home')} style={btnStyle}>
              Home
            </button>
            <button onClick={() => navigate('/cadastro')} style={btnStyle}>
              Cadastro de Produtos e Insumos
            </button>
            <button onClick={() => navigate('/encomenda')} style={btnStyle}>
              Encomendar Produto
            </button>
            <button onClick={() => navigate('/relatorio')} style={btnStyle}>
              Relatórios
            </button>
          </>
        ) : (
          <>
            <button onClick={() => navigate('/homeuser')} style={btnStyle}>
              Home
            </button>
            <button
              onClick={() =>
                navigate(location.pathname === '/encomenda' ? '/catalogo' : '/encomenda')
              }
              style={btnStyle}
            >
              {location.pathname === '/encomenda' ? 'Catálogo de Produtos' : 'Encomendar Produto'}
            </button>
            <button onClick={() => navigate('/carrinho')} style={btnStyle}>
              Ir para o Carrinho
            </button>
            <button onClick={() => navigate('/historico')} style={btnStyle}>
              Histórico
            </button>
          </>
        )}

        <button onClick={handleLogout} style={{ ...btnStyle, color: '#d32f2f' }}>
          Sair
        </button>
      </div>
    </div>
  );
};

export default MenuSuperior;
