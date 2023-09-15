import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestockComponent } from './restock/restock.component';

const routes: Routes = [{ path: 'restock', component: RestockComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
