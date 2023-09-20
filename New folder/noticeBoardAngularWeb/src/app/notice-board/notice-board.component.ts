import { Component, OnInit } from '@angular/core';
import { Notice } from '../notice.model';

@Component({
  selector: 'app-notice-board',
  templateUrl: './notice-board.component.html',
  styleUrls: ['./notice-board.component.css']
})
export class NoticeBoardComponent implements OnInit {
  notices: Notice[] = [];
  title: string = ''; 
  content: string = '';
  contact: string = '';

  constructor() {}

  ngOnInit(): void {}

  addNotice(title: string, content: string , contact: string) {
    const newNotice = new Notice(title, content, contact, new Date());

    this.notices.push(newNotice);
  
    if (this.notices.length > 4) {
      this.notices.shift();
    }
    this.title = '';
    this.content = '';
  }
  
}
