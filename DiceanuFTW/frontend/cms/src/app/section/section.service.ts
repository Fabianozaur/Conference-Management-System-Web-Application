import {Injectable} from '@angular/core';
import {Section} from './section.interface';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SectionService {


  private url = 'http://localhost:8080/conferenceSections';
  private currentSection: Section | undefined;

  constructor(private httpClient: HttpClient) {
  }

  getAllSections(): Observable<Section[]> {
    return this.httpClient
      .get<Array<Section>>(this.url);
    // const section1: Section = {
    //   ID: '1',
    //   Name: 'section1',
    //   Supervisor: 'supervisor1',
    //   NumberOfParticipants: 5,
    //   Room: 'room1',
    // };
    //
    // const section2: Section = {
    //   ID: '2',
    //   Name: 'section2',
    //   Supervisor: 'supervisor2',
    //   NumberOfParticipants: 100,
    //   Room: 'room2',
    // };
    //
    // const section3: Section = {
    //   ID: '3',
    //   Name: 'section3',
    //   Supervisor: 'supervisor3',
    //   NumberOfParticipants: 70,
    //   Room: 'room3',
    // };
    //
    // const section4: Section = {
    //   ID: '4',
    //   Name: 'section4',
    //   Supervisor: 'supervisor4',
    //   NumberOfParticipants: 300,
    //   Room: 'room4',
    // };
    //
    // return [section1, section2, section3, section4];
  }

  public SetCurrentSection(section: Section): void {
    this.currentSection = section;
  }

  public GetCurrentSection(): Section {
    return this.currentSection as Section;
  }

  saveSection(section: Section): Observable<Section> {
    return this.httpClient
      .post<Section>(this.url, section);
  }

  updateSection(section: Section): Observable<Section> {
    return this.httpClient
      .put<Section>(this.url, section);
  }
}
