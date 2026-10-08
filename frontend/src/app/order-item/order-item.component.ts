import { Component, Input } from '@angular/core';
import { OrderItem } from '../model/medicine.model';

@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrl: './order-item.component.css'
})
export class OrderItemComponent {
  @Input() orderItem!: OrderItem;  // This tells Angular that orderItem is an input property

  constructor() {}
}
