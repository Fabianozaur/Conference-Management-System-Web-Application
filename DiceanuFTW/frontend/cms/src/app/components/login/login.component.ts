import {Component, Injectable} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable()
export class LoginComponent {

  const;
  backendUrl = 'http://localhost:8080';

  model: any = {};

  constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient) {
  }

  login(): void {
    const url = this.backendUrl + '/user/login';

    this.http
      .post(url, {
        email: this.model.email,
        password: this.model.password
      })
      .subscribe(
        successResponse => {
          console.log(successResponse);
          const response: any = successResponse;
          sessionStorage.setItem('userEmail', response.email);
          sessionStorage.setItem('userRole', response.role);
          this.router.navigate(['']).then();
          Swal.fire({
            title: 'Successful login!',
            icon: 'success'
          }).then();
        },
        errorResponse => {
          console.log(errorResponse);
          Swal.fire({
            title: 'Invalid Login',
            text: 'The email or password do not match.',
            icon: 'error'
          }).then();
        }
      );
  }

  signup(): void {
    const url = this.backendUrl + '/user/signup';
    this.http
      .post(url, {
        email: this.model.email,
        password: this.model.password
      })
      .subscribe(
        successResponse => {
          console.log(successResponse);
          const response: any = successResponse;
          sessionStorage.setItem('userEmail', response.email);
          sessionStorage.setItem('userRole', response.role);
          Swal.fire({
            title: 'Successful sign up!',
            icon: 'success'
          }).then();
        },
        errorResponse => {
          console.log(errorResponse);
          Swal.fire({
            title: 'Invalid Credentials',
            text: 'The email is already used.',
            icon: 'error'
          }).then();
        }
      );
  }

}
