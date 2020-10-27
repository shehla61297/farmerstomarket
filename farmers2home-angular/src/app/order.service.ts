import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { orderProducts } from './orderProducts';
import { Order } from './order'
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { OrderItems } from './orderItems';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  rootURL:string
  
  constructor(private httpsvc:HttpClient) {
    this.rootURL="http://localhost:7777/farmertomarket"
}

getOrder():Observable<Order[]>{
  return this.httpsvc.get<Order[]>
  (this.rootURL+"/orders/list")

}

getProducts(productId:number):Observable<orderProducts[]>{
  return this.httpsvc.get<orderProducts[]>(this.rootURL+"/products/orderItem/register")
}

getOrderItems(orderId:number):Observable<OrderItems[]>{
  return this.httpsvc.get<OrderItems[]>(this.rootURL+"/orderItems/list")
}
addOrderItemToOrder(orderId: number, orderItemsId:number):Observable<OrderItems[]>{
  const httpOpts ={
    headers: new HttpHeaders(
      {'Content-Type':
      'application/x-www-form-urlencoded;charset=UTF-8'})
 }
 var reqBody = "orderId"+orderId+"&orderItemsId="+orderItemsId
    return this.httpsvc.post<OrderItems[]>(
      this.rootURL+"orders/orderItems/register", reqBody, httpOpts
    )
    }
    // getorderItemsFromOrder(orderId:number):Observable<OrderItems[]>{
    //   return this.httpsvc.get<OrderItems[]>(this.rootURL"/"/)
    // }}
  
  getCustomerOrders(customerId: number):Observable<Customer[]>{
    return this.httpsvc.get<Customer[]>(this.rootURL+"/orders/customer")
    console.log(JSON.stringify(this.getOrder))}


  }
