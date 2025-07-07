import React from 'react';
import { useNavigate } from 'react-router-dom';

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
};

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
};

const RelatoriosPage = () => {
  const navigate = useNavigate();

  return (
    <div style={cardStyle}>
      <h4 style={{ marginBottom: 24, fontWeight: 600, fontSize: 24, color: '#333' }}>
        Relatórios disponíveis:
      </h4>
      <button style={buttonStyle} onClick={() => navigate('/relatorios/produtos')}>
        Relatório de Produtos
      </button>
      <button style={{ ...buttonStyle, background: '#43a047' }} onClick={() => navigate('/relatorios/vendas')}>
        Relatório de Vendas
      </button>
    </div>
  );
};

export default RelatoriosPage;
