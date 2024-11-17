import { Component } from '@angular/core';
import { CustomerService } from '../../service/customer.service';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';
import { StorageService } from '../../../../auth/services/storage/storage.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
import { error } from 'console';

@Component({
  selector: 'app-book-car',
  standalone: true,
  imports: [],
  templateUrl: './book-car.component.html',
  styleUrl: './book-car.component.css'
})
export class BookCarComponent {
  carId: number = this.activatedRoute.snapshot.params['id'];
  car: any;
  processedImage: any;  
  validateForm: FormGroup | undefined; 
  isSpinning: boolean = false;
  dateformat: string = 'mm/dd/yyyy';
  storageService: any;
  
  constructor(private service1: CustomerService, private activatedRoute: ActivatedRoute, private fb: FormBuilder, private message: NzMessageService, private router: Router) { }

  ngOnInit() {
    this.getCarById();
    this.validateForm = this.fb.group({
      
      toDaye: [null, Validators.required],
      fromDate: [null, Validators.required],
    });
  }
  getCarById(Id: number) {
    this.service1.getCarById(Id).subscribe((res) => {
      console.log(res);
      this.processedImage= 'data:image/jpeg;base64,' + res.returnedImage;
      this.car = res;
        });
  }

  bookACar(data: any) {
    console.log(data);
    this.isSpinning = true;
    let bookACarDto = {
      toDate: data.toDate,
      userId: this.storageService.getUserId(),
      userId: StorageService.getUserId(),
      CarId: this.carId
    }
    this.service1.bookACar(bookACarDto).subscribe((res) => {
      console.log(res);
      this.message.success('Car Booked Successfully');
      this.router.navigateByUrl('/customer/dashboard');
    },error => {
      this.isSpinning = false;
      this.message.error('Failed to book car', {nzDuration: 5000});
    });
  }

}