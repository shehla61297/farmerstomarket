import { Injectable } from '@angular/core';
import { Farmer } from './farmer';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class FarmerService {
  rootURL: string;
  rootProductURL:string
  isLoggedIn:boolean;
  currentFarmer:Farmer
  isEmailInUse:boolean

  constructor(public httpsvc:HttpClient) {
    this.currentFarmer = JSON.parse(localStorage.getItem("currentFarmer"));

    this.rootURL = "http://localhost:7777/farmertomarket"
    this.rootProductURL="http://localhost:7777/farmertomarket/product"

   }

   addNewFarmer(newFarmer: Farmer){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', newFarmer.email)
    params.set('password', newFarmer.password)
    params.set('farmerFirstName', newFarmer.farmerFirstName)
    params.set('farmerLastName', newFarmer.farmerLastName)
    params.set('location', newFarmer.location)
    params.set('contactNumber', newFarmer.contactNumber)

    return this.httpsvc.post<Farmer>(this.rootURL+"/farmer/register", params.toString(), httpOpts).subscribe(
      (res) => console.log(res),
      (err) => console.log(err)
    );   
   }

   checkEmail(email: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)

    return this.httpsvc.post<boolean>(this.rootURL+"/farmer/emailcheck", params.toString(), httpOpts).subscribe(
      Response => {
        this.isEmailInUse = Response; 
        }
    )
   }
   getProducts():Observable<Product[]>{
    return this.httpsvc.get<Product[]>(this.rootURL+"/product/list")
  }
  addProductToFarmer(farmerID:number, productID:number):Observable<Product[]>{
    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
      'application/x-www-form-urlencoded;charset=UTF-8'}
      )
    }
    var reqBody = "farmerID=" + farmerID + "&productID=" + productID

    return this.httpsvc.post<Product[]>(
      this.rootURL + "/farmer_to_product_assignment/", reqBody, httpOpts)
  }




   getFarmerLogin(email: string, password: string){
    const httpOpts = {
      headers: new HttpHeaders({"Content-Type":"application/x-www-form-urlencoded"})
    }
    const params = new URLSearchParams();
    params.set('email', email)
    params.set('password', password) 
    
    return this.httpsvc.post(this.rootURL+"/farmers/login", params.toString(), httpOpts).subscribe(
      (result:any) => {
        if(result){
        localStorage.setItem('currentFarmer', JSON.stringify(result));
        this.currentFarmer = result;
        this.isLoggedIn= true;    
        }
      }
    )
}
addProduct(newProduct:Product):Observable<Product>{
  const httpOpts ={
    headers: new HttpHeaders(
      {'Content-Type':
       'application/x-www-form-urlencoded;charset=UTF-8'})
  }

  var reqBody="productName="+newProduct.productName+"&productDescription="
  +newProduct.productDescription+"&productType="+newProduct.productType+"&productPrice="+newProduct.productPrice+"&productQuantity="+newProduct.productQuantity+"&productWeightKG"+newProduct.productWeightKG

  return this.httpsvc.post<Product>(
    this.rootProductURL+"/add",reqBody,httpOpts)
  
  }

farmerLogout(){
  localStorage.removeItem("currentFarmer");
  this.isLoggedIn = false;
}

checkIsLoggedIn(){
  if(localStorage.getItem("currentFarmer")){
    return true;
  }else{
    return false;
  }
  
}
}
