import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  medicineForm!: FormGroup;

 medicines = [
    { name: 'Paracetamol', companies: ['Company A', 'Company B'] },
    { name: 'Ibuprofen', companies: ['Company C', 'Company D'] }
  ];

  companyData : Record<string, any>= {
    'Company A': { types: ['Tablet', 'Liquid'], locations: ['Rack 1', 'Rack 2'], expiryDates: ['2024-12-01', '2025-06-15'] },
    'Company B': { types: ['Tablet'], locations: ['Rack 3'], expiryDates: ['2023-08-21', '2024-01-11'] },
    'Company C': { types: ['Capsule', 'Liquid'], locations: ['Rack 4'], expiryDates: ['2025-02-10', '2026-03-25'] },
    'Company D': { types: ['Liquid'], locations: ['Rack 5', 'Rack 6'], expiryDates: ['2024-04-19', '2025-09-07'] }
  };

  companies: string[] = [];
  types: string[] = [];
  locations: string[] = [];
  expiryDates: string[] = [];

  constructor(private fb: FormBuilder) {
    this.medicineForm = this.fb.group({
      medicines: this.fb.array([this.createMedicineGroup()])
    });
  }
  // Function to create a new FormGroup for a medicine
  createMedicineGroup(): FormGroup {
    return this.fb.group({
      medicineName: [{ value: '', disabled: false }],
      companyName: [{ value: '', disabled: false }],
      medicineType: [{ value: '', disabled: false }],
      storageLocation: [{ value: '', disabled: false }],
      expiryDate: [{ value: '', disabled: false }]
    });
  }
  ngOnInit() {
    this.medicineForm = this.fb.group({
      medicineName: [{ value: '', disabled: false }],
      companyName: [{ value: '', disabled: false }],
      medicineType:[{ value: '', disabled: false }],
      storageLocation:[{ value: '', disabled: false }],
      expiryDate: [{ value: '', disabled: false }]
    });

     // Listen for changes in the 'medicineName' field
     this.medicineForm.get('medicineName')?.valueChanges.subscribe(selectedMedicine => {
      this.onMedicineChange(selectedMedicine);
    });

        // Listen for changes in the 'companyName' field
        this.medicineForm.get('companyName')?.valueChanges.subscribe(selectedCompany => {
          this.onCompanyChange(selectedCompany);
        });
        
  }   
    // Add new row for entering medicine
 
  onCompanyChange(selectedCompany: string) {
    const companyDetails = this.companyData[selectedCompany];
    if (companyDetails) {
      this.types = companyDetails.types;
      this.locations = companyDetails.locations;
      this.expiryDates = companyDetails.expiryDates;
    } else {
      this.types = [];
      this.locations = [];
      this.expiryDates = [];
    }

    // Reset type, location, and expiry fields
    this.medicineForm.get('medicineType')?.setValue('');
    this.medicineForm.get('storageLocation')?.setValue('');
    this.medicineForm.get('expiryDate')?.setValue('');
  }
  onMedicineChange(selectedMedicine: any) {
    const selectedMed = this.medicines.find(med => med.name === selectedMedicine);
    if (selectedMed) {
      this.companies = selectedMed.companies;
    } else {
      this.companies = [];
    }

        // Reset related fields
        this.medicineForm.get('companyName')?.setValue('');
        this.types = [];
        this.locations = [];
        this.expiryDates = [];

  }
  title = 'opd-ui';
}
