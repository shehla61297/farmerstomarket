import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { FarmerService } from '../farmer.service';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {

  constructor(public custService: CustomerService, public farmerService: FarmerService) { }

  ngOnInit(): void {
  }

}
