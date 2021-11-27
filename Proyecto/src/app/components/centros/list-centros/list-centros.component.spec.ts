import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCentrosComponent } from './list-centros.component';

describe('ListCentrosComponent', () => {
  let component: ListCentrosComponent;
  let fixture: ComponentFixture<ListCentrosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCentrosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCentrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
