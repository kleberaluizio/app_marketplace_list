import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ItemList } from 'src/app/models/ItemList';
import { Product } from 'src/app/models/Product';
import { ItemListService } from 'src/app/services/item-list.service';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-listdetail',
  templateUrl: './listdetail.component.html',
  styleUrls: ['./listdetail.component.css']
})
export class ListdetailComponent implements OnInit{

  public newProduct : Product;
  public products: Product[] = [];
  public newItem: ItemList;
  public formNewProduct: boolean = false;
  public idList: number = 0;

  constructor(
    private service: ProductsService,
    private itemListService: ItemListService,
    private activatedRoute: ActivatedRoute)
    { 

    this.newProduct = new Product();
    this.newItem = new ItemList();
    this.idList = this.activatedRoute.snapshot.params['id'];
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

  public addItemToList(){
    this.newItem.id = this.idList;
    this.itemListService.registerItem(this.newItem).subscribe(
      (res: ItemList) => {
        alert("New Item registered!");
        this.getAllProducts();
      },
      (err) => {
        alert("Erro ao criar item")
      }
    )
  }
}
