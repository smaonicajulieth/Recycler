import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCentrosAdminComponent } from './list-centros-admin.component';

describe('ListCentrosAdminComponent', () => {
  let component: ListCentrosAdminComponent;
  let fixture: ComponentFixture<ListCentrosAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCentrosAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCentrosAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
