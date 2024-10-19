import { Component , OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ImageLoaderService } from '../image-loader.service';
import { LoginRequest } from '../models/LoginRequest';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  logoUrl: string = '';

  constructor(private formBuilder: FormBuilder,private imageLoader: ImageLoaderService, private httpService: AuthService) {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(5)]]
    });
  }
  
  ngOnInit(): void {
    this.loadLogo();
  }
  loadLogo() {
    const logoUrl = 'https://avatars.githubusercontent.com/u/124091983';
    this.imageLoader.loadImage(logoUrl).subscribe((blob: Blob) => {
      this.logoUrl = URL.createObjectURL(blob);
    });
  }
  onSubmit(): void {
    if (this.loginForm.valid) {
      const login: LoginRequest = 
      {
        username: this.loginForm.get('username')?.value,
        password: this.loginForm.get('password')?.value
      }

      console.log('Login request: ', login);

      this.httpService.authenticateLogin(login).subscribe(
        (token) => {
          console.log(token);
          // Store token (e.g., in localStorage or sessionStorage)
        },
        error => {
          console.error('Login failed:', error);
          // Handle the error (e.g., show an error message)
        }
      );
    } else {
      return;
    }
  }
}

