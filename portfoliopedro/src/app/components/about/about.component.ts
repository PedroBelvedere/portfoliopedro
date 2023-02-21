import { Component, OnInit } from '@angular/core';
import { usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/servicio/usuario.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  usuario: usuario = new usuario("", "", "");

  constructor(public usuarioServicio: UsuarioService) { }

  ngOnInit(): void {
    this.usuarioServicio.getUsuario().subscribe(data => {this.usuario = data})
  }

}
