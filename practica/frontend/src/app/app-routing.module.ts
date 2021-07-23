import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegistroComponent } from './components/registro/registro.component';
import { RegistroComentarioComponent } from './components/registrocomentario/registroevento.component';
import { ComentarioComponent } from './components/comentario/comentario.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

// Se cra una ruta, se separarn con ",": los componentes [] constantes {}
const routes: Routes = [{ path: 'login', component: LoginComponent },
                        { path: `registro`, component: RegistroComponent },
                        { path: `usuarios`, component: UsuariosComponent },
                        { path: `registroComentarios`, component: RegistroComentarioComponent },
                        { path: 'Comentarios', component: ComentarioComponent }];
//ej:   const arry: {nombre: string, edad: number}[] = [{nombre:`erick`, edad: 10} , {nombre:`joel`, edad: 20}]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
