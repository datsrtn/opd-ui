// src/app/models/medicine.model.ts
export interface MedicineDTO {
    medicineType: string; // e.g., Tablet, Syrup
    companyName: string;
    expiryDate: Date;
    pricePerUnit: number;  
    locationName: string;
  }
  
  export interface MedicineWrapper {
    medicineName: string;
    details: MedicineDTO[];
  }

  export interface OrderItem {
    quantity: number;
    expiryDate: Date;
    price: number;
    total: number;
  }
  