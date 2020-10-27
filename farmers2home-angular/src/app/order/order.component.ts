import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Order } from '../Order';
import { OrderItemsService } from '../order-items.service';
import { OrderService } from '../order.service';
import { OrderItems} from '../orderItems';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: Order[];
  orderItems: OrderItems[]
  orderId: number;
  orderItemId: number;
  orderItemName: string;
  orderItemPrice: number;
  orderItemQuantity: number;
  totalPrice:number;
  basketOrderItems: OrderItems[]

  constructor(private orderService: OrderService, private orderItemsService: OrderItemsService ) {
    this.orders=[]
    this.orderItems=[]
    this.basketOrderItems=[]
   }

  //  addorderItemToOrder(orderId: number, orderItemId:number){
  //    this.orderItemsService.addorderItemToOrder(orderId, orderItemId,).subscribe(
  //      res => {
  //        this.orderItems = res
  //        res => [this.orders = res]
  //      }
  //    )
  //  }
  ngOnInit(): void {

    this.orderService.getOrder().subscribe
    res => {this.basketOrderItems=res
    console.log(JSON.stringify(this.basketOrderItems))
    
    }
  }

}
