import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SvcService {

  userDetails:any = [];

  userDetailsBS = new BehaviorSubject({});
  obs = this.userDetailsBS.asObservable();

  constructor( public httpClient : HttpClient) { }

  sendDetails(){
    // console.log("INSIDE SEND Details");
    // console.log(typeof this.userDetails);
    // console.log(this.userDetails);
    this.userDetailsBS.next(this.userDetails);
  }

  addRecord(newUserDetails){
    // console.log("INSIDE ADD Record");
    // console.log(typeof newUserDetails);
    // console.log(newUserDetails);
    this.userDetails.push(newUserDetails);
  }

  editRecord(oldRecord, newRecord){
    // console.log("INSIDE EDIT Record");
    // console.log(typeof oldRecord);
    // console.log(oldRecord);
    // console.log(typeof newRecord);
    // console.log(newRecord);
    this.userDetails[this.userDetails.indexOf(oldRecord)] = newRecord;
  }

  deleteRecord(userIDX){
    // console.log("INSIDE DELETE Record");
    // console.log(typeof userIDX);
    // console.log(userIDX);
    this.userDetails.splice(
      this.userDetails.indexOf(userIDX),1);
  }
}
