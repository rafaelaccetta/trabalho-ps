import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './HomePage.css';

const HomePageUser = () => {
  const navigate = useNavigate();
  const [showMenu, setShowMenu] = useState(false);
  const [nome, setNomeUsuario] = useState('');

  useEffect(() => {
    const token = localStorage.getItem('token');
    const email = localStorage.getItem('email');
    const nome = localStorage.getItem('nome');
    
    if (!token) {
      navigate('/login');
    } else if (email === 'admin@admin.com') {
      navigate('/');
    }

    if (nome) setNomeUsuario(nome);
  }, [navigate]);

  const handleLogout = () => {
    localStorage.clear();
    navigate('/login');
  };

  return (
    <div className="home-page">
      <div className="user-menu-superior">
        <div className="user-menu-title">Atelier Flor de Macela</div>
        <div className="user-menu-actions">
          <button onClick={() => setShowMenu(!showMenu)} className="user-menu-btn">
            Perfil
          </button>
          {showMenu && (
            <div className="user-dropdown-menu">
              <p><strong>{nome || 'Cliente'}</strong></p>
              <hr />
              <button onClick={() => navigate('/historico')}>Minhas Compras</button>
              <button onClick={handleLogout}>Sair</button>
            </div>
          )}
        </div>
      </div>

      <div className="home-card">
        <h1>Bem-vindo ao Sistema Atelier Flor de Macela</h1>
        <p className="home-desc">Bem-vindo! Aqui você pode encomendar produtos e realizar compras.</p>
        <nav className="home-nav">
          <Link to="/encomenda" className="home-link">Encomendar Produto</Link>
          <Link to="/compra" className="home-link">Comprar Produto</Link>
        </nav>
      </div>
    </div>
  );
};

export default HomePageUser;
