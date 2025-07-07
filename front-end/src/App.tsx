import { RouterProvider } from 'react-router-dom'
import router from './routes/router'
import { CarrinhoProvider } from './context/CartContext'
import './App.css'

function App() {
  return (
    <CarrinhoProvider>
      <RouterProvider router={router} />
    </CarrinhoProvider>
  )
}

export default App
