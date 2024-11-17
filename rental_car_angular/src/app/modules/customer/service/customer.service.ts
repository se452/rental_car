import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from '../../../auth/services/storage/storage.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private Basic_URL: string = 'http://your-api-url.com'; // Define Basic_URL

  constructor(private http: HttpClient, private storageService: StorageService) { }

  getCarById(Id: number): Observable<any> {
    return this.http.get(this.Basic_URL + "/api/customer/car/" + Id, {
      headers: this.createAuthorizationHeader()
    });
  }

  bookACar(bookACarDto: any): Observable<any> {
    return this.http.post(this.Basic_URL + "/api/customer/book", bookACarDto, {
      headers: this.createAuthorizationHeader()
    });
  }

  createAuthorizationHeader(): HttpHeaders {
    let autheaders: HttpHeaders = new HttpHeaders();
    return autheaders.set('Authorization', 'Bearer ' + 
       StorageService.getToken());
  }
}
