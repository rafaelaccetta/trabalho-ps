import React, { useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import './HomePage.css'

const HomePage = () => {
  const navigate = useNavigate();

  useEffect(() => {
    // Simples verificação de login: token salvo no localStorage
    const token = localStorage.getItem('token');
    if (!token) {
      navigate('/login');
    }
  }, [navigate]);

  return (
    <div className="home-page">
      <div className="home-card">
        <h1>Bem-vindo ao Sistema de Produtos Naturais</h1>
        <p className="home-desc">Gerencie produtos, insumos, usuários, encomendas e relatórios de forma simples e eficiente.</p>
        <nav className="home-nav">
          <Link to="/cadastro" className="home-link">Cadastro de Produtos e Insumos</Link>
          <Link to="/cadastro/usuario" className="home-link">Cadastro de Usuário</Link>
          <Link to="/encomenda" className="home-link">Encomendar Produto</Link>
          <Link to="/relatorio" className="home-link">Relatórios</Link>
          <Link to="/login" className="home-link">Login</Link>
        </nav>
      </div>
    </div>
  )
}

export default HomePage