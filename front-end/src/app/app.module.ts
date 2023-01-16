import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';


import { AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Components/header/header.component';
import { ButtonComponent } from './Components/button/button.component';
import { LoginComponent } from './Pages/login/login.component';
import { JobOfferFormComponent } from './Components/job-offer-form/job-offer-form.component';
import { HomeComponent } from './Pages/home/home.component';
import { JobOfferCardComponent } from './Components/job-offer-card/job-offer-card.component';
import { JobOfferDetailsComponent } from './Components/job-offer-details/job-offer-details.component';
import { AgentDashComponent } from './Pages/agent-dash/agent-dash.component';
import { AgentLoginComponent } from './Pages/agent-login/agent-login.component';
import { RegisterComponent } from './Pages/register/register.component';
import { RegistrationConfirmationComponent } from './Components/registration-confirmation/registration-confirmation.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ButtonComponent,
    LoginComponent,
    JobOfferFormComponent,
    HomeComponent,
    JobOfferCardComponent,
    JobOfferDetailsComponent,
    AgentDashComponent,
    AgentLoginComponent,
    RegisterComponent,
    RegistrationConfirmationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
