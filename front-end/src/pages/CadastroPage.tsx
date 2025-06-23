import React from 'react'
import { Outlet } from 'react-router-dom'

const CadastroPage = () => {
  return (
    <div>
        <h4>Cadastro:</h4>
        <Outlet />
    </div>
  )
}

export default CadastroPage