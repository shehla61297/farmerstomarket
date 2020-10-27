import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  rootURL:string
  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:7777/farmertomarket"
}

getItem():Observable<Item[]>{
  return this.httpsvc.get<Item[]>
  (this.rootURL+"/item/list")
}
  addItemToBasket(basketID:number,itemID: number):Observable<Item[]>{
    const httpOpts ={
      headers: new HttpHeaders(
        {'Content-Type':
        'application/x-www-form-urlencoded;charset=UTF-8'})
      }

      var reqBody = "basketID="+basketID+"&itemID="+itemID

      return this.httpsvc.post<Item[]>(
        this.rootURL+"basketItems/register", reqBody, httpOpts
      )
  }
  

 addItem(newItems: Item): Observable<Item> {
   const httpOpts = {
    headers: new HttpHeaders(
      {'Content-Type':
    'application/x-www-form-urlencoded;charset=UTF-8'})
   }
 var reqBody =
  "quantity=" + newItems.selectedQuantity + "&price=" + newItems.itemPrice

   return this.httpsvc.post<Item>(
    this.rootURL + "/register", reqBody, httpOpts)
  
 }
 addItemToProduct(productID: number, itemID: number) {
  const httpOpts ={
    headers: new HttpHeaders(
      {'Content-Type':
       'application/x-www-form-urlencoded;charset=UTF-8'})
  }
  var reqBody = "productID=" + productID + "&itemID=" + itemID

  return this.httpsvc.post<Item[]>(
    this.rootURL + "/productItem", reqBody, httpOpts
  )
}

}
