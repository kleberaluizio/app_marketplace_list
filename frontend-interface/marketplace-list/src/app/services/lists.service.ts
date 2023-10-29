import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { List } from '../models/List';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListsService {

  constructor(private http: HttpClient) { }

  public getLists(): Observable<List[]>{
    return this.http.get<List[]>(environment.urlAPI+"/list-of-items");
  }

  public registerList(List : List): Observable<List> {
    return this.http.post<List>(environment.urlAPI+"/list-of-items",List);  
  }
}
