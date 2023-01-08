import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/Student';
import { CrudService } from 'src/app/services/crud.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {
  /*indicando quantidade de tipo Todo's estão fechados*/
  closed = 0
  
  list: Student[] = []

  constructor(private service: CrudService, private router:Router) { }

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

  goToCreateNew():void {
    this.router.navigate(['new']);
  }
}