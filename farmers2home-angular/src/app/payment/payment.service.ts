import { Injectable } from '@angular/core';
import { Farmer } from '../farmer';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Payment } from '../payment';


@Injectable({
    providedIn: 'root'
  })
export class PaymentService {
    rootURL: string;

  constructor(private httpsvc: HttpClient) {

    this.rootURL = "http://localhost:8080/farmers2home"
   }
   addNewPayment(newPayment: Payment){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('firstName', newPayment.firstName)
    params.set('lastName', newPayment.lastName)
    params.set('email', newPayment.email)
    params.set('address', newPayment.address)
    params.set('city', newPayment.city)
    params.set('county', newPayment.county)
    params.set('postCode', newPayment.postCode)
    params.set('nameOnCard', newPayment.nameOnCard)
    params.set('CardNumber', newPayment.cardNumber)
    params.set('expiryMonth', newPayment.expiryMonth)
    params.set('expiryYear', newPayment.expiryYear)
    params.set('cvv', newPayment.cvv)
    params.set('shippingMethod', newPayment.shippingMethod)
  


    return this.httpsvc.post<Farmer>(this.rootURL+"/payment/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );   
   }
  
}




