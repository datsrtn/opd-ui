
// src/app/order/order.component.ts
import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../services/medicine.service';
import { MedicineDTO, MedicineWrapper } from '../model/medicine.model';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {



  medicines: string[] = [];  // Make sure this is populated
  medicineToMedicineTypesMap: {[key:string]:string[]  } = { };
  medicineMedicineTypeToCompaniesMap: {[key:string]:string[]  } = { };
  medicineLocationsMap : {[key:string]:string[]} = {};
  medicineTotalPrice :  {[key:string]: number} = {};
  medicineTotalQuantity: {[key:string]: number} ={}
  orderForm!: FormGroup;
  currentSelectedMedicine : string;
  formStatus: string = '';
  formdata: any = {};

  constructor(private medicineService: MedicineService, private fb: FormBuilder) {  }

  ngOnInit() {
    this.medicines = this.medicineService.getMedicines('') ; // Fetch all medicines when component loads
    this.orderForm = this.fb.group({
      firstName: new FormControl('OPD', [ ]),
      lastName: new FormControl('last name', []),
      email: new FormControl('', []),
      dateOfPurchase: new FormControl(new Date()),
        orderItems: this.fb.array([])
      });
      (<FormArray>this.orderForm.get('orderItems'))
      .push(this.createOrderItem());
  
    this.currentSelectedMedicine =  this.medicines[0];
    }

    onMedicineChange(index: number,selMed: any) {
      this.currentSelectedMedicine = selMed.value;
      this.orderItems.at(index).patchValue({
        selectedMedicine: selMed.value,
      });
    
      this.medicineToMedicineTypesMap[selMed.value] = this.medicineService.getTypesOfMedicine(selMed.value);
    }
   


  onMedicineTypeChange(index: number, medicineType: any): void {
       this.orderItems.at(index).patchValue({
      selectedMedicineType: medicineType.value,
    });
    let currentMedicine =  this.orderItems.at(index).get ("selectedMedicine").value;
    let currentType = this.orderItems.at(index).get ("selectedMedicineType").value;
    
    const mapKey = currentMedicine + '|' + currentType;

    this.medicineMedicineTypeToCompaniesMap[mapKey] = this.medicineService.getCompaniesForMedicine(mapKey);
  }

  onCompanyChange(index: number, selectedCompany: any): string[] {
  
       this.orderItems.at(index).patchValue({
      selectedCompany: selectedCompany.value
      });
      let currentMedicine =  this.orderItems.at(index).get ("selectedMedicine").value;
      let currentType = this.orderItems.at(index).get ("selectedMedicineType").value;
      const mapKey = currentMedicine + '|' + currentType + '|' + selectedCompany.value;

      this.medicineLocationsMap[mapKey] = this.medicineService.getLocationsForCompany(mapKey);
    return [];
  }
  onQuantityChange(index: number,selectedQuantity: any) {
    this.orderItems.at(index).patchValue({
      selectedQuantity: selectedQuantity.value
      });

      let currentMedicine =  this.orderItems.at(index).get ("selectedMedicine").value;
      let currentType = this.orderItems.at(index).get ("selectedMedicineType").value;
      const currentCompany = this.orderItems.at(index).get ("selectedCompany").value;
      const mapKey = currentMedicine + '|' + currentType + '|' + currentCompany;

      let price = selectedQuantity.value *  this.medicineService.getperUnitPrice(mapKey);


      this.orderItems.at(index).patchValue({
        totalPrice:price
        });
    }
    
 


  // Get the FormArray from the form
  get orderItems(): FormArray {
    return this.orderForm.get('orderItems') as FormArray;
  }

  createOrderItem(): FormGroup { 
    const formGroup = new FormGroup({
      selectedMedicine: new FormControl (''),
      selectedMedicineType: new FormControl (''),
      selectedCompany: new FormControl (''),
      selectedLocation: new FormControl (''),
      quantity:new FormControl (0, [Validators.required, Validators.min(1)]),
      totalPrice:new FormControl (0) // Disabled until a rack is selected
    });
    return formGroup;
  }
  addOrderItem(): void {

    (<FormArray>this.orderForm.get('orderItems'))
    .push(this.createOrderItem());

    
  }

  removeOrderItem(index: number) {
    this.orderItems.removeAt(index);
  }

  // Submit the form data
  onOrderSubmit(): void {

    
    if (this.orderForm.valid) {
      console.log('Order Submitted:', this.orderForm.value);
    } else {
      console.log('Form is invalid');
    }
  }



  getMedicineTypesByKey(key: string): String[] {
    return this.medicineToMedicineTypesMap[key] || [];
  }

    getLocations(index : number): string[] {

      let currentMedicine =  this.orderItems.at(index).get ("selectedMedicine").value;
      let currentType = this.orderItems.at(index).get ("selectedMedicineType").value;
      let currentCompany = this.orderItems.at(index).get ("selectedCompany").value;
      const mapKey = currentMedicine + '|' + currentType + '|' + currentCompany;
      return this.medicineLocationsMap[mapKey] || [];

    }
      getCompanies(index :  number) : string[] {
      let currentMedicine =  this.orderItems.at(index).get ("selectedMedicine").value;
      let currentType = this.orderItems.at(index).get ("selectedMedicineType").value;
      
      const mapKey = currentMedicine + '|' + currentType;
      return this.medicineMedicineTypeToCompaniesMap[mapKey] || [];
  
    }

    OnFormSubmitted() {
      throw new Error('Method not implemented.');
      }
      

}
