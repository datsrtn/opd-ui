// app.module.ts
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { OrderComponent } from './order/order.component';
import { MedicineSearchComponent } from './medicine-search/medicine-search.component';
import { OrderItemComponent } from './order-item/order-item.component';
import { MedicineService } from './services/medicine.service';

@NgModule({
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    FormsModule  
  ],
  declarations: [
    AppComponent,
    OrderComponent,
    MedicineSearchComponent,
    OrderItemComponent,
  ],
  providers: [MedicineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
