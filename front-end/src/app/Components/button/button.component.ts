import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit{
  @Input() text!: String;
  // @Output() onDeleteTask: EventEmitter<String> = new EventEmitter()
  @Output() clicked = new EventEmitter<void>();
  
  constructor() {}
  ngOnInit(): void {}
  
  OClick(){
    this.clicked.emit();
    // console.log("emit")
  }
  // onDelete() {
  //   this.onDeleteTask.emit("test");
  // }
}
