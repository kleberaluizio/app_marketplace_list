import { TestBed } from '@angular/core/testing';

import { ListOfItemService } from './list-of-item.service';

describe('ListOfItemService', () => {
  let service: ListOfItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListOfItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
