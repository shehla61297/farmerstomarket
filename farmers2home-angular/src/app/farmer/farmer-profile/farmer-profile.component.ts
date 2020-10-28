import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../product.service';
import { Farmer } from '../../farmer';
import { Product } from '../../product';
import { FarmerService } from 'src/app/farmer.service';
import { ItemService } from 'src/app/item.service';
import { BasketService } from 'src/app/basket.service';
import { Item } from 'src/app/item';
import { Order } from 'src/app/Order';
import { orderProducts } from 'src/app/orderProducts';
import { Basket } from 'src/app/basket';
import { BasketProduct } from 'src/app/basketProducts';

@Component({
  selector: 'app-farmer-profile',
  templateUrl: './farmer-profile.component.html',
  styleUrls: ['./farmer-profile.component.css']
})
export class FarmerProfileComponent implements OnInit {


  Farmers:Farmer[]
  Products:Product[]
  productId: number
  farmerID:number
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
  basketProducts: BasketProduct[]
  itemService: any;

  constructor( private farmerService:FarmerService, private productService:ProductService, itemService:ItemService, basketService:BasketService, private router:Router) { 
    this.Products=[]
    this.Farmers=[]
    this.farmerProducts=[]
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
  }
  addProduct(newProduct:Product){
    this.farmerService.addProduct(newProduct).subscribe(
      res=>{
        newProduct = res
        this.farmerService.addProductToFarmer(19, newProduct.productID).subscribe( 
        res =>{
          this.farmerService.getProducts().subscribe(
            res=> {this.Products=res }
          )
      })
      })
  }


  addProductToFarmer(farmerID:number, productID:number){
    this.productService.addProductToFarmer(farmerID, productID, ).subscribe(
      res=>{
        this.Products=res
        res => {this.Farmers =res}
      }
    )
  }
  addProductToBasket(ProductID:number, BasketID:number, newItem:Item){
    this.productService.addProductToBasket(BasketID, ProductID).subscribe(
  
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
    this.productService.findProductsByFarmerNo(this.currentFarmer.farmerID).subscribe(
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
      this.currentFarmer.farmerID,newProduct).subscribe(
        response =>{
          this.fetchFarmerProductsFromServer()
        }
      )

    this.isProductFormVisible=true
      }
  
  ngOnInit(): void {
  
    this.farmerService.getProducts().subscribe(
      res =>{ this.farmerProducts= res
        console.log(JSON.stringify(this.farmerProducts))} 
    )

  }

}
