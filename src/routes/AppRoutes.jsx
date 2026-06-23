import {
   HashRouter,
   BrowserRouter,
   Routes,
   Route 
} from "react-router-dom"

// Obs: Para importar componentes específicos de uma tecnologia, escolha o componente, caso mais de 1
//      utilize a vírgula para separá-los

import HomeFuncionario from '../pages/HomeFuncionario/HomeFuncionario'
import ListarProduto from '../pages/ListarProduto/ListarProduto'

// BrowserRouter : Navegação utilizando a tag html <a></a> com href "Sempre recarrega a página completa"
// HashRouter: Navegação utilizando o componente <Link></Link> do react-router-dom "Recarrega só o necessário"


const AppRoutes = () => {


    return (
                <HashRouter>
                      <Routes>
                             <Route 
                                path="/"
                                element={<HomeFuncionario/>}
                             />

                             <Route 
                                path="/home"
                                element={<HomeFuncionario/>}
                             />

                             <Route 
                                path="/produtos"
                                element={<ListarProduto/>}
                             />

                      </Routes>
                </HashRouter>
               
    )
}

export default AppRoutes