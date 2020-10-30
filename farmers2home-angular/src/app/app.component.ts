import { Component } from '@angular/core';
import { from } from 'rxjs';
import { CustomerService } from './customer.service';
import { FarmerService } from './farmer.service';
import { PaymentService} from './payment/payment.service';



@Component({
  selector: 'app-root',
  // templateUrl: './app.component.html'
  template: `
  <router-outlet></router-outlet> 
  `,
  styles: []
 
})
export class AppComponent {
  title = 'farmers2home-angular';

  themeMode: boolean;

  constructor(public custService:CustomerService, public farmerService:FarmerService, public paymentService: PaymentService) {
    this.farmerService.isLoggedIn=farmerService.checkIsLoggedIn(); 
    this.custService.isLoggedIn = custService.checkIsLoggedIn();
   
  
   

    if(localStorage.getItem('themeMode')){
      this.themeMode = JSON.parse(localStorage.getItem('themeMode'));
    }else{
      this.themeMode = true;
    }
    
  }

  toggleTheme(){
      this.themeMode = !this.themeMode;
      localStorage.setItem('themeMode', JSON.stringify(this.themeMode));
  }
}
