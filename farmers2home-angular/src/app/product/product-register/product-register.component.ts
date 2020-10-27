import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from 'src/app/product.service';
import { Router } from '@angular/router';
import { Product } from 'src/app/product';

@Component({
  selector: 'app-product-register',
  templateUrl: './product-register.component.html',
  styleUrls: ['./product-register.component.css']
})
export class ProductRegisterComponent implements OnInit {

  ProductRegisterForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private productService: ProductService, private router:Router) {

   }

   addNewProduct(newProduct: Product){
     this.productService.addNewProduct(newProduct);

     this.router.navigate(['product/register'])
   }

  ngOnInit(): void {
    this.ProductRegisterForm = this.formBuilder.group({
      productName: ['', Validators.required],
      productDesc: ['', Validators.required],
      productCat: ['', Validators.required],
      productPrice: ['', Validators.required],
      stockQuantity: ['', Validators.required]
    })
  }

  onSubmit(){
    
  }

}
