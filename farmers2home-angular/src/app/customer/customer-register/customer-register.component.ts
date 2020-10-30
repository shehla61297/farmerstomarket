import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/customer.service';
import { FarmerService } from 'src/app/farmer.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {
  customerRegisterForm: FormGroup;
  submitted = false;

//   constructor(private formBuilder: FormBuilder, private custService: CustomerService, private router:Router) {
 
//    }

//    addNewCustomer(newCustomer: Customer){
//      this.custService.addNewCustomer(newCustomer);

//      this.router.navigate(['/customer/login']);
//    }

//   ngOnInit(): void {
//     this.customerRegisterForm = this.formBuilder.group({
//       customeForename: ['', Validators.required],
//       customeSurname: ['', Validators.required],
//       customerEmail: ['', [Validators.required, Validators.email]],
//       customerPassword: ['', Validators.required],
//       customerAddress: ['', Validators.required],
//       customerDOB: ['', Validators.required],
//       customerUsername: ['', Validators.required],
//       confirm:['', [Validators.required, Validators.email]]
//   },{
//     validator: (form:FormGroup) => {return form.get('customerEmail').value !==
//     form.get('confirm').value ? { emailMismatch: true } : null}
//   }
//   );
//   }

//    // convenience getter for easy access to form fields
//    get f(){ return this.customerRegisterForm.controls; }
//    get isEmailMismatch(){return this.customerRegisterForm.getError('emailMismatch')}

//   onSubmit(newCustomer) {
//     this.submitted=true;

//     if(this.customerRegisterForm.invalid){
//       return
//     } else{
//       console.log(JSON.stringify(this.customerRegisterForm.value))
//       this.addNewCustomer(newCustomer);
//     }
//   }
  
  customers: Customer[]
  isValid:boolean
  isValidF:boolean
  errorMessage:String
  errorMessageF:String
  customerForename: string
  customerSurname: string
  customerAddress: string
  customerBalance: number
  customerDOB: string
  customerUsername: string
  customerPassword: string
  

  constructor(public customerService:CustomerService, public custService: CustomerService, public farmerService:FarmerService, private router:Router) {
    this.customers=[]
    this.isValid=true
    this.isValidF=true
   }

   registerNewCustomer(newCustomer:Customer){
     if(newCustomer.customerForename == ""){
       this.isValid=false;
       this.errorMessage = "Please enter a Firstname"
     } else if (newCustomer.customerSurname == ""){
       this.isValid = false;
       this.errorMessage = "Please enter a Surname"
     } else if (newCustomer.customerAddress == ""){
       this.isValid = false;
       this.errorMessage = "Please enter a valid address"
     } else if(newCustomer.customerDOB == ""){
       this.isValid = false;
       this.errorMessage ="Please enter a valid DOB"
     }else if (newCustomer.customerUsername == ""){
       this.isValid = false;
       this.errorMessage = "Please enter a valid username"
     }else if (newCustomer.customerPassword = ""){
       this.isValid = false;
       this.errorMessage = "Please enter a valid password"
     } else {
       this.customerService.registerNewCustomer(newCustomer)
       .subscribe(
         res =>{
           newCustomer = res
           console.log(JSON.stringify(res))
           this.customerService.getCustomer().subscribe(        
            res=> {this.customers = res}

                 )})
            
     this.router.navigate(["/customer/profile"]);
     }
    }
    ngOnInit() {
      this.customerService.getCustomer().subscribe(
        res =>{this.customers=res
        console.log(JSON.stringify(res))}
      )
  
    }
  }
  
