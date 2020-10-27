
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Payment } from 'src/app/payment';
import { PaymentService } from '../payment.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment-checkout',
  templateUrl: './payment-checkout.component.html',
  styleUrls: ['./payment-checkout.component.css']
})
export class PaymentCheckoutComponent implements OnInit {

  paymentRegisterForm: FormGroup;

  constructor(private formBuilder:FormBuilder, private paymentService:PaymentService, private router:Router) { }

  addNewPayment(newPayment:Payment){
    this.paymentService.addNewPayment(newPayment);
  }

  ngOnInit(): void {
    this.paymentRegisterForm = this.formBuilder.group({
      paymentFirstName: ['', Validators.required],
      paymentLastName: ['', Validators.required],
      paymentEmail: ['', Validators.required],
      paymentAddress: ['', Validators.required],
      paymentCity: ['', Validators.required],
      paymentCounty: ['', Validators.required],
      paymentPostCode: ['', Validators.required],
      paymentCardName: ['', Validators.required],
      paymentCardNumber: ['', Validators.required],
      paymentExpMonth: ['', Validators.required],
      paymentExpiryYear: ['', Validators.required],
      paymentShippingMethod: ['', Validators.required],
      paymentCVV: ['', Validators.required]
    })
  }

  onSubmit(newPayment){
    this.addNewPayment(newPayment)
  }

}