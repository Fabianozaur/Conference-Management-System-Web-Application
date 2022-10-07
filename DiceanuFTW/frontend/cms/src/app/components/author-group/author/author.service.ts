import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Author} from './author.interface';
import {catchError} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  getAllAthletesURL = 'http://localhost:8080/users/AuthorsBasic';
  updateUserURL = 'http://localhost:8080/users/update';

  constructor(private httpClient: HttpClient) {
  }

  getAllAuthors(): Observable<Array<Author>> {
    return this.httpClient.get<Array<Author>>(this.getAllAthletesURL)
      .pipe(catchError(this.handleError<Array<Author>>('getAllAuthors', undefined)));
  }

  makeUserAuthor(userEmail: string): any {
    return this.httpClient.put(this.updateUserURL, {email: userEmail, role: 'AUTHOR'})
      .pipe(catchError(this.handleError<string>('makeUserAuthor', userEmail)));
  }


  /**
   * Author ~David
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T): any {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
