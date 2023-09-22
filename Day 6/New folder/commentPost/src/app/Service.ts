import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PostService {

    private postData: any = null; 

  constructor(private httpClient: HttpClient) { }

  getPostById(postId: number): Observable<any> {
    const url = `http://localhost:8080/forum/post/${postId}`;
    return this.httpClient.get(url);
  }

  setPostData(data: any) {
    this.postData = data;
  }

  getPostData() {
    return this.postData;
  }
}
