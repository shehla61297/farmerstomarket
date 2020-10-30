import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import { FarmerService } from 'src/app/farmer.service';

@Component({
  selector: 'app-farmer-login',
  templateUrl: './farmer-login.component.html',
  styleUrls: ['./farmer-login.component.css']
})
export class FarmerLoginComponent implements OnInit {
  farmerLoginForm: FormGroup;

  emailAddress: string;
  password: string;

  constructor(private formBuilder: FormBuilder,public farmerService: FarmerService, public custService: CustomerService, public customerService: CustomerService, private router:Router) {
   }

  ngOnInit(): void {
    this.farmerLoginForm=this.formBuilder.group({
      farmerEmail: ['', Validators.required],
      farmerPassword: ['',Validators.required]
    });
  }

  onSubmit(){

  }

  farmerLogin(email:string, password:string){
    this.farmerService.getFarmerLogin(email,password)

    this.router.navigate(['farmers/profile']);
  }

}
