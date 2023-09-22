import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostFormComponent } from './post-form/post-form.component';
import { PostComponent } from './post/post.component';

const routes: Routes = [{path:'post-form',component: PostFormComponent},{path:'post/:id',component: PostComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
