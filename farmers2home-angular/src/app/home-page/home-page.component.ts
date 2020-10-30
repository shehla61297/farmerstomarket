import { Component, OnInit } from '@angular/core';
import { BasketService } from '../basket.service';
import { CustomerService } from '../customer.service';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor( public custService: CustomerService, public customerService: CustomerService, public farmerService: FarmerService, basketService:BasketService) { }

  ngOnInit(): void {
  }

}
