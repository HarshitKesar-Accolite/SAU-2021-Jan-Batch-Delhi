import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SvcService } from '../svc.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})

export class AddUserComponent implements OnInit {

  addUserFG = new FormGroup({
    name : new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
    id : new FormControl('', [Validators.required, Validators.min(100), Validators.max(200)]),
    age : new FormControl('', [Validators.required, Validators.min(18), Validators.max(100)]),
    dob : new FormControl('', Validators.required),
  })

  //taking variables for creating a object from addUserFG
  name;
  id;
  age;
  dob;
  newUserDetails: any;
  isSuccessful:boolean = false;

  constructor( public svcService: SvcService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    if(this.addUserFG.valid){
      this.newUserDetails = {
        name: this.addUserFG.get('name').value,
        id: this.addUserFG.get('id').value,
        age: this.addUserFG.get('age').value,
        dob: this.addUserFG.get('dob').value,
      }
      this.svcService.addRecord(this.newUserDetails);
      this.addUserFG.get('name').setValue('');
      this.addUserFG.get('id').setValue('');
      this.addUserFG.get('age').setValue('');
      this.isSuccessful = true;
    }
  }
}
