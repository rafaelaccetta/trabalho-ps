import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import HomePageUser from "../pages/HomePageUser";
import Layout from "./Layout";
import RelatorioPage from "../pages/RelatorioPage";
import RelatorioVendasPage from "../pages/RelatorioVendasPage";
import RelatoriosPage from "../pages/RelatoriosPage";
import CadastroPage from "../pages/CadastroPage";
import CadastroUsuarioPage from "../pages/CadastroUsuarioPage";
import CadastroInsumoPage from "../pages/CadastroInsumoPage";
import LoginPage from "../pages/LoginPage";
import EncomendaPage from "../pages/EncomendaPage";
import CadastroProdutoPage from "../pages/CadastroProdutoPage";
import CompraPage from "../pages/CompraPage";
import CarrinhoPage from "../pages/CarrinhoPage";
import CatalogoPage from "../pages/CatalogoPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        children: [
            {path: "", element: <LoginPage />},
            {path: "homeuser", element: <HomePageUser />},
            {path: "home", element: <HomePage />},
            { path: "relatorio", element: <RelatoriosPage /> },
            { path: "relatorios/produtos", element: <RelatorioPage /> },
            { path: "relatorios/vendas", element: <RelatorioVendasPage /> },
            {
                path: "cadastro",
                element: <CadastroPage />,
                children: [
                    {path: "usuario", element: <CadastroUsuarioPage />},
                    {path: "insumo", element: <CadastroInsumoPage />},
                    {path: "produto", element: <CadastroProdutoPage />}
                ]
            },
            {path: "login", element: <LoginPage />},
            {path: "encomenda", element: <EncomendaPage />},
            {path: "compra", element: <CompraPage />},
            {path: "carrinho", element: <CarrinhoPage />},
            {path: "catalogo", element: <CatalogoPage />}
        ]
    }
])
export default router;