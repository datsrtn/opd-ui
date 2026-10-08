// src/app/medicine-search/medicine-search.component.ts
import { Component, EventEmitter, Output } from '@angular/core';
import { MedicineService } from '../services/medicine.service';
import { MedicineDTO, MedicineWrapper } from '../model/medicine.model';


@Component({
  selector: 'app-medicine-search',
  templateUrl: './medicine-search.component.html',
  styleUrls: ['./medicine-search.component.css']
})
export class MedicineSearchComponent {
  searchQuery: string = '';
  medicines: String[] = [];
  selectedMedicine: String | null = null;
  selectedCompany: string = '';
  selectedLocation: string = '';
  quantity: number = 1;

  @Output() medicineSelected = new EventEmitter<any>();

  constructor(private medicineService: MedicineService) {}

 


  onCompanyChange(company: string): void {
    this.selectedCompany = company;
   // this.updateLocation();
  }

  

  // updateLocation(): void {
  //   if (this.selectedMedicine) {
  //     const availableLocations = this.selectedMedicine.locations.filter(
  //       loc => loc.rack === this.selectedLocation && loc.expiryDate > new Date()
  //     );
  //     if (availableLocations.length > 0) {
  //       this.selectedLocation = availableLocations[0].rack;
  //       this.updatePrice();
  //     }
  //   }
  // }


}
