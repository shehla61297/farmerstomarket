import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { from } from 'rxjs';
import { Contact } from '../contact';
import { ContactService} from '../contact.service'
import { CustomerService } from '../customer.service';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  contactUsForm: FormGroup;
  contacts: Contact[]
   submitted = false
   contact:Contact[]
   newContact: Contact[]

//   name: string;
//   email: string;
//   message: string;

  constructor(private formBuilder: FormBuilder, private ContactService: ContactService,public custService: CustomerService, public farmerService: FarmerService, private router:Router) { 

    this.contact=[]
    this.newContact=[]
  
  }
  emailsMatchValidator(form :FormGroup){
    return
  }


  addContactDetails(newContact: Contact){
    this.ContactService.addContactDetails(newContact);
    this.router.navigate(['cotact-us']);
  }
  
   ngOnInit(): void {
    this.contactUsForm = this.formBuilder.group({
       name:['', Validators.required],
      email:['', [Validators.required, Validators.email]],
     message: ['', Validators.required],
     confirm: ['', [Validators.required, Validators.email]]
   },
   {
     validator: (form:FormGroup) => {return form.get('email').value !==
    form.get('confirm').value ? {emailMismatch: true} : null}
    }
   
   );
  }
   get f(){ return this.contactUsForm.controls; }
   get isEmailMismatch(){return this.contactUsForm.getError('emailMismatch')}

   onSubmit(newContact){
     this.submitted = true;


     if(this.contactUsForm.invalid){
       return;
     }
     else{
       console.log(JSON.stringify(this.contactUsForm.value));
       this.addContactDetails(newContact);
     }
   }
  
//  submitForm(contactName:string, contactEmail:string, contactMessage:string){
//   this.ContactService.addContact(newContact).subscribe(
//    res =>
//    { newContact =res
//       this.ContactService.submitForm(newContact.name, newContact.email, newContact.message).subscribe(
//         res => {
//           this.contact = res        })
//       })}}

}