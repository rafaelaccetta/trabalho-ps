import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import Layout from "./Layout";
import RelatorioPage from "../pages/RelatorioPage";
import CadastroPage from "../pages/CadastroPage";
import CadastroUsuarioPage from "../pages/CadastroUsuarioPage";

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
                    {path: "usuario", element: <CadastroUsuarioPage />}
                ]
            }
        ]
    }
])
export default router;