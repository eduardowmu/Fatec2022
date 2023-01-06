import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/Student';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {
  list: Student[] = [
    {
      firstName: "Eduardo",
      mediumName: "Watanabe",
      lastName: "Murakoshi",
      birthDate: new Date,
      startDate: new Date,
      endDate: new Date,
      enrollNumber: "0123456789",
      courseId: "01",
      position: 1,
      email: "eduwmura@gmail.com"
    },
    {
      firstName: "Camila",
      mediumName: "Viana",
      lastName: "da Costa",
      birthDate: new Date,
      startDate: new Date,
      endDate: new Date,
      enrollNumber: "1234567890",
      courseId: "02",
      position: 1,
      email: "camila.costa@gmail.com"
    }

  ]

  constructor() { }

  ngOnInit(): void {
  }

}
