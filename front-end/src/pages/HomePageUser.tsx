import React, { useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import './HomePage.css'

const HomePageUser = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const token = localStorage.getItem('token');
    const email = localStorage.getItem('email');
    if (!token) {
      navigate('/login');
    } else if (email === 'admin@admin.com') {
      navigate('/');
    }
  }, [navigate]);

  return (
    <div className="home-page">
      <div className="home-card">
        <h1>Bem-vindo ao Sistema Atelier Flor de Macela</h1>
        <p className="home-desc">Bem-vindo! Aqui você pode encomendar produtos e realizar compras.</p>
        <nav className="home-nav">
          <Link to="/encomenda" className="home-link">Encomendar Produto</Link>
          <Link to="/cadastro" className="home-link">Comprar Produto</Link>
        </nav>
      </div>
    </div>
  )
}

export default HomePageUser
