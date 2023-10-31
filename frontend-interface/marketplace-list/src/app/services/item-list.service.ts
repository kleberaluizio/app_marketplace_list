import { Injectable } from '@angular/core';
import { ItemList } from '../models/ItemList';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ItemListService {

  constructor(private http: HttpClient) { }
  public registerItem(ItemList: ItemList): Observable<ItemList>{
    return this.http.post<ItemList>(environment.urlAPI+"/item-list",ItemList);  
  }
}
