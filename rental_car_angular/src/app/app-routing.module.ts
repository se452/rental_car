import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes} from "@angular/router";
import {SignupComponent} from "./auth/components/signup/signup.component";
import {LoginComponent} from "./auth/components/login/login.component";

const routes: Routes = [
  {path:"register", component: SignupComponent},
  {path:"login", component: LoginComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
