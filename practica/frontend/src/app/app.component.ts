import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { ComentarioService } from './services/comentario.service';
import { ComentarioReports } from 'src/environments/environment';
import { MatTableDataSource } from '@angular/material/table';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Gestion de comentarios';
  description = '';

  
  ELEMENT_DATA!: ComentarioReports[];

  displayedColumns: string[] = ['descripcion', 'estado'];
  dataSource = new MatTableDataSource<ComentarioReports>(this.ELEMENT_DATA);

  
  constructor(private http: HttpClient, public router: Router, private _ComentarioService: ComentarioService) { }

  validarLogin() {
    let sesion = localStorage.getItem("sesion")
    if (sesion === null) {
      this.router.navigate(["/login"])
    } else {
      this.router.navigate(["/comentarios"])
    }
    console.log(sesion)
  }
  ngOnInit(): void {
    this.getAllReports();
    // this.validarLogin();
  }

  public getAllReports() {

    let resp = this._ComentarioService.listarComentarios();
    resp.subscribe(
      report => this.dataSource.data = report as ComentarioReports[]
    )
  }

  cerrarSesion() {
    localStorage.removeItem("sesion")
    this.router.navigate(["/login"])
  }
}