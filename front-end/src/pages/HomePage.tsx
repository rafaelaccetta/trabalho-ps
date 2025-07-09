import { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './HomePage.css';
import MenuSuperiorInicial from '../components/MenuSuperiorInicial';

const HomePage = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('token');
    const email = localStorage.getItem('email');
    if (!token) {
      navigate('/login');
    } else if (email && email !== 'admin@admin.com') {
      navigate('/homeuser');
    }
  }, [navigate]);

  return (
    <div className="home-page">
      <MenuSuperiorInicial isAdmin={true} />

      <div className="home-card">
        <h1>Bem-vindo ao Sistema Atelier Flor de Macela</h1>
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
