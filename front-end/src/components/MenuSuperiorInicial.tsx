import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../pages/HomePage.css'; 

interface Props {
  isAdmin: boolean;
}

const MenuSuperiorInicial = ({ isAdmin }: Props) => {
  const navigate = useNavigate();
  const [showMenu, setShowMenu] = useState(false);
  const [nomeUsuario, setNomeUsuario] = useState('');

  useEffect(() => {
    if (!isAdmin) {
      const nome = localStorage.getItem('nome');
      if (nome) setNomeUsuario(nome);
    }
  }, [isAdmin]);

  const handleLogout = () => {
    localStorage.clear();
    navigate('/login');
  };

  return (
    <div className="user-menu-superior">
      <div className="user-menu-title">Atelier Flor de Macela</div>
      <div className="user-menu-actions">
        <button onClick={() => setShowMenu(!showMenu)} className="user-menu-btn">
          Perfil
        </button>
        {showMenu && (
          <div className="user-dropdown-menu">
            <p><strong>{isAdmin ? 'Admin' : nomeUsuario || 'Cliente'}</strong></p>
            <hr />
            {!isAdmin && (
              <button onClick={() => navigate('/historico')}>Minhas Compras</button>
            )}
            <button onClick={handleLogout}>Sair</button>
          </div>
        )}
      </div>
    </div>
  );
};

export default MenuSuperiorInicial;
