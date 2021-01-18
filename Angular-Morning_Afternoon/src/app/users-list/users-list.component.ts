import { Component, OnInit } from '@angular/core';
import { SvcService } from '../svc.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {

  allUsersList;

  constructor( public svcService: SvcService) { }

  ngOnInit(): void {
    this.getAllUserDetails();
  }

  getAllUserDetails(){
    this.svcService.sendDetails();
    this.svcService.obs.subscribe( record =>{
      this.allUsersList = record;
    })
  }

}
