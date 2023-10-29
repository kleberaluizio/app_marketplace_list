import { Component, OnInit } from '@angular/core';
import { List } from 'src/app/models/List';
import { ListsService } from 'src/app/services/lists.service';

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.css']
})
export class ListsComponent implements OnInit{

  public Lists: List[] = [];
  public newList: List = new List();
  constructor(private service: ListsService){}

  ngOnInit(): void {
    this.getAllLists();
  }
  public getAllLists(){
    this.service.getLists().subscribe(
      (res: List[]) => {
        this.Lists = res;
      },
      (err) => {
        alert("Erro ao recuperar listas de compra")
      }
    );
  }

}
