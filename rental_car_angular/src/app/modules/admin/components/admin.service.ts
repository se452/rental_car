import { Injectable } from '@angular/core';
<<<<<<< HEAD
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StorageService } from '../../../auth/services/storage/storage.service';
const BASIC_URL = ["http://localhost:8080"]
=======
>>>>>>> c8b8b084b4274a4ac949778bdc28d467cc13cd75

@Injectable({
  providedIn: 'root'
})
export class AdminService {

<<<<<<< HEAD
  constructor(private http:HttpClient) { }

  postCar(carDto : any): Observable<any>{
    return this.http.post(BASIC_URL + '/api/admin/car', carDto, {
      headers: this.createAuthorizationHeader()
    });
  }

  deleteCar(id : number): Observable<any>{
    return this.http.delete(BASIC_URL + "/api/admin/car/" + id ,{
    headers : this.createAuthorizationHeader()
  });
  }

  getCarById(id : number): Observable<any>{
    return this.http.get(BASIC_URL + "/api/admin/car/" + id ,{
      headers : this.createAuthorizationHeader()
    });
  }

  createAuthorizationHeader() : HttpHeaders{
    let authHeaders : HttpHeaders = new HttpHeaders();
    return authHeaders.set(
      'Authorization', 
      'Bearer ' + StorageService.getToken()
    );
  }


=======
  constructor() { }
>>>>>>> c8b8b084b4274a4ac949778bdc28d467cc13cd75
}
