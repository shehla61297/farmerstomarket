import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Basket } from 'src/app/basket';
import { BasketService } from 'src/app/basket.service';
import { Checkout } from 'src/app/checkout';
import { Customer } from 'src/app/customer';
import { CustomerService } from 'src/app/customer.service';
import { Farmer } from 'src/app/farmer';
import { Item } from 'src/app/item';
import { ItemService } from 'src/app/item.service';
import { Order } from 'src/app/Order';
import { Product } from 'src/app/product';
import { Transaction } from 'src/app/transaction';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {
  Items :Item[];
  transactions:Transaction[]
  checkouts: Checkout[]
  Baskets:Basket[]
  Products: Product[]
  Farmers: Farmer[]
  newItems: Item
  Customers: Customer[]
  customerProduct: Product[]

  headers = ["transactionID", "itemName", "transactionDate", "transactionAmount"]

  constructor(public custService:CustomerService, private itemService: ItemService, private basketService: BasketService, private router:Router) {
   
  this.Customers=[]
  this.Products=[]
  this.Baskets=[]
  this.Farmers=[]
  this.Items=[]
}

addProductToBasket(ProductID:number, BasketID:number, newItem:Item){
  this.custService.addProductToBasket(BasketID, ProductID).subscribe(

    res =>{
      this.customerProduct = res
        res => {this.Baskets=res}
    }
  )


this.itemService.addItem(newItem).subscribe(
  res => 
  { newItem = res
    this.basketService.addItemToBasket(BasketID, newItem.itemID).subscribe(
    res  => {
      this.itemService.addItemToProduct(ProductID, newItem.itemID ).subscribe(
        res =>
        {this.Items = res}
      )
    }
    )
  })}


  ngOnInit(): void {
    this.getCustomerCheckouts();
  }

 

  getCustomerCheckouts(){
    if(this.custService.isLoggedIn == true){
      return this.custService.getCustomerCheckouts().subscribe(res=>this.checkouts=res);
     
    }
    console.log(JSON.stringify(this.getCustomerCheckouts))}
  

  chechoutDetails(checkoutID:number){
    this.router.navigate(['/']);
  }

}
