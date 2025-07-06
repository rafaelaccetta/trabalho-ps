import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import HomePageUser from "../pages/HomePageUser";
import Layout from "./Layout";
import RelatorioPage from "../pages/RelatorioPage";
import CadastroPage from "../pages/CadastroPage";
import CadastroUsuarioPage from "../pages/CadastroUsuarioPage";
import CadastroInsumoPage from "../pages/CadastroInsumoPage";
import LoginPage from "../pages/LoginPage";
import EncomendaPage from "../pages/EncomendaPage";
import CadastroProdutoPage from "../pages/CadastroProdutoPage";
import CompraPage from "../pages/CompraPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        children: [
            {path: "", element: <LoginPage />},
            {path: "homeuser", element: <HomePageUser />},
            {path: "home", element: <HomePage />},
            {path: "relatorio", element: <RelatorioPage />},
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
            {path: "compra", element: <CompraPage />}
        ]
    }
])
export default router;