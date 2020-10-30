import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import { FarmerService } from 'src/app/farmer.service';
import { Item } from '../../item';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {

  customerLoginForm: FormGroup;

  customerEmail: string; 
  customerPassword: string;
  

  constructor(private formBuilder: FormBuilder, public custService: CustomerService, public farmerService: FarmerService, private router:Router) {
   }

  ngOnInit(): void {
    this.customerLoginForm = this.formBuilder.group({
      customerEmail: ['', Validators.required],
      customerPassword: ['', Validators.required]
  });
  }

  onSubmit(){
    
  }

   customerLogin(customerEmail: string, customerPassword: string){
    this.custService.getCustomerLogin(customerEmail, customerPassword).then(()=>{
      this.router.navigate(['/customer/profile']);
    });
  }

}