import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { SvcService } from '../svc.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})

export class EditUserComponent implements OnInit {

  @Input()
  userDetail;

  @Output()
  updated: EventEmitter<any> = new EventEmitter();

  constructor( public svcService: SvcService) { }

  editUserFG = new FormGroup({
    name : new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
    id : new FormControl('', [Validators.required, Validators.min(100), Validators.max(200)]),
    age : new FormControl('', [Validators.required, Validators.min(18), Validators.max(100)]),
    dob : new FormControl('', Validators.required),
  })

  updatedUserDetails: any;
  isSuccessful:boolean = false;

  ngOnInit(): void {
    this.editUserFG.get('name').setValue(this.userDetail.name);
    this.editUserFG.get('id').setValue(this.userDetail.id);
    this.editUserFG.get('age').setValue(this.userDetail.age);
    this.editUserFG.get('dob').setValue(this.userDetail.dob);
  }

  updateUser(){
    if(this.editUserFG.valid){
      this.updatedUserDetails = {
        name: this.editUserFG.get('name').value,
        id: this.editUserFG.get('id').value,
        age: this.editUserFG.get('age').value,
        dob: this.editUserFG.get('dob').value,
      };
      this.svcService.editRecord(this.userDetail , this.updatedUserDetails);
    }
  }

}
