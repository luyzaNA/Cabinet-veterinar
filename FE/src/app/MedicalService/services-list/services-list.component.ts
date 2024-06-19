import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MedicalOperationService } from '../../Service/MedicalOperation.service';
import { MedicalOperationI } from '../../../Shared/MedicalOperation.entity';

@Component({
  selector: 'app-services-list',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './services-list.component.html',
  styleUrl: './services-list.component.css'
})
export class ServicesListComponent implements OnInit {
  displayedColumns: string[] = ['position', 'name', 'price'];
  dataSource: MatTableDataSource<MedicalOperationI>;

  constructor(private medicalOperationService: MedicalOperationService) {
    this.dataSource = new MatTableDataSource<MedicalOperationI>();
  }

  ngOnInit(): void {
    this.getAllMedicalOperations();
  }

  getAllMedicalOperations(): void {
    this.medicalOperationService.getAllMedicalOperations().subscribe(
      (data: MedicalOperationI[]) => {
        this.dataSource.data = data;
        console.log(data)
      },
      (error) => {
        console.error('Error fetching medical operations:', error);
      }
    );
  }
}
