import { Component } from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {NzHeaderComponent} from "ng-zorro-antd/layout";
import {NzButtonComponent} from "ng-zorro-antd/button";
import {NzRowDirective} from "ng-zorro-antd/grid";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NzHeaderComponent, RouterLink, NzButtonComponent, RouterLinkActive, NzRowDirective],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'rental_car_angular';
}
