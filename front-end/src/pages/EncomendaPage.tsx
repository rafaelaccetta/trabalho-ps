import React from 'react'
import EncomendaForm from './EncomendaForm'
import MenuSuperior from '../components/MenuSuperior';

const EncomendaPage = () => {
  return (
    <div style={{ backgroundColor: '#e3f2fd', minHeight: '100vh', paddingTop: 120 }}>
      <div
        style={{
          backgroundColor: '#fff',
          padding: '12px 24px',
          display: 'flex',
          justifyContent: 'space-between',
          alignItems: 'center',
          borderBottom: '1px solid #ccc',
          position: 'fixed',
          top: 0,
          left: 0,
          right: 0,
          zIndex: 1000,
        }}
      >
        <MenuSuperior />
      </div>

      <div style={{ textAlign: 'center', marginBottom: '2rem' }}>
        <h4 style={{ fontSize: '1.5rem', marginBottom: '1rem' }}>Encomenda:</h4>
        <EncomendaForm />
      </div>
    </div>
  )
}

export default EncomendaPage
