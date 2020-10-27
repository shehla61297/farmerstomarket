import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../product.service';
import { Farmer } from '../../farmer';
import { Product } from '../../product';
import { FarmerProducts } from '../../farmerProducts';
import { FarmerService } from 'src/app/farmer.service';

@Component({
  selector: 'app-farmer-profile',
  templateUrl: './farmer-profile.component.html',
  styleUrls: ['./farmer-profile.component.css']
})
export class FarmerProfileComponent implements OnInit {


  Farmers:Farmer[]
  Products:Product[]
  productId: number
  farmerProducts:FarmerProducts[]
  farmerID:number

  constructor( private farmerService:FarmerService, private productService:ProductService, private router:Router) { 
    this.Products=[]
    this.Farmers=[]
    this.farmerProducts=[]
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
  ngOnInit(): void {
  
    this.farmerService.getProducts().subscribe(
      res =>{ this.farmerProducts= res
        console.log(JSON.stringify(this.farmerProducts))} 
    )

  }

}
