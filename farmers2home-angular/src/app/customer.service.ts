import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Checkout } from './checkout';
import { Customer } from './customer';
import { Order } from './Order';
import { Product } from './product';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  rootURL: string;
  isLoggedIn:boolean;
  currentUser: Customer;

  constructor(private httpsvc:HttpClient) { 
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));

    this.rootURL = "http://localhost:7777/farmertomarket/"
  }

  addNewCustomer(newCustomer: Customer){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    
    const params = new URLSearchParams();
    params.set('customerEmail', newCustomer.customerEmail)
    params.set('customerForename', newCustomer.customerForename)
    params.set('customerSurname', newCustomer.customerSurname)
    params.set('customerAddress', newCustomer.customerAddress)
    params.set('customerDOB', newCustomer.customerDOB)
    params.set('customerUsername', newCustomer.customerUsername)
    params.set('customerPassword', newCustomer.customerPassword)

    return this.httpsvc.post<Customer>(this.rootURL+"customer/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );
  }

  async getCustomerLogin(customerEmail: string, customerPassword: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('customerEmail', customerEmail)
    params.set('pass', customerPassword)

    const result = await this.httpsvc.post<Customer>(this.rootURL+"customer/login", params.toString(), httpOpts).toPromise();
    if(result){
      this.currentUser = result;
      localStorage.setItem('currentUser', JSON.stringify(result));
      this.isLoggedIn= true;
      }
      return result;
  }
  addProductToBasket(basketID:number,productID: number):Observable<Product[]>{
    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
      }

      var reqBody = "basketID="+basketID+"&productID="+productID

      return this.httpsvc.post<Product[]>(
        this.rootURL+"basket/basketProducts", reqBody, httpOpts
      )
  }

  getCustomerCheckouts():Observable<Checkout[]>{
    return this.httpsvc.get<Checkout[]>(this.rootURL+"checkout/customer/"+this.currentUser.customerID);

   
  }

  customerLogout(){
    localStorage.removeItem("currentUser");
    this.isLoggedIn = false;
  }

  checkIsLoggedIn(){
    if(localStorage.getItem("currentUser")){
      return true;
    }else{
      return false;
    }
  }

}