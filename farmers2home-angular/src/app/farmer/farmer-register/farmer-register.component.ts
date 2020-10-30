import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, ValidatorFn, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/customer.service';
import { Farmer } from 'src/app/farmer';
import { FarmerService } from 'src/app/farmer.service';

@Component({
  selector: 'app-farmer-register',
  templateUrl: './farmer-register.component.html',
  styleUrls: ['./farmer-register.component.css']
})
export class FarmerRegisterComponent implements OnInit {

  farmerRegisterForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, public farmerService: FarmerService, public custService: CustomerService, public customerService:CustomerService, private router:Router) {

   }

   emailsMatchValidator(form :FormGroup){
     return
   }

   addNewFarmer(newFarmer: Farmer){
     this.farmerService.addNewFarmer(newFarmer);

     this.router.navigate(['farmers/login'])
   }

   emailCheck(email: string){
    this.farmerService.checkEmail(email);
   }

   EmailInUseValidator(form :FormGroup){
    return
  }

  ngOnInit(): void {
    this.farmerRegisterForm = this.formBuilder.group({
      farmerFirstName: ['', Validators.required],
      farmerLastName: ['', Validators.required],
      farmerEmail: ['', [Validators.required, Validators.email]],
      farmerPassword: ['', Validators.required],
      farmerLocation: ['', Validators.required],
      farmerContact: ['', Validators.required],
      confirm:['',[Validators.required, Validators.email]]
    }, {
      validator: (form:FormGroup) => {return form.get('farmerEmail').value !==
      form.get('confirm').value ? { emailMismatch: true } : null}
    }
    );
  }

  // convenience getter for easy access to form fields
  get f(){ return this.farmerRegisterForm.controls; }
  get isEmailMismatch(){return this.farmerRegisterForm.getError('emailMismatch')}
  get isEmailInUse(){return this.farmerRegisterForm.getError('duplicateEmail')}

  onSubmit(newFarmer){
    this.submitted = true;
    
    if(this.farmerRegisterForm.invalid) {
      return;
    } else{
      console.log(JSON.stringify(this.farmerRegisterForm.value));
      this.addNewFarmer(newFarmer);
    }
  }

}
