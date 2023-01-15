import {Component, OnInit, Input} from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  @Input() text!: String;

  title: String = "hello world";
  constructor() {}
  ngOnInit(): void {}

  buttonEvent(){
    console.log("botona tclicat parent")
  }
  buttonEvents(){
    console.log("botona tclicat")
  }
  deleteTask(s:String){

}
}
