import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { FarmerService } from '../farmer.service';
import { Order } from '../Order';
import { OrderService } from '../order.service';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { orderProducts } from '../orderProducts';
import { Item } from '../item';
import { ItemService } from '../item.service';
import { CustomerService } from '../customer.service';
import { Basket } from '../basket';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  currentFarmer: Farmer
  farmerProducts: Product[]
  isFarmerEditing: boolean
  isProductFormVisible: boolean
  currentProduct: Product;
  products: Product[]
  orders: Order[]
  newProduct: Product[]
  orderProducts: orderProducts[]
  items: Item[]
  customerProduct: Product[]
  currentBasket: Basket[]
  basketService: any;
  newItems : Item[]

  constructor(private productService:ProductService, private farmerService:FarmerService, private custService: CustomerService, private orderService: OrderService, private itemService: ItemService, private router:Router) {
    this.isProductFormVisible=false

    this.currentProduct=
    {
      productID: 216,
      farmerID:9,
      productName:"Milk",
      productDescription:"Semi-Skimmed",
      productType:"DAIRY",
      productPrice:1,
      productQuantity:18,
      productWeightKG:1
    }

    this.farmerProducts=
    [
      {productID:1,
      farmerID:9,
      productName:"Milk",
      productDescription:"Semi-Skimmed",
      productType:"DAIRY",
      productPrice:1,
      productQuantity:18,
      productWeightKG: 1

    }
    ]
    this.products=[]
  
  this.currentBasket=[]
  this.newItems=[]

  // addProductsToOrder(productId:number, orderId:number, newProduct:Product){
  //   this.productService.addNewProduct(newProduct).subscribe(
  //     res => 
  //     { newProduct = res
  //     this.productService.addProductToOrder(orderId, newProduct.productId).subscribe(
  //       res => {
  //         this.products = res
  //       }
  //     )}
  //   )
  // }
  }
  addProductToBasket(ProductID:number, BasketID:number, newItem:Item){
    this.custService.addProductToBasket(BasketID, ProductID).subscribe(
  
      res =>{
        this.customerProduct = res
          res => {this.currentBasket=res}
      }
    )
  
  
  this.itemService.addItem(newItem).subscribe(
    res => 
    { newItem = res
      this.basketService.addItemToBasket(BasketID, newItem.itemID).subscribe(
      res  => {
        this.itemService.addItemToProduct(ProductID, newItem.itemID ).subscribe(
          res =>
          {this.items = res}
        )
      }
      )
    })}
  fetchFarmerProductsFromServer(){
    this.productService.findProductsByFarmerNo(this.currentFarmer.farmerId).subscribe(
      response => {
        this.farmerProducts = response
      }
    )
  }

  showProductForm(){
    this.isProductFormVisible=true
  }

  addNewProduct(newProduct:Product){
    this.productService.registerProductsForFarmer(
      this.currentFarmer.farmerId,newProduct).subscribe(
        response =>{
          this.fetchFarmerProductsFromServer()
        }
      )

    this.isProductFormVisible=true
      }
  
  // this.itemService.addItemToBasket(Item).subscribe(
  //   res => 
  //   { newItems = res
  //     this.basketService.addItemToBasket(BasketID, newItems.itemID).subscribe(
  //     res  => {
  //       this.itemService.addItemToProduct(ProductID, newItems.itemID ).subscribe(
  //         res =>
  //         {this.Items = res}
        // )
      // }
      // )
    // })}

  ngOnInit(): void {
 
this.productService.getProducts().subscribe(
  res => {this.products=res
    console.log(JSON.stringify(this.products))}

  
)}}

