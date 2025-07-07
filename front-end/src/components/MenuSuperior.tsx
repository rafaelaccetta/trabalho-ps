import React from 'react';
import { useNavigate } from 'react-router-dom';

const MenuSuperior = () => {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.clear();
    navigate('/login');
  };
  const estaNaEncomenda = location.pathname === '/encomenda';

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
        <button
          onClick={() => navigate('/homeuser')}
          style={{
            background: 'none',
            border: 'none',
            fontSize: 16,
            color: '#1976d2',
            cursor: 'pointer',
            fontWeight: 'bold',
          }}
        >
          Home
        </button>
        <button
          onClick={() => navigate(estaNaEncomenda ? '/catalogo' : '/encomenda')}
          style={{
            background: 'none',
            border: 'none',
            fontSize: 16,
            color: '#1976d2',
            cursor: 'pointer',
            fontWeight: 'bold',
          }}
        >
          {estaNaEncomenda ? 'Catálogo de Produtos' : 'Encomendar Produto'}
        </button>
        <button
          onClick={() => navigate('/carrinho')}
          style={{
            background: 'none',
            border: 'none',
            fontSize: 16,
            color: '#1976d2',
            cursor: 'pointer',
            fontWeight: 'bold',
          }}
        >
          Ir para o Carrinho
        </button>
        <button
          onClick={handleLogout}
          style={{
            background: 'none',
            border: 'none',
            fontSize: 16,
            color: '#d32f2f',
            cursor: 'pointer',
            fontWeight: 'bold',
          }}
        >
          Sair
        </button>
      </div>
    </div>
  );
};

export default MenuSuperior;
