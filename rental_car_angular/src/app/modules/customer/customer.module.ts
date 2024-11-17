import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ngZorroImportsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class CustomerModule { }
