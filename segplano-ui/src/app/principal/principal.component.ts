import { Component, OnInit } from '@angular/core';
import { Util } from '../util/util';

@Component({
  selector: 'principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {


  addUserImage: string = Util.getBaseUrl()+'/assets/adduser.svg'
  dealImage: string = Util.getBaseUrl()+'/assets/deal.svg'

  constructor() { }

  ngOnInit() {
  }

}
