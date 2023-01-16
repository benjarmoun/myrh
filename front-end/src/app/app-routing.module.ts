import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ButtonComponent } from './Components/button/button.component';
import { HeaderComponent } from './Components/header/header.component';
import { LoginComponent } from './Pages/login/login.component'
import { HomeComponent } from './Pages/home/home.component'
import { AgentDashComponent } from './Pages/agent-dash/agent-dash.component'
import { AgentLoginComponent } from './Pages/agent-login/agent-login.component'
import { RegisterComponent } from './Pages/register/register.component'
import { RegistrationConfirmationComponent } from './Components/registration-confirmation/registration-confirmation.component'
import { JobOfferFormComponent } from './Components/job-offer-form/job-offer-form.component'


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent},
  { path: 'second', component: HeaderComponent },
  { path: 'form', component: JobOfferFormComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'confirm', component: RegistrationConfirmationComponent },
  { path: 'test', component: ButtonComponent },
  { path: 'agent/login', component: AgentLoginComponent },
  { path: 'agent/dash', component: AgentDashComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
