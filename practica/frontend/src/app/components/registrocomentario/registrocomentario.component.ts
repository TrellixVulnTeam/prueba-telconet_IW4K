import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistroComentarioService } from 'src/app/services/registrocomentario.service';

@Component({
  selector: 'app-registrocomentario',
  templateUrl: './registrocomentario.component.html',
  styleUrls: ['./registrocomentario.component.css']
})
export class RegistroComentarioComponent implements OnInit {

  // registro
  descripcion: string = ""
  fecha_registro = new Date()
  usuario: number = 0

  constructor(public RegistroComentarioService: RegistroComentarioService, public router: Router) { }

  validarLogin() {
    let sesion = localStorage.getItem("sesion")
    if (sesion === null) {
      this.router.navigate(["/login"])
    } else {
      let usuario = JSON.parse(sesion)
      this.usuario = usuario.id;
      this.router.navigate(["/comentarios"])
    }
    console.log(sesion)
  }

  ngOnInit(): void {
    this.validarLogin();
  }

  registro() {
    let Comentario = {
      descripcion: this.descripcion, fecha_registro: this.fecha_registro, usuario: this.usuario
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
