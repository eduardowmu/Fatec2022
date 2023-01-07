import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/Student';
import { CrudService } from 'src/app/services/crud.service'

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {
  /*indicando quantidade de tipo Todo's estão fechados*/
  closed = 0
  
  list: Student[] = []

  constructor(private service: CrudService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll():void {
    this.service.findAll().subscribe((resposta) => {
      this.list = resposta;
      this.countClosed();
    })
  }

  countClosed():void {
    for(let todo of this.list) {
      if(todo.endDate == "") {
        this.closed++;
      }
    }
  }
}
/*
    {
      firstName: "Eduardo",
      mediumName: "Watanabe",
      lastName: "Murakoshi",
      birthDate: "1984-01-24",
      startDate: "2023-01-09",
      endDate: "",
      enrollNumber: "0123456789",
      courseId: "01",
      position: 1,
      email: "eduwmura@gmail.com"
    },
    {
      firstName: "Camila",
      mediumName: "Viana",
      lastName: "da Costa",
      birthDate: "1990-05-19",
      startDate: "2023-01-09",
      endDate: "",
      enrollNumber: "1234567890",
      courseId: "02",
      position: 1,
      email: "camila.costa@gmail.com"
    }

  */