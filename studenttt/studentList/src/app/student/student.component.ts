import { Component } from '@angular/core';
import { Student } from './student.model';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  students: Student[] = [
    new Student(1, 'Gaurav', new Date('2000-05-15'), 'Computer Science', 5000),
    new Student(2, 'Bibhu', new Date('2002-08-20'), 'Mathematics', 4500),
    new Student(3, 'Abhishek', new Date('2001-03-10'), 'Physics', 4800),
    new Student(4, 'Ankush', new Date('2000-12-05'), 'Chemistry', 5200),
  ];
}
