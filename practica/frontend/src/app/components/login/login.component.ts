import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuariosService } from 'src/app/services/usuarios.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  email: string = ""
  clave: string = ""

  constructor(public UsuariosService: UsuariosService, public router: Router) { }

  validarLogin() {
    let sesion = localStorage.getItem("sesion")
    if (sesion === null) {
      this.router.navigate(["/login"])
    } else {
      this.router.navigate(["/Comentarios"])
    }
    console.log(sesion)
  }

  ngOnInit(): void {
    this.validarLogin();
  }

  submitLogin() {
    const user = { email: this.email, clave: this.clave };

    this.UsuariosService.login(user).subscribe(data => {
      if (data !== null) {
        localStorage.setItem("sesion", data);
        this.router.navigate(["/Comentarios"])
      } else {
        alert("Credenciales incorrectas");
      }
    });

  }

}
