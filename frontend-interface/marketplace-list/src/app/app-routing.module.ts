import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { ListsComponent } from './components/lists/lists.component';
import { ListdetailComponent } from './components/listdetail/listdetail.component';


const routes: Routes = [
  {path:'',component: ListsComponent},
  {path:'detail/:id',component: ListdetailComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
