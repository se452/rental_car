import { Injectable } from '@angular/core';
import { get } from 'http';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  static getUserId() {
    const user = this.getUser();
      if(user == null) {
      return '';
  }
  return user.id;
  }
  static getToken() {
    return window.localStorage.getItem('Token');
  }
  getToken() {
    return window.localStorage.getItem('Token');
  }

  static getUser() {
    const user = window.localStorage.getItem('User');
  if(user) {
    return JSON.parse(user);
  }
  return null;
}

  constructor() { }
}

// Compare this snippet from rental_car/rental_car_angular/src/app/modules/customer/components/customer-dashboard/customer-dashboard.component.html:










