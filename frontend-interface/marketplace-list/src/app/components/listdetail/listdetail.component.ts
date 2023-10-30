import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-listdetail',
  templateUrl: './listdetail.component.html',
  styleUrls: ['./listdetail.component.css']
})
export class ListdetailComponent implements OnInit{

  public newProduct : Product;
  public products: Product[] = [];
  public formNewProduct: boolean = false;

  constructor(private service: ProductsService){ 
    this.newProduct = new Product();
  }

  ngOnInit(): void {
    this.getAllProducts();
  }

  public getAllProducts(){
    this.service.getAllProducts().subscribe(
      (res: Product[]) => {
        this.products = res;
      },
      (err) => {
        alert("Erro ao recuperar listas de produtos")
      }
    );
  }

  public registerNewProduct(){
      this.service.registerProduct(this.newProduct).subscribe(
        (res: Product) => {
          alert("New Product registered!");
          this.getAllProducts();
        },
        (err) => {
          alert("Erro ao recuperar listas de produtos")
        }
      )
      this.formNewProduct = false;

  }

  public showModal(){
    document.getElementById("btnModal")?.click();
  }

  public enableNewProduct(){
    this.formNewProduct = true;
  }
}
