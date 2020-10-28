import { Component, OnInit } from '@angular/core';
import { Basket } from '../basket';
import { BasketService } from '../basket.service';
import { BasketItems } from '../basketItems';
import { Item } from '../item';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit {

  baskets: Basket[];
  items: Item[];
  basketItems: BasketItems[];
  baskeID: number;
  itemID: number;
  itemName: string;
  itemPrice: number
  itemQuantity: number;
  totalPrice: number;
  newBasket: Basket[];


  constructor(private basketService: BasketService, private itemService: ItemService) { 
    this.baskets=[]
    this.items=[]
    this.basketItems=[]
  }
  addItemToBasket(basketID:number, itemID: number) {
    this.itemService.addItemToBasket(basketID, itemID,  ).subscribe(
      res=> {
        this.items = res
        res => {this.baskets = res}
      }
    )
  }
  calculateTotalPrice(basketItems: BasketItems) {
    return basketItems.itemPrice * basketItems.selectedQuantity
  }
  calculateBasketPrice(BasketItems: BasketItems[]) {
    this.totalPrice = 0
    this.basketItems.forEach(element => {
      this.totalPrice += this.calculateTotalPrice(element)
    })
    return this.totalPrice
    ;
  }
  // removeItemFromBasket(index:number){
  //   this.itemService.deleteItem(index).subscribe(
  //     res => {
  //       this.basketService.getItemsFromBasket(this.basketId).subscribe(
  //         res => {this.items = res}
  //       )
  //     }
  //   )
  // }

  ngOnInit(): void {
    this.basketService.getItems(this.baskeID).subscribe(
    res =>{this.basketItems=res 
    console.log(JSON.stringify(this.basketItems))} 
    
    )} 
}