import { Component } from '@angular/core';
import { PostService } from '../Service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent {
  postId: any;
  checkData: any;

  constructor(
    private postService: PostService,
    private router: Router
  ) { }

  getPost() {
    if (this.postId) {
        const postId = this.postId;
        this.router.navigate(['/post', postId]);
    } else {
      console.log('Please enter a postId.');
    }
  }
  
}
