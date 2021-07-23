import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistroComentarioService } from 'src/app/services/registroComentario.service';

@Component({
  selector: 'app-registroComentario',
  templateUrl: './registroComentario.component.html',
  styleUrls: ['./registroComentario.component.css']
})
export class RegistroComentarioComponent implements OnInit {

  // registro
  nombre: string = ""
  fecha_fin = new Date()
  usuario: number = 0

  constructor(public RegistroComentarioService: RegistroComentarioService, public router: Router) { }

  validarLogin() {
    let sesion = localStorage.getItem("sesion")
    if (sesion === null) {
      this.router.navigate(["/login"])
    } else {
      let usuario = JSON.parse(sesion)
      this.usuario = usuario.id;
      this.router.navigate(["/Comentarios"])
    }
    console.log(sesion)
  }

  ngOnInit(): void {
    this.validarLogin();
  }

  registro() {
    let Comentario = {
      nombre: this.nombre, fecha_fin: this.fecha_fin, usuario_id: this.usuario
    }
    this.RegistroComentarioService.registrarComentario(Comentario).subscribe(data => {
      if (data !== null) {
        alert("Comentario creada correctamente");
      } else {
        alert("No se registró la Comentario");
      }
    });

  }

  actualizarComentario(){
    
  }

}
