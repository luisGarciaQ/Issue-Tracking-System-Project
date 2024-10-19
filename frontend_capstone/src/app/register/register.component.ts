import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ImageLoaderService } from '../image-loader.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  logoUrl: string ='';

  constructor(private formBuilder: FormBuilder, private imageLoader: ImageLoaderService) {
    // Initialize the form with fields and validators
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required]]
    }, {
      // Custom validator to check that password and confirm password match
      validators: this.mustMatch('password', 'confirmPassword')
    });
  }

  ngOnInit(): void 
  {
    this.loadLogo();
  }

  loadLogo() {
    const logoUrl = 'https://avatars.githubusercontent.com/u/124091983';
    this.imageLoader.loadImage(logoUrl).subscribe((blob: Blob) => {
      this.logoUrl = URL.createObjectURL(blob);
    });
  }

  // Custom validator to check if password and confirmPassword fields match
  mustMatch(password: string, confirmPassword: string) {
    return (formGroup: FormGroup) => {
      const passControl = formGroup.controls[password];
      const confirmPassControl = formGroup.controls[confirmPassword];

      if (confirmPassControl.errors && !confirmPassControl.errors['mustMatch']) {
        // If another validator has already found an error, skip
        return;
      }

      // Set an error on confirmPassword if validation fails
      if (passControl.value !== confirmPassControl.value) {
        confirmPassControl.setErrors({ mustMatch: true });
      } else {
        confirmPassControl.setErrors(null);
      }
    };
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      console.log('Registration successful', this.registerForm.value);
      // Implement your registration logic here (e.g., send data to the backend)
    } else {
      console.log('Form is invalid');
    }
  }
}