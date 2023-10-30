import { Injectable } from '@angular/core';
import { Product } from '../models/Product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) {}

  public getAllProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(environment.urlAPI+"/products");
  }

  public registerProduct(Product: Product): Observable<Product>{
    return this.http.post<Product>(environment.urlAPI+"/products",Product);  
  }
}
