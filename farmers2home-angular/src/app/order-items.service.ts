import { Injectable } from '@angular/core';
import { OrderItems } from './orderItems';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderItemsService {

  rootURL:string

 constructor( private httpsvc:HttpClient) {
    this.rootURL="http://localhost:8080/farmers2home"
 }

   getOrderItems():Observable<OrderItems[]>{
   return this.httpsvc.get<OrderItems[]>
   (this.rootURL+"/orderItems/list")
   }
   }
  
//    addOrderItems(newOrderItems: OrderItems):Observable<OrderItems[]>{
//     headers: new HttpHeaders(
//       {'Content-Type':
//     'application/x-www-form-urlencoded;charset=UTF-8'})
//    }}

//    var reqBody =
//    "orderItemName="+newOrderItems.orderItemName+"&orderItemPrice"+newOrderItems.orderItemPrice+"&orderItemQuantit"+newOrderItems.orderItemQuantity
//    return this.httpsvc.post<OrderItems>(
//      this.rootURL+"/orderItems/register", reqBody, httpOpts)
// }}
