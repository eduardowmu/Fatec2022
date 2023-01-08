import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Student} from 'src/app/Student'
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  student: Student = {
    firstName: '',
    mediumName: '',
    lastName: '',
    birthDate: '',
    startDate: '',
    endDate: '',
    enrollNumber: '',
    courseId: '',
    position: 0,
    email: ''
  }

  constructor(private router:Router, private service: CrudService) { }

  ngOnInit(): void {
  }
  /*
  create():void {
    this.service.create(this.student).subscribe((reponse) => {
      this.service.message("Operação realizada com sucesso");
      this.router.navigate(['']);
    }, err => this.service.message("Erro interno, favor tente novamente."));
  }

  voltar():void {
    /**Este método insere a URL o path desejado
    this.router.navigate([''])
  }
  */
}