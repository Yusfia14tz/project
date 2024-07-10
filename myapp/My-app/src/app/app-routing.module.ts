import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { AttendanceComponent } from './attendance/attendance.component';
import { AttendanceTrComponent } from './attendance-tr/attendance-tr.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  {path:'dashboard', component:DashboardComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component:RegisterComponent },
  { path: 'forget-password', component: ForgetPasswordComponent},
  { path: 'attendance', component: AttendanceComponent },
  
  
  
  { path: 'attendance1', component: AttendanceTrComponent , children:
    [
      { path: 'attendance', component: AttendanceComponent }
    ]},

];

 


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
