<<<<<<< Updated upstream
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










=======
import { Injectable } from '@angular/core';

const USER = "user";
const TOKEN = "token";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  static saveToken(token: string): void {
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
  }

  static saveUser(user: any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  static getUser() {
    return JSON.parse(window.localStorage.getItem(USER));
  }

  static getToken() {
    return window.localStorage.getItem(TOKEN);
  }

  static getUserId(): string {
    const user = this.getUser();
    if (user == null) { return ''; }
    return user.id;
  }

  static getUserRole(): string {
    const user = this.getUser();
    if (user == null) return "";
    return user.role;
  }

  static isAdminLoggedIn(): boolean {
    if (this.getToken() == null) return false;
    const role: string = this.getUserRole();
    return role == "ADMIN";
  }

  static isCustomerLoggedIn(): boolean {
    if (this.getToken() == null) return false;
    const role: string = this.getUserRole();
    return role == "CUSTOMER";
  }

  static logout(): void {
    window.localStorage.removeItem(USER);
    window.localStorage.removeItem(TOKEN);
  }


}
>>>>>>> Stashed changes
