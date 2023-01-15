import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ButtonComponent } from './Components/button/button.component';
import { HeaderComponent } from './Components/header/header.component';
import { LoginComponent } from './Pages/login/login.component'
import { JobOfferFormComponent } from './Components/job-offer-form/job-offer-form.component'

const routes: Routes = [
  { path: '', component: ButtonComponent },
  { path: 'login', component: LoginComponent},
  { path: 'second', component: HeaderComponent },
  { path: 'form', component: JobOfferFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
