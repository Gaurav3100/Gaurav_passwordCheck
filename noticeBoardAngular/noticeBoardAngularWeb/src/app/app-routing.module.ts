import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NoticeBoardComponent } from './notice-board/notice-board.component';

const routes: Routes = [{ path: 'notice-board', component: NoticeBoardComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
