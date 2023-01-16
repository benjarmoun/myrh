import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentDashComponent } from './agent-dash.component';

describe('AgentDashComponent', () => {
  let component: AgentDashComponent;
  let fixture: ComponentFixture<AgentDashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentDashComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgentDashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
