 // src/app/services/medicine.service.ts
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MedicineDTO, MedicineWrapper } from '../model/medicine.model';


@Injectable({
  providedIn: 'root'
})
export class MedicineService {
  private allMedicines: MedicineWrapper []= 
  [
    {
      "medicineName":"Paracetamol",
      "details":[
        {
          "medicineType": "Tablet",
          "companyName": "company1",
          "expiryDate": new Date('2026-06-01'),
          "pricePerUnit": 10,
          "locationName": "rack1"
        },
        {
          "medicineType": "Tablet",
          "companyName": "company2",
          "expiryDate": new Date('2026-05-01'),
          "pricePerUnit": 30.0,
          "locationName": "bOX2"
    		},
        {
          "medicineType": "Tablet",
          "companyName": "company3",
          "expiryDate": new Date('2025-11-01'),
          "pricePerUnit": 60.0,
          "locationName": "BOX1"
		    },
				{
			    "medicineType": "liquid",
    			"companyName": "company1",
		    	"expiryDate": new Date('2025-12-01'),
			    "pricePerUnit": 20,
			    "locationName": "rack1"
		    },
		    {
          "medicineType": "liquid",
          "companyName": "company2",
          "expiryDate": new Date('2026-01-01'),
          "pricePerUnit": 40.0,
          "locationName": "rack1"
	    	},
		    {
			    "medicineType": "liquid",
			    "companyName": "company2",
			    "expiryDate": new Date('2027-03-01'),
			    "pricePerUnit": 50.0,
			    "locationName": "rack2"
		    }
      ]
    },
    {
      "medicineName":"ibuprofen",
      "details":[
        {
          "medicineType": "Tablet",
          "companyName": "c1",
          "expiryDate": new Date('2026-06-01'),
          "pricePerUnit": 10,
          "locationName": "rack1"
        },
        {
          "medicineType": "Tablet",
          "companyName": "c2",
          "expiryDate": new Date('2026-05-01'),
          "pricePerUnit": 30.0,
          "locationName": "bOX2"
    		},
        {
          "medicineType": "Tablet",
          "companyName": "c3",
          "expiryDate": new Date('2025-11-01'),
          "pricePerUnit": 60.0,
          "locationName": "BOX1"
		    },
				{
			    "medicineType": "liquid",
    			"companyName": "c1",
		    	"expiryDate": new Date('2025-12-01'),
			    "pricePerUnit": 20,
			    "locationName": "rack1"
		    },
		    {
          "medicineType": "liquid",
          "companyName": "c2",
          "expiryDate": new Date('2026-01-01'),
          "pricePerUnit": 40.0,
          "locationName": "rack1"
	    	},
		    {
			    "medicineType": "liquid",
			    "companyName": "c2",
			    "expiryDate": new Date('2027-03-01'),
			    "pricePerUnit": 50.0,
			    "locationName": "rack2"
		    }
      ]
    }
  ];  

  constructor() {}

  getMedicines(query: string):string[] {
    // Return the medicines filtered by the query
    return this.allMedicines.map(i => i.medicineName);
  }

  getMedicineDetailsForSelectedMedicine(medicineName: String): MedicineDTO[] {
    const medicine = this.allMedicines.find(med => med.medicineName === medicineName);
      if (medicine) {
        return medicine.details;
      }

    return [];
  }

  getCompaniesForMedicine(mapKey : String): string[] {
    let medicineFromKey = mapKey.split('|')[0];
    let typeFromKey = mapKey.split('|')[1];
    const medicine = this.allMedicines.find(med => med.medicineName === medicineFromKey);
     if (medicine) {
      // Extract company names from the details array
      return Array.from(new Set(medicine.details.filter (type=> type.medicineType === typeFromKey).map(detail => detail.companyName)));
    }
    return [];
  }

  getTypesOfMedicine(medicineName: string): string[] {
        const medicine = this.allMedicines.find(med => med.medicineName === medicineName);
       if (medicine) {
      // Extract company names from the details array
      return Array.from(new Set(medicine.details.map(detail => detail.medicineType)));
    }
    return [];
  }

  getLocationsForCompany(mapKey:string): string[] {
    let currentMedicine =  mapKey.split('|')[0];
    let currentType = mapKey.split('|')[1];
    let currentCompany = mapKey.split('|')[2];
    const medicine = this.allMedicines.find(med => med.medicineName === currentMedicine);
    if (medicine) {
     // Extract company names from the details array
     let x= Array.from(new Set(medicine.details.filter (type=> type.medicineType === currentType && type.companyName === currentCompany).map(detail => detail.locationName)));
     return Array.from(new Set(medicine.details.filter (type=> type.medicineType === currentType && type.companyName === currentCompany).map(detail => detail.locationName)));
   }
   return [];
}

getperUnitPrice(mapKey:string) : number {
  let currentMedicine =  mapKey.split('|')[0];
  let currentType = mapKey.split('|')[1];
  let currentCompany = mapKey.split('|')[2];
  const medicine = this.allMedicines.find(med => med.medicineName === currentMedicine);
  let pricePerUnit = 0.0; 
  if (medicine) {
    let currObj =  medicine.details.filter(med=> med.medicineType === currentType && med.companyName === currentCompany);
    pricePerUnit=currObj.at(0)?.pricePerUnit;
 
  }
  return pricePerUnit;
}
}
