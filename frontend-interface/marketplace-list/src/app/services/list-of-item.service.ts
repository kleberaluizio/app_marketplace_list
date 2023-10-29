import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { List } from '../models/List';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ListOfItemService {

  constructor(private http: HttpClient) { // Injeção de dependencia por meio do construtor
  }

  public getLists(): Observable<List[]>{
    return this.http.get<List[]>(environment.urlAPI+ "/list-of-items");
  }
}
