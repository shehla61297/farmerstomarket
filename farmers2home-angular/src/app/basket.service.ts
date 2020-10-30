import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Basket } from './basket';
import { BasketItems } from './basketItems';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class BasketService {

  rootURL:string

  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:7777/farmertomarket/"

}
getBasket():Observable<Basket[]>{
  return this.httpsvc.get<Basket[]>
  (this.rootURL+"/basket/list")
}
getItems(basketID:number):Observable<BasketItems[]>{
  return this.httpsvc.get<BasketItems[]>(this.rootURL + "item/list" )
}

addItemToBasket(basketID:number, itemID: number):Observable<Item[]> {
  const httpOpts ={
    headers: new HttpHeaders(
      {'Content-Type':
       'application/x-www-form-urlencoded;charset=UTF-8'})
  }
  var reqBody = "basketID=" + basketID + "&itemID=" + itemID

  return this.httpsvc.post<Item[]>(
    this.rootURL + "basketItems/register", reqBody, httpOpts
  )
}
}
// getBasketItem():Observable<BasketItems[]>{
//   return this.httpsvc.get<Basket[]>
//    return this.httpsvc.get<BasketItems[]>(this.rootURL + "basketItems"+basketId)
//    (this.rootURL+"/basket/basketItems/")
 
// }
// }