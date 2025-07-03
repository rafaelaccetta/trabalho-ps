import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import Layout from "./Layout";
import RelatorioPage from "../pages/RelatorioPage";
import CadastroPage from "../pages/CadastroPage";
import CadastroUsuarioPage from "../pages/CadastroUsuarioPage";
import CadastroInsumoPage from "../pages/CadastroInsumoPage";
import LoginPage from "../pages/LoginPage";
import EncomendaPage from "../pages/EncomendaPage";
import CadastroProdutoPage from "../pages/CadastroProdutoPage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Layout />,
        children: [
            {path: "", element: <HomePage />},
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
            {path: "encomenda", element: <EncomendaPage />}
        ]
    }
])
export default router;