import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Student } from 'src/app/Student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrudService {
  baseUrl = environment.baseUrl;
  constructor(private http:HttpClient) { }

  findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseUrl);
  }
}
