import { Component, OnInit } from '@angular/core';
import { Order } from '../Order';
import { OrderItemsService } from '../order-items.service';
import { OrderItems } from '../orderItems';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-items',
  templateUrl: './order-items.component.html',
  styleUrls: ['./order-items.component.css']
})
export class OrderItemsComponent implements OnInit {

  orderItems: OrderItems[]
  newOrderItems: OrderItems[]

  constructor(private orderItemsService: OrderItemsService, private router:Router) {
    this.orderItems=[]
    this.newOrderItems=[]
   }

  

  ngOnInit(): void {
    this.orderItemsService.getOrderItems().subscribe(
      res =>{this.orderItems=res
      console.log(JSON.stringify(this.orderItems))}
    

  
    )}
}
