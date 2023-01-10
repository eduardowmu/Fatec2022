import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Student } from 'src/app/Student';
import { Observable } from 'rxjs';
//import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  baseUrl = environment.baseUrl;
  constructor(private http:HttpClient) { }

  findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseUrl);
  }
  
  create(student: Student) : Observable<Student> {
    const url = `${this.baseUrl}/save`;
    return this.http.post<Student>(url, student);
  }
  /*
  message(msg:String):void {
    this.snackbar.open(`${msg}`, 'OK', {
      horizontalPosition:'end',
      verticalPosition:'top',
      duration: 4000
    });
  }
  */
}