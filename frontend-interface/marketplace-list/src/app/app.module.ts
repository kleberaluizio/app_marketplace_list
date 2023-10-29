import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ListsComponent } from './components/lists/lists.component';
import { ListdetailComponent } from './components/listdetail/listdetail.component';

@NgModule({
  declarations: [
    AppComponent,
    ListsComponent,
    ListdetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  // Componente de requisições HTTP
    FormsModule        // Componente de manipulação de formulário
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
