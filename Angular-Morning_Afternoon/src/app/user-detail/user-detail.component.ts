import { Component, Input, OnInit, Output } from '@angular/core';
import { SvcService } from '../svc.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.scss']
})
export class UserDetailComponent implements OnInit {

  @Input()
  user;

  editDetails:boolean = false;

  constructor( public svcService: SvcService) { }

  ngOnInit(): void {
  }

  updatedSucessfully(){
    this.editDetails = false;
  }

  deleteUser(){
    this.svcService.deleteRecord(this.user);
  }

  editUser(){
    this.editDetails = !this.editDetails;
  }

}
