import { Component, OnInit } from '@angular/core';
import { PostService } from '../Service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit{

  postData: any;

  constructor(private postService: PostService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const pId = params.get('id');
      if (pId !== null) {
        const postId = +pId;
        this.postService.getPostById(postId).subscribe(data => {
          this.postData = data;
          console.log(this.postData);
        });
      } else {
        console.log('Invalid postId in the URL.');
      }
    });
  }
  
}
