import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ComentarioService } from 'src/app/services/comentario.service';
import { ComentarioReports } from 'src/environments/environment';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

@Component({
  selector: 'app-comentario',
  templateUrl: './comentario.component.html',
  styleUrls: ['./comentario.component.css']
})

export class ComentarioComponent implements OnInit {

  ELEMENT_DATA!: ComentarioReports[];

  displayedColumns: string[] = ['usuario', 'nombre', 'estado'];
  dataSource = new MatTableDataSource<ComentarioReports>(this.ELEMENT_DATA);

  constructor(private _ComentarioService: ComentarioService, public router: Router) { }

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
    this.validarLogin();
  }

  public getAllReports() {
    
    let resp = this._ComentarioService.listarComentarios();
    resp.subscribe(
      report => this.dataSource.data = report as ComentarioReports[]
    )
  }

}
