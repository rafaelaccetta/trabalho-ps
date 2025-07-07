import React from 'react'
import EncomendaForm from './EncomendaForm'

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
        <div style={{ fontWeight: 600, fontSize: 20, color: '#1976d2' }}>
          Atelier Flor de Macela
        </div>
        <div style={{ display: 'flex', gap: 20 }}>
          <a href="/homeuser" style={{ textDecoration: 'none', color: '#1976d2', fontWeight: 'bold' }}>
            Home
          </a>
          <a href="/catalogo" style={{ textDecoration: 'none', color: '#1976d2', fontWeight: 'bold' }}>
            Catálogo
          </a>
        </div>
      </div>

      <div style={{ textAlign: 'center', marginBottom: '2rem' }}>
        <h4 style={{ fontSize: '1.5rem', marginBottom: '1rem' }}>Encomenda:</h4>
        <EncomendaForm />
      </div>
    </div>
  )
}

export default EncomendaPage
