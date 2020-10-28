import { Component, OnInit } from '@angular/core';
import { Farmer } from '../farmer';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { FarmerService } from '../farmer.service';
import { FarmerProducts } from '../farmerProducts';

@Component({
  selector: 'app-farmer',
  templateUrl: './farmer.component.html',
  styleUrls: ['./farmer.component.css']
})
export class FarmerComponent implements OnInit {

  Farmers:Farmer[]
  Products:Product[]
  productId: number
  farmerProducts:FarmerProducts[]
  farmerID:number


  constructor( private farmerService:FarmerService, private productService:ProductService) { 
    this.Products=[]
    this.Farmers=[]
    this.farmerProducts=[]
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
