import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReadAllComponent } from './components/read-all/read-all.component';
import { CreateComponent } from './components/create/create.component';


const routes: Routes = [
  {
    path: '',
    component: ReadAllComponent
  },
  {
    path: 'new',
    component: CreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }