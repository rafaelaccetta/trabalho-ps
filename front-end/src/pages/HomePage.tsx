import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './HomePage.css';

const HomePage = () => {
  const navigate = useNavigate();
  const [showMenu, setShowMenu] = useState(false);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const email = localStorage.getItem('email');
    if (!token) {
      navigate('/login');
    } else if (email && email !== 'admin@admin.com') {
      navigate('/homeuser');
    }
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
              <p><strong>Admin</strong></p>
              <hr />
              <button onClick={handleLogout}>Sair</button>
            </div>
          )}
        </div>
      </div>

      <div className="home-card">
        <h1>Bem-vindo ao Sistema Atelier Flor de Macela</h1>
        <p className="home-desc">Gerencie produtos, insumos, usuários, encomendas e relatórios de forma simples e eficiente.</p>
        <nav className="home-nav">
          <Link to="/cadastro" className="home-link">Cadastro de Produtos e Insumos</Link>
          <Link to="/encomenda" className="home-link">Encomendar Produto</Link>
          <Link to="/relatorio" className="home-link">Relatórios</Link>
        </nav>
      </div>
    </div>
  );
};

export default HomePage;
