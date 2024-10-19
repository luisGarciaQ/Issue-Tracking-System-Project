import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';  // Import RegisterComponent



const routes: Routes = [
  {
    path: '',  // Remove the forward slash
    component: LoginComponent,
  },
  { path: 'register', component: RegisterComponent }, // Default route (landing page)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

