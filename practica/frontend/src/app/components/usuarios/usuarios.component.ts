import { Component, OnInit } from '@angular/core';
import { UsuariosService } from 'src/app/services/usuarios.service';
import { UsuarioReports } from 'src/environments/environment';
import { MatTableDataSource } from '@angular/material/table';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})

export class UsuariosComponent implements OnInit {
  
  ELEMENT_DATA!: UsuarioReports[];

  displayedColumns: string[] = ['nombre', 'email', 'estado', 'rol'];
  dataSource = new MatTableDataSource<UsuarioReports>(this.ELEMENT_DATA);

  constructor(private _userService: UsuariosService) { }

  ngOnInit(): void {
    this.getAllReports();
  }

  public getAllReports() {
    let resp = this._userService.listarUsuarios();
    resp.subscribe(report => this.dataSource.data = report as UsuarioReports[])
  }

  listarUsuarios = async () => {
    try {
    const response = await this._userService.listarUsuarios().toPromise()
    console.log(response);    

    } catch (error) {

    }
  }

}
