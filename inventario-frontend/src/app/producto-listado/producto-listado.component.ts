import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-producto-listado',
  standalone: false,
  templateUrl: './producto-listado.component.html',
  
})
export class ProductoListadoComponent {
  producto: Producto[];

  constructor(private productoServicio: ProductoService){}

  ngOnInit(){
    //cargar los productos
  this.ObtenerProductos();
  }

  private ObtenerProductos(){
    //consume datos del observable(servicio)
    this.productoServicio.obtenerProductosLista().subscribe(
      (
        datos =>{
          this.producto = datos;
        }
      )
    )
  }
  

}
