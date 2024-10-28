import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

// NG ZORRO IMPORTS
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import {SignupComponent} from "./auth/components/signup/signup.component";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    SignupComponent
  ],
  imports: [
    BrowserModule,
    AppComponent,
    NzSpinModule,
    NzFormModule,
    NzButtonModule,
    NzInputModule,
    NzLayoutModule,
    ReactiveFormsModule


  ],
  providers: [],

})
export class AppModule { }

