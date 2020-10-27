import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerLoginComponent } from './customer/customer-login/customer-login.component';
import { CustomerProfileComponent } from './customer/customer-profile/customer-profile.component';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { CustomerComponent } from './customer/customer.component';
import { FarmerComponent } from './farmer/farmer.component';
import { FarmerProfileComponent } from './farmer/farmer-profile/farmer-profile.component';
import { FarmerRegisterComponent } from './farmer/farmer-register/farmer-register.component';
import { FarmerLoginComponent } from './farmer/farmer-login/farmer-login.component';
import { PaymentComponent} from './payment/payment.component';
import { PaymentCheckoutComponent} from './payment/payment-checkout/payment-checkout.component';
import { ContinueToCheckoutComponent} from './payment/continue-to-checkout/continue-to-checkout.component';
import { from } from 'rxjs';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { ProductComponent } from './product/product.component';
import { OrderComponent } from './order/order.component';
import { compileComponentFromMetadata } from '@angular/compiler';
import { AboutUsComponent } from './about-us/about-us.component';
import { OrderItemsComponent } from './order-items/order-items.component';
import { BasketComponent } from './basket/basket.component';
import { ItemComponent } from './item/item.component';


const routes: Routes = [
  { path: 'product', component: ProductComponent},
  {path: 'about-us', component: AboutUsComponent},
  {path: 'order-items', component:OrderItemsComponent},
  
  { path: 'customer', component: CustomerComponent,
  children: [
    {
      path: 'profile',
      component: CustomerProfileComponent,
    },
    {
      path: 'register',
      component: CustomerRegisterComponent,
    },
    {
      path: 'login',
      component: CustomerLoginComponent,
    }]
   },
   { path: 'farmers', component: FarmerComponent,
   children: [
     {
       path: 'profile',
       component: FarmerProfileComponent,
     },
     {
       path: 'register',
       component: FarmerRegisterComponent,
     },
     {
       path: 'login',
       component: FarmerLoginComponent,
     }]
    },
  {
      path: 'payment-checkout',
      component: PaymentCheckoutComponent,
    },
    {
    path: 'continue-to-checkout',
    component: ContinueToCheckoutComponent,
    },
  
  {path: 'contact-us',
    component: ContactUsComponent},
    
  {path: 'order', component: OrderComponent},
  
  {path:'basket', component:BasketComponent},
  {path:'item', component:ItemComponent}
 
  
]
  


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

